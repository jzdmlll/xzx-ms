package com.xzx.xzxms.service;


import com.xzx.xzxms.bean.SysFile;
import com.xzx.xzxms.bean.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     * 查询全部内容
     * @return
     */
    List<SysLog> findAll();

    /**
     * 根据设备类别的ID查询相对应的询价全部内容
     * @param logId
     * @return
     */
    List<SysLog> findById(long logId);

    /**
     * 保存或更改设备类别信息
     * @param sysLog
     */
    void saveOrUpdate(SysLog sysLog);

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
