package com.xzx.xzxms.inquiry.service.impl;/**
 * @Author sunny
 * @Date 2021/1/23 19:45
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.InquiryTemplate;
import com.xzx.xzxms.inquiry.bean.InquiryTemplateExample;
import com.xzx.xzxms.inquiry.bean.InquiryTemplateWithBLOBs;
import com.xzx.xzxms.inquiry.dao.InquiryTemplateMapper;
import com.xzx.xzxms.inquiry.dao.extend.InquiryTemplateExtendMapper;
import com.xzx.xzxms.inquiry.service.IInquiryTemplateService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName InquiryTemplateServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class InquiryTemplateServiceImpl implements IInquiryTemplateService {

    @Resource
    private InquiryTemplateMapper inquiryTemplateMapper;
    @Resource
    private InquiryTemplateExtendMapper inquiryTemplateExtendMapper;

    @Override
    public List<InquiryTemplateWithBLOBs> findInquiryTemplate(Long id) {

        return inquiryTemplateExtendMapper.findAll(id);
    }

    @Override
    public void insertInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs) {

        inquiryTemplateWithBLOBs.setId(IDUtils.getId());
        inquiryTemplateWithBLOBs.setTime(new Date().getTime());
        inquiryTemplateMapper.insertSelective(inquiryTemplateWithBLOBs);
    }

    @Override
    public void updateInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs) {

        inquiryTemplateWithBLOBs.setTime(new Date().getTime());
        inquiryTemplateMapper.updateByPrimaryKeyWithBLOBs(inquiryTemplateWithBLOBs);
    }

    @Override
    public void setInvalidInquiryTemplate(InquiryTemplate inquiryTemplate) {

        inquiryTemplateMapper.deleteByPrimaryKey(inquiryTemplate.getId());
    }
}
