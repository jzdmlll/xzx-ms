package com.xzx.xzxms.inquiry.dao.extend;


import com.xzx.xzxms.inquiry.bean.SysProOrigin;

import java.util.List;

public interface SysProOriginExtendMapper {

    List<SysProOrigin> findById(long proOriginId);
}
