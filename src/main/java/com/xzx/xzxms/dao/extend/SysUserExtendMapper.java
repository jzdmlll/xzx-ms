package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.SysUserExtend;

import java.util.List;

public interface SysUserExtendMapper {

    SysUserExtend selectById(long id);

    List<SysUserExtend> selectAll();
}