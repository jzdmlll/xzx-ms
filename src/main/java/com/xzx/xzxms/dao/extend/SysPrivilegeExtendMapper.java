package com.xzx.xzxms.dao.extend;



import com.xzx.xzxms.bean.SysPrivilege;
import com.xzx.xzxms.bean.extend.SysPrivilegeExtend;
import com.xzx.xzxms.vm.PrivilegeTree;

import java.util.List;

public interface SysPrivilegeExtendMapper {
    List<PrivilegeTree> selectAll();

    List<SysPrivilege> selectByParentId(long id);

    List<SysPrivilege> selectByRoleId(long id);

    List<SysPrivilege> selectByUserId(long id);

    List<SysPrivilegeExtend> selectMenuByUserId(long id);
}