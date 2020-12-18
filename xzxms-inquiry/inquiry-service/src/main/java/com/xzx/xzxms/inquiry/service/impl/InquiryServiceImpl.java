package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.utils.BeanHelper;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.ProPoolMapper;
import com.xzx.xzxms.inquiry.dao.QuoteMapper;
import com.xzx.xzxms.inquiry.dao.SysProCheckMapper;
import com.xzx.xzxms.inquiry.dao.extend.InquiryExtendMapper;
import com.xzx.xzxms.inquiry.dao.extend.QuoteAndInquiryExtendMapper;
import com.xzx.xzxms.inquiry.service.IInquiryService;
import com.xzx.xzxms.inquiry.bean.*;
import com.xzx.xzxms.inquiry.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.inquiry.bean.extend.InquiryExtend;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class InquiryServiceImpl implements IInquiryService {
    @Resource
    private InquiryMapper inquiryMapper;
    @Resource
    private InquiryExtendMapper inquiryExtendMapper;
    @Resource
    private QuoteMapper quoteMapper;
    @Resource
    private ProPoolMapper proPoolMapper;
    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private QuoteAndInquiryExtendMapper quoteAndInquiryExtendMapper;

    @Override
    public List<InquiryExtend> findByProDetailId(Long proDetailId, String name, String model) {

        return inquiryExtendMapper.findInquiryAndQuoteNum(proDetailId, name, model);
    }

    @Override
    public List<InquiryExtend> findAll() {
        return inquiryExtendMapper.findInquiryAndQuoteNum(null, null, null);
    }

    /**
     * 批量插入
     * @param inquiryList
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void batchAddInquiry(List<Inquiry> inquiryList) throws SQLException {
        long time = new Date().getTime();
        InquiryExample example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(inquiryList.get(0).getProDetailId()).andIsActiveEqualTo(1);
        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
        if (inquiries.size() > 0) {
            for (Inquiry i:inquiries){
                QuoteExample ex = new QuoteExample();
                ex.createCriteria().andInquiryIdEqualTo(i.getId()).andIsActiveEqualTo(1);
                List<Quote> quotes = quoteMapper.selectByExample(ex);

                if(quotes.size() > 0) {
                    throw new CustomerException("询价函["+i.getName()+"]下已有报价单存在，禁止覆盖");
                }
            }
            inquiryMapper.deleteByExample(example);
        }
        int sort = 1;
        for (Inquiry inquiry : inquiryList) {
            long inquiryId = IDUtils.getId();
            inquiry.setId(inquiryId);
            inquiry.setTime(time);
            inquiry.setIsActive(1);
            inquiry.setIsUseful(0);
            inquiry.setSort(sort ++);
            //需要询价
            inquiry.setIsinquiry(1);
            //否决
            inquiry.setVeto(0);
            inquiryMapper.insert(inquiry);
        }
    }

    @Override
    public void rowSave(Inquiry inquiry) {

        int count = quoteAndInquiryExtendMapper.findIsExistQuote(inquiry.getId());
        if (count > 0){
            throw new CustomerException("该询价信息已存在报价，请勿修改询价内容!，如需修改请先删除报价!");
        }

        inquiry.setTime(new Date().getTime());
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Transactional
    @Override
    public void batchSetInvalid(long[] ids) {

        long time = new Date().getTime();
        for (long id : ids){
            Inquiry inquiry=inquiryMapper.selectByPrimaryKey(id);
            QuoteExample example = new QuoteExample();
            example.createCriteria().andInquiryIdEqualTo(id).andIsActiveEqualTo(1);
            List<Quote> quotes = quoteMapper.selectByExample(example);
            if(quotes.size() > 0) {
                throw new CustomerException("该询价下有报价内容，请删除对应报价内容后执行该操作");
            }
            if (inquiry != null || !inquiry.getIsActive().equals(0)){
                inquiry.setIsActive(0);
                inquiry.setTime(time);
                inquiryMapper.updateByPrimaryKeySelective(inquiry);
            }else {
                throw new CustomerException("该数据已不存在");
            }
        }
    }

    @Override
    public List<InquiryAndProDetailExtend> findByProIdOrCompareStatus(long proDetailId, Integer compare_audit) {

        List<InquiryAndProDetailExtend> InquiryCompareExtends = inquiryExtendMapper.findByProIdOrCompareStatus(proDetailId,compare_audit);

        return InquiryCompareExtends;
    }

    @Transactional
    @Override
    public void batchSetIsNotInquiry(long[] ids, Integer status) {

        for (long id : ids){
            QuoteExample example = new QuoteExample();
            example.createCriteria().andInquiryIdEqualTo(id).andIsActiveEqualTo(1);
            List<Quote> list = quoteMapper.selectByExample(example);
            if (list.size() > 0){
                Inquiry inq = inquiryMapper.selectByPrimaryKey(id);
                throw new CustomerException(inq.getName() + ":已存在报价，勿更改是否需要询价状态!");
            }
            Inquiry inquiry = new Inquiry();
            inquiry.setId(id);
            inquiry.setIsinquiry(status);
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }
    }

    @Override
    public void setVeto(long id) {

        Inquiry inquiry = new Inquiry();
        inquiry.setId(id);
        //否决
        inquiry.setVeto(1);
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Override
    public void inquiryChoosePool(long inquiryId, long proPoolId, long operator) {

//        QuoteExample example = new QuoteExample();
//        example.createCriteria().andInquiryIdEqualTo(inquiryId).andIsActiveEqualTo(1);
//        List<Quote> quotes = quoteMapper.selectByExample(example);
//
//        if(quotes.size() > 0){
//            throw new CustomerException("此条询价内容已存在报价，如需修改请先删除报价!");
//        }

        long quoteId = IDUtils.getId();
        long time = new Date().getTime();

        ProPool proPool = proPoolMapper.selectByPrimaryKey(proPoolId);
        BeanHelper.nullToEmpty(proPool);
        Quote quote = new Quote();
        quote.setId(quoteId);
        quote.setSupplier(proPool.getSupplier());
        quote.setSuModel(proPool.getModel());
        quote.setSuBrand(proPool.getBrand());
        quote.setSuParams(proPool.getParams());
        quote.setSuPrice(proPool.getPrice());
        quote.setSuDelivery(proPool.getDelivery());
        quote.setSuRemark(proPool.getRemark());
        quote.setImage(proPool.getImage());
        quote.setSupplierId(proPool.getSupplierId());
        //数据来源于产品池
        quote.setDataSource(0);
        quote.setInquiryId(inquiryId);
        quote.setIsActive(1);
        quote.setIsUseful(0);
        quote.setOperator(operator);
        quote.setTime(time);
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

    @Override
    public void insertOrUpdateInquiry(Inquiry inquiry) {

        InquiryExample example = new InquiryExample();
        example.createCriteria().andNameEqualTo(inquiry.getName()).andParamsEqualTo(inquiry.getParams()).andVetoEqualTo(0)
                .andProDetailIdEqualTo(inquiry.getProDetailId()).andIsActiveEqualTo(1);
        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
        if (inquiries.size() > 0){
            throw new CustomerException(inquiry.getName() + ":询价内容已存在，勿重复添加!");
        }
        inquiry.setId(IDUtils.getId());
        inquiry.setVeto(0);
        inquiry.setTime(new Date().getTime());
        inquiryMapper.insert(inquiry);
    }

    @Override
    public void finallyUpdateDraft(Inquiry inquiry) {
        inquiry.setTime(new Date().getTime());
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Override
    public void modifyDeviceType(long[] inquiryIds, long codeId) {
        Inquiry inquiry = new Inquiry();
        for (long id : inquiryIds){
            inquiry.setId(id);
            inquiry.setDeviceTypeId(codeId);
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }
    }
}
