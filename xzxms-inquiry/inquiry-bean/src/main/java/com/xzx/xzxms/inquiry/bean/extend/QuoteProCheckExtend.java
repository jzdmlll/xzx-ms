package com.xzx.xzxms.inquiry.bean.extend;


import com.xzx.xzxms.inquiry.bean.Quote;

public class QuoteProCheckExtend extends Quote {

    private int technicalAudit;
    private int businessAudit;
    private String technicalRemark;
    private String businessRemark;
    private int compareAudit;

    public int getCompareAudit() {
        return compareAudit;
    }

    public void setCompareAudit(int compareAudit) {
        this.compareAudit = compareAudit;
    }

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

    public String getTechnicalRemark() {
        return technicalRemark;
    }

    public void setTechnicalRemark(String technicalRemark) {
        this.technicalRemark = technicalRemark;
    }

    public String getBusinessRemark() {
        return businessRemark;
    }

    public void setBusinessRemark(String businessRemark) {
        this.businessRemark = businessRemark;
    }
}
