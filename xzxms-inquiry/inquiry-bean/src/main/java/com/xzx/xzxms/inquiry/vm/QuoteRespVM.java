package com.xzx.xzxms.inquiry.vm;

import com.xzx.xzxms.inquiry.bean.Quote;

public class QuoteRespVM extends Quote {

    private Long compareId;
    private Integer technicalAudit;
    private Integer businessAudit;
    private Integer compareStatus;
    private Integer finallyAudit;
    private String technicalRemark;
    private String businessRemark;
    private String compareRemark;
    private String finallyRemark;
    private String name;
    private Double minPrice;

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Long getCompareId() {
        return compareId;
    }

    public void setCompareId(Long compareId) {
        this.compareId = compareId;
    }

    public Integer getTechnicalAudit() {
        return technicalAudit;
    }

    public void setTechnicalAudit(Integer technicalAudit) {
        this.technicalAudit = technicalAudit;
    }

    public Integer getBusinessAudit() {
        return businessAudit;
    }

    public void setBusinessAudit(Integer businessAudit) {
        this.businessAudit = businessAudit;
    }

    public Integer getCompareStatus() {
        return compareStatus;
    }

    public void setCompareStatus(Integer compareStatus) {
        this.compareStatus = compareStatus;
    }

    public Integer getFinallyAudit() {
        return finallyAudit;
    }

    public void setFinallyAudit(Integer finallyAudit) {
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
