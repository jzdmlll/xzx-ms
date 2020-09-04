package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.SysProType;

import java.util.List;

public interface SysProTypeExtendMapper {

    List<SysProType> findById(long proTypeId);
}
