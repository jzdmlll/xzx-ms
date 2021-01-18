package com.xzx.xzxms.system.service;

import com.xzx.xzxms.system.bean.SysAnnouncement;
import com.xzx.xzxms.system.bean.SysAnnouncementWithBLOBs;

/**
 * 系统通知表
 * @Author Lzc
 * @Date 2021/1/15 17:04
 * @Version 1.0
 */
public interface ISysAnnouncementService {
    /**
     * 保存一条通知记录
     * @param sysAnnouncement
     */
    void saveAnnouncement(SysAnnouncementWithBLOBs sysAnnouncement);

    /**
     * 更新一条通知记录
     * @param sysAnnouncement
     * @return
     */
    boolean updateAnnouncement(SysAnnouncementWithBLOBs sysAnnouncement);

    /**
     *
     * @param title
     * @param msgContent
     */
    void saveSysAnnouncement(String title, String msgContent);

}
