package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProOrigin;

import java.util.List;

public interface ISysProOriginService {
    /**
     * 查询所有项目来源信息
     * @return List<SysProOrigin>
     */
    List<SysProOrigin> findAll();

    /**
     * 新增或保存一条项目来源信息
     * @param proOrigin
     */
    void saveOrUpdate(SysProOrigin proOrigin);

    /**
     * 根据id逻辑删除一条项目来源信息
     * @param proOriginId
     */
    void logicDeleteById(long proOriginId);
}
