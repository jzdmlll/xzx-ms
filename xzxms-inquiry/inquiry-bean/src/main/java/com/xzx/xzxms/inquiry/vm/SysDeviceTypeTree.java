package com.xzx.xzxms.inquiry.vm;


import com.xzx.xzxms.inquiry.bean.SysDeviceType;

import java.util.List;

public class SysDeviceTypeTree extends SysDeviceType {
    private List<SysDeviceType> children;

    public List<SysDeviceType> getChildren() {
        return children;
    }

    public void setChildren(List<SysDeviceType> children) {
        this.children = children;
    }
}
