package com.xzx.xzxms.inquiry.bean.extend;

import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.bean.SysProCheck;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

public class SysCheckExtend extends SysProCheck {
    //public final static String COMPARE_CHECK = "比价审核";
    public final static int INIT_STATUS = 0;
    public final static int PASS_STATUS = 1;
    public final static int REFUSE_STATUS = 2;

    private Quote quote;
    private Inquiry inquiry;
    private List<SysFile> files;

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }
}
