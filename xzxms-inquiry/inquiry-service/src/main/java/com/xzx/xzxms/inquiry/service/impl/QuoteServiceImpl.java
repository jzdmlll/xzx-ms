package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.*;
import com.xzx.xzxms.inquiry.dao.*;
import com.xzx.xzxms.inquiry.dao.extend.InquiryQuoteCheckExtendMapper;
import com.xzx.xzxms.inquiry.dao.extend.QuoteAndInquiryExtendMapper;
import com.xzx.xzxms.inquiry.service.IQuoteService;
import com.xzx.xzxms.inquiry.bean.*;
import com.xzx.xzxms.inquiry.bean.extend.QuoteExtend;
import com.xzx.xzxms.inquiry.bean.extend.QuoteExtendInquiry;
import com.xzx.xzxms.inquiry.bean.extend.QuoteProCheckExtend;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.SysFileExample;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import com.xzx.xzxms.system.dao.SysFileMapper;
import com.xzx.xzxms.system.service.IFileUploadService;
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
    @Resource
    private InquiryPoolMapper inquiryPoolMapper;
    @Resource
    private InquiryQuoteCheckExtendMapper inquiryQuoteCheckExtendMapper;

    @Override
    public List<QuoteProCheckExtend> findByInquiryId(long inquiryId) {

        List<QuoteProCheckExtend> quoteProCheckExtends = inquiryQuoteCheckExtendMapper.findQuoteAndCheck(inquiryId);
        return quoteProCheckExtends;
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

                if(dataFromExcel.size() == 0) {
                    throw new CustomerException("excel 为空，可能内容格式异常（序号不能为空）");
                }

                //2.报价信息存入数据库报价表
                String name = "";
                String params = "";
                int sort = 0;
                long inquiryId = -1L;
                SysFile sysFile = new SysFile();
                String notFound = "";

                InquiryPool inquiryPool = new InquiryPool();

                for (Map<String, Object> item : dataFromExcel) {

                    String imgUrl = "";

                    name = item.get("设备名称").toString().trim();
                    params = item.get("型号").toString().trim();
                    sort = Integer.parseInt(item.get("序号").toString().trim());
                    InquiryExample example = new InquiryExample();
                    if("".equals(params) || params == null) {
                        example.createCriteria().andNameEqualTo(name).andModelIsNull().andIsActiveEqualTo(1).andProDetailIdEqualTo(proDetailId).andVetoEqualTo(0).andSortEqualTo(sort);
                    }else {
                        example.createCriteria().andNameEqualTo(name).andModelEqualTo(params).andIsActiveEqualTo(1).andProDetailIdEqualTo(proDetailId).andVetoEqualTo(0).andSortEqualTo(sort);
                    }
                    List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
                    if (inquiries.size() > 0) {
                        Inquiry inquiry = inquiries.get(0);
                        inquiryId = inquiry.getId();

//                            if (inquiry.getIsinquiry() == 0){
//                                throw new CustomerException("文件中:  ["+name+"   :"+params+"]  已被设定为不需询价，无法导入报价单,如需导入请修改!");
//                            }
                        //询价内容添加到询价池中
                        inquiryPool.setId(IDUtils.getId());
                        inquiryPool.setEquipmentName(inquiry.getName());
                        inquiryPool.setBrand(inquiry.getBrand());
                        inquiryPool.setModel(inquiry.getModel());
                        inquiryPool.setUnit(inquiry.getUnit());
                        inquiryPool.setTechnicalRequire(inquiry.getParams());
                        inquiryPool.setIsActive(1);
                        inquiryPool.setProDetailId(proDetailId);
                        inquiryPool.setOperator(operator);
                        inquiryPool.setTime(time);

                    }else {
                        notFound += "["+name+" "+params+"]----";
                    }

                    if("".equals(notFound)){
                        String supplier = item.get("供应商").toString().trim();

                        Quote q = new Quote();
                        long quoteId = IDUtils.getId();
                        try {
                            q.setId(quoteId);
                            q.setIsActive(1);
                            q.setIsUseful(0);
                            q.setOperator(operator);
                            q.setSuDelivery(item.get("货期").toString().trim());
                            inquiryPool.setDelivery(item.get("货期").toString().trim());
                            q.setSuModel(item.get("报价型号").toString().trim());
                            inquiryPool.setQuoteModel(item.get("报价型号").toString().trim());
                            q.setSuBrand(item.get("报价品牌").toString().trim());
                            inquiryPool.setQuoteBrand(item.get("报价品牌").toString().trim());
                            q.setSuParams(item.get("实际技术参数").toString().trim());
                            inquiryPool.setTechnicalParams(item.get("实际技术参数").toString().trim());
                            q.setSupplier(supplier);
                            inquiryPool.setSupplier(supplier);

                            if(StringUtils.isEmpty(item.get("设备单价").toString().trim())){
                                q.setSuPrice(0D);
                                inquiryPool.setPrice(0D);
                            }else{
                                q.setSuPrice(Double.parseDouble(item.get("设备单价").toString().trim()));
                                inquiryPool.setPrice(Double.parseDouble(item.get("设备单价").toString().trim()));
                            }
                            if(StringUtils.isEmpty(item.get("设备总价").toString().trim())){
                                q.setSuTotalPrice(0D);
                            }else{
                                q.setSuTotalPrice(Double.parseDouble(item.get("设备总价").toString().trim()));
                            }
                            q.setSuRemark(item.get("备注").toString().trim());
                            inquiryPool.setRemark(item.get("备注").toString().trim());
                            q.setTime(time);
                            q.setWarranty(item.get("质保期/售后").toString().trim());
                            inquiryPool.setWarranty(item.get("质保期/售后").toString().trim());
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
                        inquiryPoolMapper.insert(inquiryPool);

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
            setQuoteInvalid(id);
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
    }

    @Transactional
    @Override
    public void addQuote(Quote quote) {

        long quoteId = IDUtils.getId();
        long time = new Date().getTime();

        BeanHelper.nullToEmpty(quote);
        InquiryExample example = new InquiryExample();
        example.createCriteria().andIdEqualTo(quote.getInquiryId());
        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
        Inquiry inquiry = inquiries.get(0);

        quote.setId(quoteId);
        quote.setDataSource(1);
        quote.setIsActive(1);
        quote.setIsUseful(0);
        quote.setTime(time);
        quoteMapper.insert(quote);

        InquiryPool inquiryPool = new InquiryPool();
        inquiryPool.setId(IDUtils.getId());
        inquiryPool.setTime(time);
        inquiryPool.setIsActive(1);
        inquiryPool.setOperator(quote.getOperator());
        inquiryPool.setSupplier(quote.getSupplier());
        inquiryPool.setEquipmentName(inquiry.getName());
        inquiryPool.setBrand(quote.getSuBrand());
        inquiryPool.setModel(quote.getSuModel());
        inquiryPool.setTechnicalRequire(inquiry.getParams());
        inquiryPool.setUnit(inquiry.getUnit());
        inquiryPool.setQuoteModel(quote.getSuModel());
        inquiryPool.setTechnicalParams(quote.getSuParams());
        inquiryPool.setQuoteBrand(quote.getSuBrand());
        inquiryPool.setPrice(quote.getSuPrice());
        inquiryPool.setDelivery(quote.getSuDelivery());
        inquiryPool.setWarranty(quote.getWarranty());
        inquiryPool.setImage(quote.getImage());
        inquiryPool.setRemark(quote.getSuRemark());
        inquiryPool.setProDetailId(inquiry.getProDetailId());
        inquiryPoolMapper.insert(inquiryPool);
    }

    @Transactional
    @Override
    public void quoteSetInvalid(long id) {

        setQuoteInvalid(id);
    }

    @Transactional
    @Override
    public void initiateAudit(long inquiryId) {

        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiryId).andIsActiveEqualTo(1);
        List<Quote> list = quoteMapper.selectByExample(example);
        SysProCheck sysProCheck = new SysProCheck();
        long time = new Date().getTime();

        for (Quote quote : list){

            SysProCheckExample proCheckExample = new SysProCheckExample();
            proCheckExample.createCriteria().andQuoteIdEqualTo(quote.getId());
            List<SysProCheck> proChecks = sysProCheckMapper.selectByExample(proCheckExample);
            if (proChecks.size() > 0){
                continue;
            }else {
                //发送审核,添加商审、技审的默认值
                sysProCheck.setId(IDUtils.getId());
                sysProCheck.setTechnicalAudit(0);
                sysProCheck.setBusinessAudit(0);
//                sysProCheck.setCompareAudit(0);
//                sysProCheck.setFinallyAudit(0);
                sysProCheck.setTechnicalRemark("");
                sysProCheck.setBusinessRemark("");
//                sysProCheck.setCompareRemark("");
//                sysProCheck.setFinallyRemark("");
                sysProCheck.setQuoteId(quote.getId());
                sysProCheck.setOperator(quote.getOperator());
                sysProCheck.setTime(time);
                sysProCheckMapper.insertSelective(sysProCheck);
            }
        }
    }

    @Transactional
    @Override
    public void sendCompare(long inquiryId) {

        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiryId).andIsActiveEqualTo(1);
        List<Quote> list = quoteMapper.selectByExample(example);

        SysProCheckExample proCheckExample = new SysProCheckExample();

        for (Quote quote : list){
            proCheckExample.createCriteria().andQuoteIdEqualTo(quote.getId());
            List<SysProCheck> proChecks = sysProCheckMapper.selectByExample(proCheckExample);
            if (proChecks.size() > 0){
                SysProCheck sysProCheck = proChecks.get(0);
                if (sysProCheck.getBusinessAudit() == 0 || sysProCheck.getTechnicalAudit() == 0){
                    throw new CustomerException("未审核，勿发往比价!");
                }else {
                    if (sysProCheck.getCompareAudit() == null){
                        //发往比价；比价状态初始化
                        sysProCheck.setCompareAudit(0);
                        sysProCheck.setCompareRemark("");
                        sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
                    }else {
                        throw new CustomerException("已提交发往比价，勿重复操作!");
                    }
                }
            }else {
                throw new CustomerException("请先送审，等待审核结果后再提交比价!");
            }
        }
    }

    /**
     * 报价逻辑删
     * @param id
     */
    public void setQuoteInvalid(long id){
        Quote quote=quoteMapper.selectByPrimaryKey(id);
        if (quote != null || quote.getIsActive() != 0){
            SysProCheckExample sysProCheckExample = new SysProCheckExample();
            sysProCheckExample.createCriteria().andQuoteIdEqualTo(id);
            List<SysProCheck> list = sysProCheckMapper.selectByExample(sysProCheckExample);
            SysProCheck sysProCheck = list.get(0);
            if (sysProCheck.getBusinessAudit() != 0 || sysProCheck.getTechnicalAudit() != 0){

                throw new CustomerException("该报价信息已经被审核，无法删除");
            }
            quote.setIsActive(0);
            quoteMapper.updateByPrimaryKeySelective(quote);
            //删除报价的同时删除询价池对应的内容
            InquiryPoolExample example1 = new InquiryPoolExample();
            BeanHelper.nullToEmpty(quote);
            example1.createCriteria().andQuoteBrandEqualTo(quote.getSuBrand()).andQuoteModelEqualTo(quote.getSuModel()).andTechnicalParamsEqualTo(quote.getSuParams());
            List<InquiryPool> inquiryPools = inquiryPoolMapper.selectByExample(example1);
            for (InquiryPool pool : inquiryPools){
                inquiryPoolMapper.deleteByPrimaryKey(pool.getId());
            }
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
