package com.xzx.xzxms.inquiry.dao.extend;


import com.xzx.xzxms.inquiry.bean.SysProType;

import java.util.List;

public interface SysProTypeExtendMapper {

    List<SysProType> findById(long proTypeId);
}
