package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Inquiry;

public class InquiryCompareExtend extends Inquiry {
    private Integer cheCheckStatus;

    private String cheType;


    private Long cheContentId;

    public Integer getCheCheckStatus() {
        return cheCheckStatus;
    }

    public void setCheCheckStatus(Integer cheCheckStatus) {
        this.cheCheckStatus = cheCheckStatus;
    }

    public String getCheType() {
        return cheType;
    }

    public void setCheType(String cheType) {
        this.cheType = cheType;
    }

    public Long getCheContentId() {
        return cheContentId;
    }

    public void setCheContentId(Long cheContentId) {
        this.cheContentId = cheContentId;
    }
}
