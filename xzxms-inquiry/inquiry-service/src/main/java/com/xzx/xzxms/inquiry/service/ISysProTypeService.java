package com.xzx.xzxms.inquiry.service;


import com.xzx.xzxms.inquiry.bean.SysProType;

import java.util.List;

public interface ISysProTypeService {

    /***
     * 查询所有
     * @return
     */
    List<SysProType> findAll();

    /**
     * 插入或更新
     * @param proType
     */
    void saveOrUpdate(SysProType proType);

    /**
     * 逻辑删除项目分类
     * @param proTypeId
     */
    void logicDeleteById(long proTypeId);

}
