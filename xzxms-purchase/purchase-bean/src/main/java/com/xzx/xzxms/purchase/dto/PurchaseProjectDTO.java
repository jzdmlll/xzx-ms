package com.xzx.xzxms.purchase.dto;
/**
 * @Author sunny
 * @Date 2021/1/7 15:13
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.PurchaseProject;

/**
 *@ClassName PurchaseProjectDTO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class PurchaseProjectDTO extends PurchaseProject{

    private String inquiryProjectName;

    public String getInquiryProjectName() {
        return inquiryProjectName;
    }

    public void setInquiryProjectName(String inquiryProjectName) {
        this.inquiryProjectName = inquiryProjectName;
    }
}
