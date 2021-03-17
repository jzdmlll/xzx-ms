package com.xzx.xzxms.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * 获取用户消息
     * @return
     */
    IPage<SysAnnouncementExtend> getMyAnnouncementSendPage(Page<SysAnnouncementExtend> page, Long userId, String readFlag, String msgCategory);

    /**
     * 更改用户消息已读状态
     * @param userId
     * @param anntSendId
     */
    void editByAnntIdAndUserId(Long userId, String anntSendId);
}
