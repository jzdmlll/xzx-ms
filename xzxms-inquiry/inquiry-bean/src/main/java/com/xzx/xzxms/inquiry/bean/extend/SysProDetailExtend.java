package com.xzx.xzxms.inquiry.bean.extend;


import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.inquiry.bean.SysProOrigin;
import com.xzx.xzxms.inquiry.bean.SysProType;

public class SysProDetailExtend extends SysProDetailWithBLOBs {

    private SysProType sysProType;
    private SysProOrigin sysProOrigin;

    public SysProType getSysProType() {
        return sysProType;
    }

    public void setSysProType(SysProType sysProType) {
        this.sysProType = sysProType;
    }

    public SysProOrigin getSysProOrigin() {
        return sysProOrigin;
    }

    public void setSysProOrigin(SysProOrigin sysProOrigin) {
        this.sysProOrigin = sysProOrigin;
    }
}
