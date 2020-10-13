package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Compare;
import com.xzx.xzxms.bean.InquiryWithBLOBs;

public class CompareExtend extends Compare {
    /**
     * 未比价
     */
    public final static Integer UNPARED_PRICE=0;
    /**
     * 未选用
     */
    public final static Integer UNSELECTED=2;
    /**
     * 拟选用
     */
    public final static Integer TO_BE_SELECTED=1;
    /**
     * 最终选用
     */
    public final static Integer SELECTED=3;


    private InquiryWithBLOBs inquiry;

    public InquiryWithBLOBs getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryWithBLOBs inquiry) {
        this.inquiry = inquiry;
    }
}
