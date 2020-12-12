package com.xzx.xzxms.system.vm;


import com.xzx.xzxms.system.bean.SysPrivilege;

import java.util.List;


public class PrivilegeTree extends SysPrivilege {
    private List<SysPrivilege> children;

    public List<SysPrivilege> getChildren() {
        return children;
    }

    public void setChildren(List<SysPrivilege> children) {
        this.children = children;
    }
}