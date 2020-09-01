package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProType;

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

}
