package com.xzx.xzxms.vm;


import com.xzx.xzxms.bean.SysProCheck;

import java.util.List;

public class FinallyCheckReqVM {
    private long[] checkInquiryIds;
    private long userId;
    private long roleId;
    private long[] allInquiryIds;
    List<SysProCheck> remarks;

    public long[] getCheckInquiryIds() {
        return checkInquiryIds;
    }

    public void setCheckInquiryIds(long[] checkInquiryIds) {
        this.checkInquiryIds = checkInquiryIds;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long[] getAllInquiryIds() {
        return allInquiryIds;
    }

    public void setAllInquiryIds(long[] allInquiryIds) {
        this.allInquiryIds = allInquiryIds;
    }

    public List<SysProCheck> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<SysProCheck> remarks) {
        this.remarks = remarks;
    }
}
