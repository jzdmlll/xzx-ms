package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.Quote;

public class QuoteRespVM extends Quote {
    private Long compareId;
    private int compareStatus;
    private String compareRemark;
    private String name;
    private String number;
    private String params;
    private String unit;
    private String model;
    private String checkType;

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getCompareId() {
        return compareId;
    }

    public void setCompareId(Long compareId) {
        this.compareId = compareId;
    }

    public int getCompareStatus() {
        return compareStatus;
    }

    public void setCompareStatus(int compareStatus) {
        this.compareStatus = compareStatus;
    }

    public String getCompareRemark() {
        return compareRemark;
    }

    public void setCompareRemark(String compareRemark) {
        this.compareRemark = compareRemark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
