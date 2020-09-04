package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.bean.SysProType;

public class SysProDetailExtend extends SysProDetail {

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
