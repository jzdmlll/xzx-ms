package com.xzx.xzxms.service;


import com.xzx.xzxms.bean.SysDeviceType;

import java.util.List;

public interface ISysDeviceTypeService {

    /**
     * 根据设备名称、代码模糊查询
     * @param name
     * @param code
     * @return
     */
    List<SysDeviceType> findAllLike(String name,String code);

    /**
     * 根据设备类别的ID查询相对应的内容
     * @param deviceTypeId
     * @return
     */
    SysDeviceType findById(long deviceTypeId);

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
