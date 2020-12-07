package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Quote;

public class QuoteProCheckExtend extends Quote {

    private int technicalAudit;
    private int businessAudit;

    public int getTechnicalAudit() {
        return technicalAudit;
    }

    public void setTechnicalAudit(int technicalAudit) {
        this.technicalAudit = technicalAudit;
    }

    public int getBusinessAudit() {
        return businessAudit;
    }

    public void setBusinessAudit(int businessAudit) {
        this.businessAudit = businessAudit;
    }
}
