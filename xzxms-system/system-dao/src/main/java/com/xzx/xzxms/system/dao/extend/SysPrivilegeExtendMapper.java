package com.xzx.xzxms.system.dao.extend;


import com.xzx.xzxms.system.bean.SysPrivilege;
import com.xzx.xzxms.system.bean.extend.SysPrivilegeExtend;
import com.xzx.xzxms.system.vm.PrivilegeTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPrivilegeExtendMapper {
    List<PrivilegeTree> selectAll();

    List<SysPrivilege> selectByParentId(long id);

    List<SysPrivilege> selectByRoleId(long id);

    List<SysPrivilege> selectByUserId(long id);

    List<PrivilegeTree> selectMenuByUserId(@Param("id") long id, @Param("privilegeParentId") Long privilegeParentId);
}