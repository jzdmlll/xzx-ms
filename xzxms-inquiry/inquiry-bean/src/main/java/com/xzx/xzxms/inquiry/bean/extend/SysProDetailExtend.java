package com.xzx.xzxms.inquiry.bean.extend;


import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.inquiry.bean.SysProOrigin;
import com.xzx.xzxms.inquiry.bean.SysProType;
import com.xzx.xzxms.system.bean.SysUser;

public class SysProDetailExtend extends SysProDetailWithBLOBs {

    private SysProType sysProType;
    private SysProOrigin sysProOrigin;
    private SysUser sysUser;
    private SysUser sysUser1;

    public SysUser getSysUser1() {
        return sysUser1;
    }

    public void setSysUser1(SysUser sysUser1) {
        this.sysUser1 = sysUser1;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

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
