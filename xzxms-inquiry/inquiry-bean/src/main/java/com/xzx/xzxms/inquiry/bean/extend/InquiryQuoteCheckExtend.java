package com.xzx.xzxms.inquiry.bean.extend;


import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.bean.SysProCheck;

public class InquiryQuoteCheckExtend extends Quote {

    private Inquiry inquiry;
    private Quote quote;
    private SysProCheck check;

    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public SysProCheck getCheck() {
        return check;
    }

    public void setCheck(SysProCheck check) {
        this.check = check;
    }
}
