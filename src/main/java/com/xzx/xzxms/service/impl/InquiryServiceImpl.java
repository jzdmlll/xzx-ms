package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InquiryServiceImpl implements IInquiryService {

    @Resource
    private InquiryMapper inquiryMapper;

    @Override
    public List<InquiryWithBLOBs> findByProDetailId(long proId) {

        InquiryExample inquiryExample=new InquiryExample();
        inquiryExample.createCriteria().andProDetailIdEqualTo(proId);
        return inquiryMapper.selectByExampleWithBLOBs(inquiryExample);
    }

    @Override
    public void saveOrUpdate(InquiryWithBLOBs inquiry) {

        if (inquiry.getId() != null){
            inquiryMapper.updateByPrimaryKey(inquiry);
        }else {
            inquiry.setId(IDUtils.getId());
            inquiryMapper.insert(inquiry);
        }
    }

    @Transactional
    @Override
    public void setInvalid(long[] ids) {

        InquiryWithBLOBs inquiry=new InquiryWithBLOBs();
        for (long id:ids) {
            inquiry.setId(id);
            inquiry.setIsActive(0);
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }
    }

    @Transactional
    @Override
    public void delete(long[] ids) {

        for (long id:ids) {
            inquiryMapper.deleteByPrimaryKey(id);
        }
    }
}
