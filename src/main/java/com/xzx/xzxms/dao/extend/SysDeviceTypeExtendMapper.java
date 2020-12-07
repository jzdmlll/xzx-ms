package com.xzx.xzxms.dao.extend;


import com.xzx.xzxms.vm.SysDeviceTypeTree;

import java.util.List;

public interface SysDeviceTypeExtendMapper {

    /**
     * 查询设备类型树
     * @return
     */
    List<SysDeviceTypeTree> findPrivilegeTree();
}