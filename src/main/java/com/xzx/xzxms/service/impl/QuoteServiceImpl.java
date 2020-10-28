package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.*;
import com.xzx.xzxms.bean.extend.QuoteExtend;
import com.xzx.xzxms.bean.extend.QuoteExtendInquiry;
import com.xzx.xzxms.bean.extend.SysFileExtend;
import com.xzx.xzxms.dao.*;
import com.xzx.xzxms.dao.extend.QuoteAndInquiryExtendMapper;
import com.xzx.xzxms.dao.redis.JedisDao;
import com.xzx.xzxms.service.IFileUploadService;
import com.xzx.xzxms.service.IQuoteService;
import com.xzx.xzxms.utils.Base64Util;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import com.xzx.xzxms.utils.POIExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class QuoteServiceImpl implements IQuoteService {
    @Resource
    private QuoteMapper quoteMapper;
    @Autowired
    private JedisDao jedisDaoImpl;
    @Resource
    private IFileUploadService fileUploadServiceImpl;
    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private SysProDetailCheckMapper sysProDetailCheckMapper;
    @Resource
    private InquiryMapper inquiryMapper;
    @Override
    public List<Quote> findByInquiryId(long inquiryId) {
        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiryId).andIsActiveEqualTo(1);
        return quoteMapper.selectByExample(example);
    }
    @Transactional
    @Override
    public void saveOrUpdate(QuoteExtend quote) {
        long time = new Date().getTime();
        long operatorId = quote.getOperator();
        if (quote.getId() != null){
            List<SysFile> files = quote.getFiles();
            if (files != null && files.size() > 0  ) {
                for ( SysFile file : files ) {
                    file.setTime(time);
                    file.setIsActive(1);
                    file.setIsUseful(1);
                    file.setOperator(operatorId);
                    // 报价文件
                    if(file.getType() == SysFileExtend.TYPE_QUOTE) {
                        SysFileExample example = new SysFileExample();
                        example.createCriteria().andOtherIdEqualTo(quote.getId()).andTypeEqualTo(SysFileExtend.TYPE_QUOTE);
                        List<SysFile> sysFiles = sysFileMapper.selectByExample(example);
                        //替换
                        if (sysFiles.size() > 0){
                            sysFileMapper.updateByExampleSelective(file, example);
                        }else {
                            //插入
                            if(jedisDaoImpl.exists(file.getId().toString())) {
                                //从redis中取出base64文件码
                                String base64File = jedisDaoImpl.get(file.getId().toString());
                                //解码，还原成输入流
                                InputStream inputStream = Base64Util.decodeBase64File(base64File);
                                System.out.println("redis");
                                //清除redis该文件缓存
                                jedisDaoImpl.del(file.getId().toString());
                                //上传到Nginx
                                Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());

                                String url = map.get("url").toString();
                                //文件信息持久化到数据库
                                file.setType(SysFileExtend.TYPE_QUOTE);
                                file.setOtherId(quote.getId());
                                file.setUrl(url);

                                sysFileMapper.insert(file);
                                System.out.println("数据库");
                            }
                        }
                    }else if(file.getType() == SysFileExtend.TYPE_TECHNOLOGY){
                        // 技术文件
                        if(jedisDaoImpl.exists(file.getId().toString())) {
                            //从redis中取出base64文件码
                            String base64File = jedisDaoImpl.get(file.getId().toString());
                            //解码，还原成输入流
                            InputStream inputStream = Base64Util.decodeBase64File(base64File);
                            System.out.println("redis");
                            //清除redis该文件缓存
                            jedisDaoImpl.del(file.getId().toString());
                            //上传到Nginx
                            Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());
                            String url = map.get("url").toString();
                            //文件信息持久化到数据库
                            file.setType(SysFileExtend.TYPE_TECHNOLOGY);
                            file.setOtherId(quote.getId());
                            file.setUrl(url);
                            sysFileMapper.insert(file);
                            System.out.println("数据库");
                        }
                    }
                }
            }
        }else {
            long quoteId = IDUtils.getId();
            //文件上传
            List<SysFile> files = quote.getFiles();
            for (SysFile file:files) {
                //如果redis中存在该文件
                if(jedisDaoImpl.exists(file.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(file.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    System.out.println("redis");
                    //清除redis该文件缓存
                    jedisDaoImpl.del(file.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());
                    String url = map.get("url").toString();
                    System.out.println(map.get("url"));
                    //文件信息持久化到数据库
                    file.setType(SysFileExtend.TYPE_QUOTE);
                    file.setOtherId(quoteId);
                    file.setTime(time);
                    file.setUrl(url);
                    file.setIsActive(1);
                    file.setIsUseful(1);
                    sysFileMapper.insert(file);
                    System.out.println("数据库");
                }
            }
        }
    }
    @Transactional
    @Override
    public void batchAddQuote(QuoteExtend quote) throws IOException {
        List<SysFile> files = quote.getFiles();
        if(files.size() > 0) {
            long operator = quote.getOperator();
            long time = new Date().getTime();
            long proDetailId = quote.getProDetailId();
            SysFile file = files.get(0);
            //如果redis中存在该文件
            if(jedisDaoImpl.exists(file.getId().toString())) {
                //1.从redis中取出base64文件码
                String base64File = jedisDaoImpl.get(file.getId().toString());
                //解码，还原成输入流
                InputStream inputStream = Base64Util.decodeBase64File(base64File);
                //解析excel
                List<Map<String, Object>> dataFromExcel = POIExcelUtils.getDataFromExcel(inputStream);

                //清除redis该文件缓存
                jedisDaoImpl.del(file.getId().toString());
                //上传到Nginx
                Map<String, Object> excelUploadMap = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());

                String excelUrl = excelUploadMap.get("url").toString();
                //2.报价信息存入数据库报价表

                String name = "";
                String params = "";
                long inquiryId = -1L;
                SysFile sysFile = new SysFile();
                for (Map<String, Object> item : dataFromExcel) {
                    String imgUrl = "";
                    String nameExcel = item.get("设备名称").toString();
                    String paramsExcel = item.get("技术要求").toString();
                    if (name.equals(nameExcel) && params.equals(paramsExcel)){
                    }else {
                        name = item.get("设备名称").toString();
                        params = item.get("技术要求").toString();
                        InquiryExample example = new InquiryExample();
                        example.createCriteria().andNameEqualTo(name).andParamsEqualTo(params).andProDetailIdEqualTo(proDetailId);
                        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
                        if (inquiries.size() > 0) {
                            Inquiry inquiry = inquiries.get(0);
                            inquiryId =  inquiry.getId();
                            inquiry.setIsUseful(1);
                            inquiryMapper.updateByPrimaryKeySelective(inquiry);
                        }else {
                            throw new CustomerException("找不到对应的询价函");
                        }
                    }
                    QuoteExample quoteExample = new QuoteExample();
                    String supplier = item.get("供应商").toString().trim();
                    quoteExample.createCriteria().andSupplierEqualTo(supplier).andInquiryIdEqualTo(inquiryId);
                    List<Quote> quotes = quoteMapper.selectByExample(quoteExample);
                    if (quotes.size() > 0) {
                        throw new CustomerException("文件中： ["+supplier+"]  数据已存在");
                    }
                    Quote q = new Quote();
                    long quoteId = IDUtils.getId();
                    q.setId(quoteId);
                    q.setIsActive(1);
                    q.setIsUseful(0);
                    q.setOperator(operator);
                    q.setSuDelivery(Long.parseLong(item.get("货期").toString().trim()));
                    q.setSuModel(item.get("报价品牌型号").toString().trim());
                    q.setSuParams(item.get("实际技术参数").toString().trim());
                    q.setSupplier(supplier);
                    q.setSuPrice(Double.parseDouble(item.get("设备单价").toString().trim()));
                    q.setSuRemark(item.get("备注").toString().trim());
                    q.setSuTotalPrice(Double.parseDouble(item.get("设备总价").toString().trim()));
                    q.setTime(time);
                    q.setWarranty(Long.parseLong(item.get("质保期/售后").toString().trim()));
                    q.setInquiryId(inquiryId);

                    if(item.get("图片") != null && !"".equals(item.get("图片").toString().trim())) {
                        InputStream is = (InputStream)item.get("图片");
                        String imgType = item.get("imgType").toString();
                        String imgName = item.get("供应商").toString().trim() + name + "报价设备图." + imgType;
                        Map<String, Object> uploadResult = fileUploadServiceImpl.uploadByStream(is, imgName);
                        if (uploadResult.get("url")!=null){
                            imgUrl = uploadResult.get("url").toString();
                        }else {
                            throw new CustomerException("excel中图片上传失败");
                        }
                    }
                    q.setImage(imgUrl);
                    quoteMapper.insert(q);

                    //3.报价信息存入文件表
                    sysFile.setId(IDUtils.getId());
                    sysFile.setIsActive(1);
                    sysFile.setIsUseful(1);
                    sysFile.setName(excelUploadMap.get("name").toString());
                    sysFile.setOperator(operator);
                    sysFile.setOtherId(quoteId);
                    sysFile.setTime(time);
                    sysFile.setType(SysFileExtend.TYPE_QUOTE);
                    sysFile.setUrl(excelUrl);
                    sysFileMapper.insert(sysFile);

                    //4.给每条报价添加审核记录
                    //查询所属项目的审核流程
                    SysProDetailCheckExample example = new SysProDetailCheckExample();
                    example.createCriteria().andProDetailIdEqualTo(proDetailId);
                    List<SysProDetailCheck> sysProDetailChecks = sysProDetailCheckMapper.selectByExample(example);
                    // 根据项目审核流程插入报价审核流程
                    SysProCheck proCheck = new SysProCheck();
                    if (sysProDetailChecks.size() > 0) {
                        for (SysProDetailCheck sysProDetailCheck : sysProDetailChecks ) {
                            proCheck.setId(IDUtils.getId());
                            proCheck.setOperator(operator);
                            proCheck.setTime(time);
                            proCheck.setType(sysProDetailCheck.getCheckName());
                            proCheck.setCheckStatus(0);
                            proCheck.setContentId(quoteId);
                            sysProCheckMapper.insertSelective(proCheck);
                        }
                    }else {
                        throw new CustomerException("所属项目没有添加审核");
                    }
                }
            }else {
                throw new CustomerException("文件信息过期，请重新上传");
            }
        }
    }

    @Override
    public void rowSave(Quote quote) {
        quoteMapper.updateByPrimaryKeySelective(quote);
    }

    @Resource
    private QuoteAndInquiryExtendMapper quoteAndInquiry;


    @Override
    public List<QuoteExtendInquiry> findBySupplierOrPro(String supplier, long proId) {

        List<QuoteExtendInquiry> list = quoteAndInquiry.findBySupplierOrPro(supplier,proId);
        return list;
    }
}
