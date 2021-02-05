package com.xzx.xzxms.system.vm;
import com.xzx.xzxms.system.bean.SysUser;

import java.util.List;

public class UserRoleVM extends SysUser {
    private List<Long> roles;

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }
}