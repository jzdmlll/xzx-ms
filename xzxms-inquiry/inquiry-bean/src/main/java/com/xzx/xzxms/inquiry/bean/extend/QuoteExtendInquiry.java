package com.xzx.xzxms.inquiry.bean.extend;

import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.bean.SysProDetail;

public class QuoteExtendInquiry extends Quote {

    private Inquiry inquiry;
    private SysProDetail sysProDetail;

    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    public SysProDetail getSysProDetail() {
        return sysProDetail;
    }

    public void setSysProDetail(SysProDetail sysProDetail) {
        this.sysProDetail = sysProDetail;
    }
}
