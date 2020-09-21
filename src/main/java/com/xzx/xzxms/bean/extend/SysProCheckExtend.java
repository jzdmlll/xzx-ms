package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.bean.SysProCheck;

public class SysProCheckExtend extends SysProCheck {
    public final static Integer InquiryType = 0;
    public final static Integer ProDetailType = 1;

    private InquiryWithBLOBs inquiry;
    private String checkName;

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public InquiryWithBLOBs getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryWithBLOBs inquiry) {
        this.inquiry = inquiry;
    }
}
