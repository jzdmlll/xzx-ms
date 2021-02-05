package com.xzx.xzxms.system.bean.extend;


import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.SysUser;

import java.util.List;


public class SysUserExtend extends SysUser {
    public static final String STATUS_NORMAL="正常";
    public static final String STATUS_FORBIDDEN="禁用";

    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
