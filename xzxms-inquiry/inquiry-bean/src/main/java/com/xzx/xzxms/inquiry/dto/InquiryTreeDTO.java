package com.xzx.xzxms.inquiry.dto;
/**
 * @Author sunny
 * @Date 2021/1/21 17:49
 * @Version 1.0
 */

import lombok.Data;

import java.util.List;

/**
 *@ClassName InquiryTreeDTO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Data
public class InquiryTreeDTO {

    private List<InquiryTree> inquiryList;

    public List<InquiryTree> getInquiryList() {
        return inquiryList;
    }

    public void setInquiryList(List<InquiryTree> inquiryList) {
        this.inquiryList = inquiryList;
    }
}
