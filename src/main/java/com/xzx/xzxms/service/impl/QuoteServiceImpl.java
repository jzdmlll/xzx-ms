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
import org.apache.commons.lang.StringUtils;
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
    private InquiryMapper inquiryMapper;
    @Resource
    private QuoteAndInquiryExtendMapper quoteAndInquiry;
    @Resource
    private ProPoolMapper proPoolMapper;

    @Override
    public List<Quote> findByInquiryId(long inquiryId) {

        List<Quote> list = null;
        Inquiry inquiry = inquiryMapper.selectByPrimaryKey(inquiryId);
        //若不需要询价  则相关报价信息从产品池中选用的产品查询  反之从报价表中查询
        if (inquiry.getIsinquiry() == 0){
            ProPoolExample example = new ProPoolExample();
            example.createCriteria().andNameEqualTo(inquiry.getName()).andChooseEqualTo(1);
            List<ProPool> proPools = proPoolMapper.selectByExample(example);
            Quote quote = new Quote();
            for (ProPool p : proPools) {
                quote.setId(p.getId());
                quote.setSupplier(p.getSupplier());
                quote.setSuModel(p.getModel());
                quote.setSuBrand(p.getBrand());
                quote.setSuParams(p.getParams());
                quote.setSuPrice(p.getPrice());
                quote.setSuDelivery(p.getDelivery());
                quote.setSuRemark(p.getRemark());
                list.add(quote);
            }
        }else {
            QuoteExample example = new QuoteExample();
            example.createCriteria().andInquiryIdEqualTo(inquiryId).andIsActiveEqualTo(1);
            list = quoteMapper.selectByExample(example);
        }

        return list;
    }
    @Transactional
    @Override
    public synchronized void saveOrUpdate(QuoteExtend quote) {
        long time = new Date().getTime();
        long operatorId = quote.getOperator();
        if (quote.getId() != null){
            Quote quote1 = quoteMapper.selectByPrimaryKey(quote.getId());
            if(quote1!=null) {
                if (quote1.getIsUseful() == 1){
                    throw new CustomerException("请撤销审核再提交文件修改");
                }
            }
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
                        if(jedisDaoImpl.exists(file.getId().toString())) {
                            long startTime = System.currentTimeMillis(); //获取开始时间
                            //从redis中取出base64文件码
                            String base64File = jedisDaoImpl.get(file.getId().toString());
                            //解码，还原成输入流
                            InputStream inputStream = Base64Util.decodeBase64File(base64File);
                            long redisTime = System.currentTimeMillis(); //获取开始时间
                            System.out.println("redis" + (redisTime - startTime) + "ms");
                            //清除redis该文件缓存
                            jedisDaoImpl.del(file.getId().toString());
                            //上传到Nginx
                            Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());
                            long ftpTime = System.currentTimeMillis(); //获取开始时间
                            System.out.println("sftp上传" + (ftpTime - redisTime) + "ms");
                            String url = map.get("url").toString();
                            //文件信息持久化到数据库
                            file.setType(SysFileExtend.TYPE_QUOTE);
                            file.setTime(time);
                            file.setIsActive(1);
                            file.setIsUseful(1);
                            file.setOperator(operatorId);
                            file.setName(map.get("fileName").toString());
                            file.setOtherId(quote.getId());
                            file.setUrl(url);
                        }
                        if (sysFiles.size() > 0){
                            sysFileMapper.updateByExampleSelective(file, example);
                        }else {
                            sysFileMapper.insert(file);
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
                            file.setTime(time);
                            file.setIsActive(1);
                            file.setIsUseful(1);
                            file.setOperator(operatorId);
                            file.setOtherId(quote.getId());
                            file.setName(map.get("fileName").toString());
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
                InputStream temp = Base64Util.decodeBase64File(base64File);
                //上传到Nginx
                Map<String, Object> excelUploadMap = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());
                //解析excel
                List<Map<String, Object>> dataFromExcel = POIExcelUtils.getDataFromExcel(temp);

                //清除redis该文件缓存
                jedisDaoImpl.del(file.getId().toString());
                String excelUrl = excelUploadMap.get("url").toString();
                //2.报价信息存入数据库报价表

                String name = "";
                String params = "";
                long inquiryId = -1L;
                SysFile sysFile = new SysFile();
                String notFound = "";
                for (Map<String, Object> item : dataFromExcel) {
                    String imgUrl = "";
                    String nameExcel = item.get("设备名称").toString();
                    String paramsExcel = item.get("技术要求").toString();

                    if (name.equals(nameExcel) && params.equals(paramsExcel)){

                    }else {
                        name = item.get("设备名称").toString();
                        params = item.get("技术要求").toString();
                        InquiryExample example = new InquiryExample();
                        example.createCriteria().andNameEqualTo(name).andParamsEqualTo(params).andIsActiveEqualTo(1).andProDetailIdEqualTo(proDetailId);
                        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
                        if (inquiries.size() > 0) {
                            Inquiry inquiry = inquiries.get(0);
                            if (inquiry.getIsinquiry() == 0){
                                throw new CustomerException("文件中:  ["+name+"   :"+params+"]  已被设定为不需询价，无法导入报价单,如需导入请修改!");
                            }

                        }else {
                            notFound += "["+name+" "+params+"]----";
                        }
                    }
                    if("".equals(notFound)){
                        QuoteExample quoteExample = new QuoteExample();
                        String supplier = item.get("供应商").toString().trim();
                        quoteExample.createCriteria().andSupplierEqualTo(supplier).andInquiryIdEqualTo(inquiryId).andIsActiveEqualTo(1);
                        List<Quote> quotes = quoteMapper.selectByExample(quoteExample);

                        if (quotes.size() > 0) {
                            //该条报价存在则不能重复插入，正好限制该条报价不能发生修改  无需再判断该条报价是否被审核过
                            throw new CustomerException("文件中： ["+supplier+"]  数据已存在");
                        }
                        Quote q = new Quote();
                        long quoteId = IDUtils.getId();
                        try {
                            q.setId(quoteId);
                            q.setIsActive(1);
                            q.setIsUseful(0);
                            q.setOperator(operator);
                            q.setSuDelivery(item.get("货期").toString().trim());
                            q.setSuModel(item.get("报价型号").toString().trim());
                            q.setSuBrand(item.get("报价品牌").toString().trim());
                            q.setSuParams(item.get("实际技术参数").toString().trim());
                            q.setSupplier(supplier);

                            if(StringUtils.isEmpty(item.get("设备单价").toString().trim())){
                                q.setSuPrice(0D);
                            }else{
                                q.setSuPrice(Double.parseDouble(item.get("设备单价").toString().trim()));
                            }
                            if(StringUtils.isEmpty(item.get("设备总价").toString().trim())){
                                q.setSuTotalPrice(0D);
                            }else{
                                q.setSuTotalPrice(Double.parseDouble(item.get("设备总价").toString().trim()));
                            }
                            q.setSuRemark(item.get("备注").toString().trim());
                            q.setTime(time);
                            q.setWarranty(item.get("质保期/售后").toString().trim());
                            q.setInquiryId(inquiryId);
                            //数据来源于外部数据  标志为1
                            q.setDataSource(1);
                        }catch (NumberFormatException exception) {
                            throw new CustomerException("失败，存在数据格式不正确"+exception.getMessage());
                        }
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
                        /*SysProDetailCheckExample example = new SysProDetailCheckExample();
                        example.createCriteria().andProDetailIdEqualTo(proDetailId);
                        List<SysProDetailCheck> sysProDetailChecks = sysProDetailCheckMapper.selectByExample(example);*/
                        // 根据项目审核流程插入报价审核流程
                        /*SysProCheck proCheck = new SysProCheck();
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
                            //还需添加比价审核
                            proCheck.setId(IDUtils.getId());
                            proCheck.setId(IDUtils.getId());
                            proCheck.setOperator(operator);
                            proCheck.setTime(time);
                            proCheck.setType("比价审核");
                            proCheck.setCheckStatus(0);
                            proCheck.setContentId(quoteId);
                            sysProCheckMapper.insertSelective(proCheck);
                        }else {
                            throw new CustomerException("所属项目没有添加审核");
                        }*/
                        //逐条插入审核
                        SysProCheck sysProCheck = new SysProCheck();
                        sysProCheck.setId(IDUtils.getId());
                        sysProCheck.setTechnicalAudit(0);
                        sysProCheck.setBusinessAudit(0);
                        sysProCheck.setCompareAudit(0);
                        sysProCheck.setFinallyAudit(0);
                        sysProCheck.setTechnicalRemark("");
                        sysProCheck.setBusinessRemark("");
                        sysProCheck.setCompareRemark("");
                        sysProCheck.setFinallyRemark("");
                        sysProCheck.setQuoteId(quoteId);
                        sysProCheck.setOperator(operator);
                        sysProCheck.setTime(time);
                        sysProCheckMapper.insertSelective(sysProCheck);
                    }
                }
                if(!"".equals(notFound)){
                    throw new CustomerException("找不到对应询价函;提示："+notFound);
                }
            }else {
                throw new CustomerException("文件信息过期，请重新上传");
            }
        }
    }

    @Override
    public void rowSave(Quote quote) {
        Quote quote1 = quoteMapper.selectByPrimaryKey(quote.getId());
        if (quote1.getIsUseful() == 0){
            quoteMapper.updateByPrimaryKeySelective(quote);
        }else {
            throw new CustomerException("请撤销审核后再修改!");
        }
    }

    @Override
    public List<QuoteExtendInquiry> findBySupplierOrPro(String supplier, long proId) {

        List<QuoteExtendInquiry> list = quoteAndInquiry.findBySupplierOrPro(supplier,proId);
        return list;
    }

    @Transactional
    @Override
    public void batchSetInvalid(long[] ids) {

        for (long id : ids){
            Quote quote=quoteMapper.selectByPrimaryKey(id);
            if (quote != null || quote.getIsActive() != 0){
                if(quote.getIsUseful() == 1){
                    throw new CustomerException("该报价信息已经被审核，无法删除");
                }
                quote.setIsActive(0);
                quoteMapper.updateByPrimaryKeySelective(quote);
                // 报价逻辑删除时，将对应审核删除
                SysProCheckExample example = new SysProCheckExample();
                example.createCriteria().andQuoteIdEqualTo(quote.getId());
                List<SysProCheck> sysProChecks = sysProCheckMapper.selectByExample(example);
                if(sysProChecks.size() > 0) {
                    for(SysProCheck proCheck : sysProChecks) {
                        sysProCheckMapper.deleteByPrimaryKey(proCheck.getId());
                    }
                }
            }else {
                throw new CustomerException("该数据已不存在");
            }
        }
    }

    @Transactional
    @Override
    public void chooseProductPoolSupplier(long inquiryId, long productPoolId, long operator) {

        Quote quote = new Quote();
        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiryId).andDataSourceEqualTo(0);
        List<Quote> quotes = quoteMapper.selectByExample(example);
        if(1 == quotes.get(0).getIsUseful()){
            throw new CustomerException("此条询价内容以被审核，无法修改!");
        }
        if (quotes.size() > 0){
            //存在先删除后添加
            quoteMapper.deleteByPrimaryKey(quotes.get(0).getId());
        }
        ProPool proPool = proPoolMapper.selectByPrimaryKey(productPoolId);
        long quoteId = IDUtils.getId();
        long time = new Date().getTime();

        quote.setId(quoteId);
        quote.setSupplier(proPool.getSupplier());
        quote.setSuModel(proPool.getModel());
        quote.setSuBrand(proPool.getBrand());
        quote.setSuParams(proPool.getParams());
        quote.setSuPrice(proPool.getPrice());
        quote.setSuDelivery(proPool.getDelivery());
        quote.setSuRemark(proPool.getRemark());
        quote.setImage(proPool.getImage());
        quote.setDataSource(0);
        quote.setInquiryId(inquiryId);
        quote.setIsActive(1);
        quote.setIsUseful(0);
        quote.setTime(time);
        quote.setOperator(operator);
        quoteMapper.insert(quote);

        SysProCheck sysProCheck = new SysProCheck();
        sysProCheck.setId(IDUtils.getId());
        sysProCheck.setTechnicalAudit(0);
        sysProCheck.setBusinessAudit(0);
        sysProCheck.setCompareAudit(0);
        sysProCheck.setFinallyAudit(0);
        sysProCheck.setTechnicalRemark("");
        sysProCheck.setBusinessRemark("");
        sysProCheck.setCompareRemark("");
        sysProCheck.setFinallyRemark("");
        sysProCheck.setQuoteId(quoteId);
        sysProCheck.setOperator(operator);
        sysProCheck.setTime(time);
        sysProCheckMapper.insertSelective(sysProCheck);
    }
}
