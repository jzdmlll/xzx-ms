package com.xzx.xzxms.system.service.impl;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.system.bean.SysAnnouncementSend;
import com.xzx.xzxms.system.bean.SysAnnouncementSendExample;
import com.xzx.xzxms.system.bean.extend.SysAnnouncementExtend;
import com.xzx.xzxms.system.dao.SysAnnouncementSendMapper;
import com.xzx.xzxms.system.dao.extend.SysAnnouncementSendExtendMapper;
import com.xzx.xzxms.system.service.ISysAnnouncementSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public PageInfo<SysAnnouncementExtend> getMyAnnouncementSendPage(Page<SysAnnouncementExtend> page, Long userId, String readFlag, String msgCategory) {

        List<SysAnnouncementExtend> announcementSendPage = sysAnnouncementSendExtendMapper.getMyAnnouncementSendPage(userId, readFlag, msgCategory);

        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        PageInfo<SysAnnouncementExtend> pageInfo = new PageInfo<>(announcementSendPage);
        PageHelper.clearPage();
        return pageInfo;
    }

    @Override
    public void editByAnntIdAndUserId(Long userId, String anntSendId) {
        SysAnnouncementSend sysAnnouncementSend = new SysAnnouncementSend();
        sysAnnouncementSend.setId(anntSendId);
        sysAnnouncementSend.setReadFlag(CommonConstant.HAS_READ_FLAG);
        sysAnnouncementSend.setReadTime(new Date());

        sysAnnouncementSendMapper.updateByPrimaryKeySelective(sysAnnouncementSend);
    }
}
