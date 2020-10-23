package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class InquiryServiceImpl implements IInquiryService{
    @Resource
    private InquiryMapper inquiryMapper;
    @Override
    public List<Inquiry> findByProDetailId(long proDetailId) {
        InquiryExample example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(proDetailId);

        return inquiryMapper.selectByExample(example);
    }

    /**
     * 批量插入
     * @param inquiryList
     */
    @Transactional
    @Override
    public void batchAddInquiry(List<Inquiry> inquiryList) {
        long time = new Date().getTime();
        InquiryExample  example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(inquiryList.get(0).getProDetailId());
        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
        if (inquiries.size() > 0) {
            inquiryMapper.deleteByExample(example);
        }

        for (Inquiry inquiry : inquiryList) {
              long inquiryId = IDUtils.getId();
              inquiry.setId(inquiryId);
              inquiry.setTime(time);
              inquiry.setIsActive(1);
              inquiry.setIsUseful(0);
              inquiryMapper.insert(inquiry);

        }

    }



}
