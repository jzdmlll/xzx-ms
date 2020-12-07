package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.SysDeviceType;

public class SysDeviceTypeTree extends SysDeviceType {
    private SysDeviceType children;

    public SysDeviceType getChildren() {
        return children;
    }

    public void setChildren(SysDeviceType children) {
        this.children = children;
    }
}
