package com.xzx.xzxms.bean.extend;


import com.xzx.xzxms.bean.SysPrivilege;
import com.xzx.xzxms.bean.SysRole;

import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 角色拓展类
 * @author: charles
 * @create: 2019-11-17 22:01
 **/

public class SysRoleExtend extends SysRole {
    private List<SysPrivilege> privileges;

    public List<SysPrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<SysPrivilege> privileges) {
        this.privileges = privileges;
    }
}