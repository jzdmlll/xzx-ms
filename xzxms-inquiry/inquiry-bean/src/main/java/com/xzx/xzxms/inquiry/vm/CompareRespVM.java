package com.xzx.xzxms.inquiry.vm;

import java.util.List;
import java.util.Map;

public class CompareRespVM {
    private long[] checkCompareIds;
    private long[] otherCompareIds;
    private long userId;
    private List<Map> remarks;
    private List<Map> inquiries;

    public List<Map> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<Map> inquiries) {
        this.inquiries = inquiries;
    }

    public long[] getCheckCompareIds() {
        return checkCompareIds;
    }

    public void setCheckCompareIds(long[] checkCompareIds) {
        this.checkCompareIds = checkCompareIds;
    }

    public long[] getOtherCompareIds() {
        return otherCompareIds;
    }

    public void setOtherCompareIds(long[] otherCompareIds) {
        this.otherCompareIds = otherCompareIds;
    }

    public List<Map> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Map> remarks) {
        this.remarks = remarks;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
