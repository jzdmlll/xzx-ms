package com.xzx.xzxms.inquiry.dao.extend;/**
 * @Author sunny
 * @Date 2021/1/23 19:55
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.bean.InquiryTemplateWithBLOBs;

import java.util.List;

/**
 *@ClassName InquiryTemplateExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface InquiryTemplateExtendMapper {

    List<InquiryTemplateWithBLOBs> findAll(Long id);
}
