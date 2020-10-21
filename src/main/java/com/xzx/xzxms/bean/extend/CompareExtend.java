package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Compare;
import com.xzx.xzxms.bean.InquiryWithBLOBs;

public class CompareExtend extends Compare {
    private InquiryWithBLOBs inquiry;

    public InquiryWithBLOBs getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryWithBLOBs inquiry) {
        this.inquiry = inquiry;
    }
}
