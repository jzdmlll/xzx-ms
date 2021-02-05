package com.xzx.xzxms.inquiry.dao.extend;



import com.xzx.xzxms.inquiry.vm.SysDeviceTypeTree;

import java.util.List;

public interface SysDeviceTypeExtendMapper {

    /**
     * 查询设备类型树
     * @return
     */
    List<SysDeviceTypeTree> findPrivilegeTree();
}