package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.SysProCheck;

public class SysCheckAndScheduleExtend extends SysProCheck {

    private long sysDetailId;
    private long inquiryId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSysDetailId() {
        return sysDetailId;
    }

    public void setSysDetailId(long sysDetailId) {
        this.sysDetailId = sysDetailId;
    }

    public long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(long inquiryId) {
        this.inquiryId = inquiryId;
    }
}
