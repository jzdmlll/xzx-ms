package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProOrigin;

import java.util.List;

public interface ISysProOriginService {
    /**
     * 查询所有项目来源信息
     * @return List<SysProOrigin>
     */
    List<SysProOrigin> findAll();
}
