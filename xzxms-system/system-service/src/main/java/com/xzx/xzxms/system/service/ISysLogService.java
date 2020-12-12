package com.xzx.xzxms.system.service;


import com.xzx.xzxms.system.bean.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     * 查询全部内容
     * @return
     */
    List<SysLog> findAll();

    /**
     *
     * @param logId
     * @return
     */
    List<SysLog> findById(long logId);

    /**
     *
     * @param sysLog
     */
    void record(SysLog sysLog);

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
