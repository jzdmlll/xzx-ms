package com.xzx.xzxms.dao.extend;


import com.xzx.xzxms.bean.SysDeviceType;

import java.util.List;

public interface SysDeviceTypeExtendMapper {

    /**
     * 根据设备类型模糊查询相关内容
     * @param name
     * @param code
     * @return
     */
    List<SysDeviceType> findAllLike(String name,String code);
}