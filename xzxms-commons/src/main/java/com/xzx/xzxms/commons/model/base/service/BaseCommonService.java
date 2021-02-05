package com.xzx.xzxms.commons.model.base.service;

import com.xzx.xzxms.system.bean.SysLog;
import com.xzx.xzxms.system.bean.SysUser;

/**
 * common接口
 */
public interface BaseCommonService {

    /**
     * 保存日志
     * @param log
     */
    void addLog(SysLog log);

    /**
     * 保存日志
     * @param LogContent
     * @param logType
     * @param operateType
     * @param user
     */
    void addLog(String LogContent, Integer logType, Integer operateType, SysUser user);

    /**
     * 保存日志
     * @param LogContent
     * @param logType
     * @param operateType
     */
    void addLog(String LogContent, Integer logType, Integer operateType);

    /**
     * 移除权限redis缓存
     */
    void removePrivilegeRedis();

}
