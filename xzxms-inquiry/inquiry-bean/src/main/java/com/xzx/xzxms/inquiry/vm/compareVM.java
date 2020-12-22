package com.xzx.xzxms.inquiry.vm;

import com.xzx.xzxms.inquiry.bean.Quote;

import java.util.List;

public class compareVM {
    private List<QuoteExtend> quoteList;

    public List<QuoteExtend> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(List<QuoteExtend> quoteList) {
        this.quoteList = quoteList;
    }
}

class QuoteExtend extends Quote {
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}