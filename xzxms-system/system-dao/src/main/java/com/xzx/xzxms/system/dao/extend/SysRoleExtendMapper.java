package com.xzx.xzxms.system.dao.extend;


import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.extend.SysRoleExtend;

import java.util.List;

public interface SysRoleExtendMapper {

    List<SysRole> selectByUserId(long id);

    List<SysRoleExtend> selectAll();

    List<SysRole> selectAllHasCheckName();
}
