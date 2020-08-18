package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.SysPrivilege;

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