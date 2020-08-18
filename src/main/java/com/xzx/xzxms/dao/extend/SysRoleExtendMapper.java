package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.SysRole;
import com.xzx.xzxms.bean.extend.SysRoleExtend;

import java.util.List;

public interface SysRoleExtendMapper {

    List<SysRole> selectByUserId(long id);

    List<SysRoleExtend> selectAll();
}
