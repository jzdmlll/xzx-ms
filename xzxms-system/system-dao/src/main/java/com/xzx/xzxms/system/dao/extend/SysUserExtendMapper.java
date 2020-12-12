package com.xzx.xzxms.system.dao.extend;


import com.xzx.xzxms.system.bean.extend.SysUserExtend;

import java.util.List;

public interface SysUserExtendMapper {

    SysUserExtend selectById(long id);

    List<SysUserExtend> selectAll();
}