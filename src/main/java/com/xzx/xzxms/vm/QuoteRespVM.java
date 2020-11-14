package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.Quote;

public class QuoteRespVM extends Quote {

    private int technical_audit;
    private int business_audit;
    private int compare_audit;
    private int finally_audit;
    private String technical_remark;
    private String business_remark;
    private String compare_remark;
    private String finally_remark;
    private String name;

    public int getTechnical_audit() {
        return technical_audit;
    }

    public void setTechnical_audit(int technical_audit) {
        this.technical_audit = technical_audit;
    }

    public int getBusiness_audit() {
        return business_audit;
    }

    public void setBusiness_audit(int business_audit) {
        this.business_audit = business_audit;
    }

    public int getCompare_audit() {
        return compare_audit;
    }

    public void setCompare_audit(int compare_audit) {
        this.compare_audit = compare_audit;
    }

    public int getFinally_audit() {
        return finally_audit;
    }

    public void setFinally_audit(int finally_audit) {
        this.finally_audit = finally_audit;
    }

    public String getTechnical_remark() {
        return technical_remark;
    }

    public void setTechnical_remark(String technical_remark) {
        this.technical_remark = technical_remark;
    }

    public String getBusiness_remark() {
        return business_remark;
    }

    public void setBusiness_remark(String business_remark) {
        this.business_remark = business_remark;
    }

    public String getCompare_remark() {
        return compare_remark;
    }

    public void setCompare_remark(String compare_remark) {
        this.compare_remark = compare_remark;
    }

    public String getFinally_remark() {
        return finally_remark;
    }

    public void setFinally_remark(String finally_remark) {
        this.finally_remark = finally_remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
