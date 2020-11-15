package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.Quote;

public class QuoteRespVM extends Quote {

    private int technicalAudit;
    private int businessAudit;
    private int compareAudit;
    private int finallyAudit;
    private String technicalRemark;
    private String businessRemark;
    private String compareRemark;
    private String finallyRemark;
    private String name;

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

    public int getCompareAudit() {
        return compareAudit;
    }

    public void setCompareAudit(int compareAudit) {
        this.compareAudit = compareAudit;
    }

    public int getFinallyAudit() {
        return finallyAudit;
    }

    public void setFinallyAudit(int finallyAudit) {
        this.finallyAudit = finallyAudit;
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

    public String getCompareRemark() {
        return compareRemark;
    }

    public void setCompareRemark(String compareRemark) {
        this.compareRemark = compareRemark;
    }

    public String getFinallyRemark() {
        return finallyRemark;
    }

    public void setFinallyRemark(String finallyRemark) {
        this.finallyRemark = finallyRemark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
