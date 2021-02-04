package com.xzx.xzxms.inquiry.service;/**
 * @Author sunny
 * @Date 2021/1/23 19:40
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.bean.InquiryTemplate;
import com.xzx.xzxms.inquiry.bean.InquiryTemplateWithBLOBs;

import java.util.List;

/**
 *@ClassName IInquiryTemplateService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface IInquiryTemplateService {

    /**
     * 询价模板查询
     * @return
     */
    List<InquiryTemplateWithBLOBs> findInquiryTemplate(Long id);

    /**
     * 询价模板新增
     * @param inquiryTemplateWithBLOBs
     */
    void insertInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs);

    /**
     * 询价模板修改
     * @param inquiryTemplateWithBLOBs
     */
    void updateInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs);

    /**
     * 真删
     * @param inquiryTemplate
     */
    void setInvalidInquiryTemplate(InquiryTemplate inquiryTemplate);

}
