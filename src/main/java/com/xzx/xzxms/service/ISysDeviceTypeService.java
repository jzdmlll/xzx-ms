package com.xzx.xzxms.service;


import com.xzx.xzxms.bean.SysDeviceType;

import java.util.List;

public interface ISysDeviceTypeService {

    /**
     * 查询全部
     * @return
     */
    List<SysDeviceType> findAll();

    /**
     * 根据设备类别的ID查询相对应的询价全部内容
     * @param deviceTypeId
     * @return
     */
    List<SysDeviceType> findById(long deviceTypeId);

    /**
     * 保存或更改设备类别信息
     * @param sysDeviceType
     */
    void saveOrUpdate(SysDeviceType sysDeviceType);

    /**
     * 批量置为无效
     * @param ids
     */
    void setInvalid(long[] ids);

    /**
     * 批量删除
     * @param ids
     */
    void delete(long[] ids);
}
