package com.xzx.xzxms.inquiry.service;


import com.xzx.xzxms.inquiry.bean.SysDeviceType;
import com.xzx.xzxms.inquiry.vm.SysDeviceTypeTree;

import java.util.List;

public interface ISysDeviceTypeService {

    /**
     * @Description: 查询设备分类树
     * @Param: []
     * @return: java.util.List<SysDeviceTypeTree>
     */
    List<SysDeviceTypeTree> findDeviceTypeTree();

    /**
     * @Description: 通过parentId查询设备分类
     * @Param: [parentId]
     * @return: java.util.List<SysDeviceType>
     */
    List<SysDeviceType> findByParentId(Long parentId, String name, String code);

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
     * @param sysDeviceType
     */
    void setInvalid(SysDeviceType sysDeviceType);
}
