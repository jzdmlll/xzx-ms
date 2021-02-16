package com.xzx.xzxms.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.system.bean.extend.SysAnnouncementExtend;

import java.util.List;

/**
 * 用户接收通知表
 * @Author Lzc
 * @Date 2021/1/18 10:29
 * @Version 1.0
 */
public interface ISysAnnouncementSendService {
    /**
     *
     * @param userId
     * @return
     */
    List<String> findByUserId(String userId);

    /**
     *
     * @return
     */
    PageInfo<SysAnnouncementExtend> getMyAnnouncementSendPage(Page<SysAnnouncementExtend> page, Long userId, String readFlag);
}
