package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.InquiryWithBLOBs;

public class InquiryCompareVM extends InquiryWithBLOBs {
    private Long proDetailId;
    private Long compareId;

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
}
