package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.service.IInquiryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InquiryServiceImpl implements IInquiryService {
    @Resource
    private InquiryMapper inquiryMapper;
    @Override
    public List<Inquiry> findByProDetailId(long proDetailId) {
        InquiryExample example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(proDetailId);

        return inquiryMapper.selectByExample(example);
    }
}
