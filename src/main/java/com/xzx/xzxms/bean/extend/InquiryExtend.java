package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.SysFile;

import java.util.List;

public class InquiryExtend extends Inquiry {
    private List<SysFile> files;
    private List<Quote> quotes;

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
    public void setQuotes1(List<Quote> quotes) {
        this.quotes = quotes;
    }

}
