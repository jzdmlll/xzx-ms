package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;

import java.util.List;

public interface SysProDetailExtendMapper {

    SysProDetailExtend findById(long proDetailId);
    SysProDetailExtend findById();
}
