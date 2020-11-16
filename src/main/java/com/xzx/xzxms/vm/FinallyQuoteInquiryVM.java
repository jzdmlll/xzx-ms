package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.Quote;

public class FinallyQuoteInquiryVM extends Quote {
    private int veto;
    private int technicalAudit;
    private int businessAudit;
    private int compareStatus;
    private int finallyAudit;
    private String technicalRemark;
    private String businessRemark;
    private String compareRemark;
    private String finallyRemark;

    private String name;
    private String model;
    private String number;
    private String params;
    private String unit;
    private String price;
    private String totalPrice;
    private String sort;
    private String compareId;
    private int minPrice;


    public int getVeto() {
        return veto;
    }

    public void setVeto(int veto) {
        this.veto = veto;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCompareId() {
        return compareId;
    }

    public void setCompareId(String compareId) {
        this.compareId = compareId;
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

    public int getCompareStatus() {
        return compareStatus;
    }

    public void setCompareStatus(int compareStatus) {
        this.compareStatus = compareStatus;
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
