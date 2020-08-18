package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.SysPrivilege;

import java.util.List;

public class SysPrivilegeExtend extends SysPrivilege {
    private List<SysPrivilege> children;

    public List<SysPrivilege> getChildren() {
        return children;
    }

    public void setChildren(List<SysPrivilege> children) {
        this.children = children;
    }
}
