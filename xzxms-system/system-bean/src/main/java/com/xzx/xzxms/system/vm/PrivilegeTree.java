package com.xzx.xzxms.system.vm;


import com.xzx.xzxms.system.bean.SysPrivilege;

import java.util.List;


public class PrivilegeTree extends SysPrivilege {
    private List<PrivilegeTree> children;

    public List<PrivilegeTree> getChildren() {
        return children;
    }

    public void setChildren(List<PrivilegeTree> children) {
        this.children = children;
    }
}