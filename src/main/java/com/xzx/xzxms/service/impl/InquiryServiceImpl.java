package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.*;
import com.xzx.xzxms.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.bean.extend.InquiryCompareExtend;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.dao.ProPoolMapper;
import com.xzx.xzxms.dao.QuoteMapper;
import com.xzx.xzxms.dao.extend.InquiryExtendMapper;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InquiryServiceImpl implements IInquiryService{
    @Resource
    private InquiryMapper inquiryMapper;
    @Resource
    private InquiryExtendMapper inquiryExtendMapper;
    @Resource
    private QuoteMapper quoteMapper;
    @Resource
    private ProPoolMapper proPoolMapper;

    @Override
    public List<InquiryExtend> findByProDetailId(long proDetailId) {

        return inquiryExtendMapper.findInquiryAndQuoteNum(proDetailId);
    }

    @Override
    public List<InquiryExtend> findAll() {
        return inquiryExtendMapper.findInquiryAndQuoteNum(-1L);
    }

    /**
     * 批量插入
     * @param inquiryList
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void batchAddInquiry(List<Inquiry> inquiryList) throws SQLException {
        long time = new Date().getTime();
        InquiryExample  example = new InquiryExample();
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
        inquiry.setTime(new Date().getTime());
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Transactional
    @Override
    public void batchSetInvalid(long[] ids) {

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

        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiryId);
        List<Quote> quotes = quoteMapper.selectByExample(example);
        if(quotes.size() > 0){
            for(Quote q : quotes){
                quoteMapper.deleteByPrimaryKey(q.getId());
            }
        }

        ProPool proPool = proPoolMapper.selectByPrimaryKey(proPoolId);
        Quote quote = new Quote();
        quote.setId(IDUtils.getId());
        quote.setSupplier(proPool.getSupplier());
        quote.setSuModel(proPool.getSupplier());
        quote.setSuBrand(proPool.getBrand());
        quote.setSuParams(proPool.getParams());
        quote.setSuPrice(proPool.getPrice());
        quote.setSuDelivery(proPool.getDelivery());
        quote.setSuRemark(proPool.getRemark());
        quote.setImage(proPool.getImage());
        //数据来源于产品池
        quote.setDataSource(0);
        quote.setInquiryId(inquiryId);
        quote.setIsActive(1);
        quote.setIsUseful(0);
        quote.setOperator(operator);
        quote.setTime(new Date().getTime());
        quoteMapper.insert(quote);
    }
}
