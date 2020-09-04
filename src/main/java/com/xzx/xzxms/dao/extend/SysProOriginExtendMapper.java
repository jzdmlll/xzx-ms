package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.bean.SysProType;

import java.util.List;

public interface SysProOriginExtendMapper {

    List<SysProOrigin> findById(long proOriginId);
}
