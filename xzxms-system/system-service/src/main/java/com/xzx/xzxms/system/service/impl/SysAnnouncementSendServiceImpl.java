package com.xzx.xzxms.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.system.bean.SysAnnouncementSend;
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
    public IPage<SysAnnouncementExtend> getMyAnnouncementSendPage(Page<SysAnnouncementExtend> page, Long userId, String readFlag, String msgCategory) {
        return sysAnnouncementSendExtendMapper.getMyAnnouncementSendPage(page, userId, readFlag, msgCategory);
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
