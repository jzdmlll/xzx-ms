package com.xzx.xzxms.system.service.impl;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.system.bean.extend.SysAnnouncementExtend;
import com.xzx.xzxms.system.dao.SysAnnouncementSendMapper;
import com.xzx.xzxms.system.dao.extend.SysAnnouncementSendExtendMapper;
import com.xzx.xzxms.system.service.ISysAnnouncementSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/1/18 10:42
 * @Version 1.0
 */
@Service
public class SysAnnouncementSendServiceImpl implements ISysAnnouncementSendService {

    @Resource
    private SysAnnouncementSendMapper sysAnnouncementSendMapper;

    @Resource
    private SysAnnouncementSendExtendMapper sysAnnouncementSendExtendMapper;

    @Override
    public List<String> findByUserId(String userId) {
        return sysAnnouncementSendExtendMapper.findByUserId(userId);
    }

    @Override
    public PageInfo<SysAnnouncementExtend> getMyAnnouncementSendPage(Page<SysAnnouncementExtend> page, Long userId, String readFlag) {

        List<SysAnnouncementExtend> announcementSendPage = sysAnnouncementSendExtendMapper.getMyAnnouncementSendPage(userId, readFlag);

        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        return new PageInfo<>(announcementSendPage);
    }
}
