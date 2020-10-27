package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
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

    @Override
    public List<Inquiry> findAll() {
        return inquiryMapper.selectByExample(new InquiryExample());
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
        example.createCriteria().andProDetailIdEqualTo(inquiryList.get(0).getProDetailId());
        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
        if (inquiries.size() > 0) {
            inquiryMapper.deleteByExample(example);
        }
        int sort = 1;
        for (Inquiry inquiry : inquiryList) {
            example = new InquiryExample();
            example.createCriteria().andParamsEqualTo(inquiry.getParams()).andNameEqualTo(inquiry.getName());
            List<Inquiry> inquiriesList = inquiryMapper.selectByExample(example);
            System.out.println(inquiriesList.size());
            if (inquiriesList.size() > 0) {
                throw new CustomerException("数据已存在");
            }
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

}
