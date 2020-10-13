package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.InquiryWithBLOBs;

public class InquiryCompareVM extends InquiryWithBLOBs {
    private Long proDetailId;
    private Long compareId;
    private int compareStatus;
    private String compareRemark;

    @Override
    public Long getProDetailId() {
        return proDetailId;
    }

    @Override
    public void setProDetailId(Long proDetailId) {
        this.proDetailId = proDetailId;
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
}
