package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.QuoteExample;
import com.xzx.xzxms.bean.extend.InquiryCompareExtend;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.dao.QuoteMapper;
import com.xzx.xzxms.dao.extend.InquiryExtendMapper;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
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
                if(i.getIsUseful() == 1) {
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
    public List<InquiryCompareExtend> findByProIdOrCompareStatus(long proDetailId, Integer compareStatus) {
        List<InquiryCompareExtend> InquiryCompareExtends = inquiryExtendMapper.findByProIdOrCompareStatus(proDetailId,compareStatus);

        return InquiryCompareExtends;
    }
}
