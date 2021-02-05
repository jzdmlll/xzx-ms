package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.system.bean.SysAnnouncementExample;
import com.xzx.xzxms.system.bean.SysAnnouncementSend;
import com.xzx.xzxms.system.bean.SysAnnouncementSendExample;
import com.xzx.xzxms.system.bean.SysAnnouncementWithBLOBs;
import com.xzx.xzxms.system.dao.SysAnnouncementMapper;
import com.xzx.xzxms.system.dao.SysAnnouncementSendMapper;
import com.xzx.xzxms.system.service.ISysAnnouncementService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/1/15 17:08
 * @Version 1.0
 */
@Service
public class SysAnnouncementServiceImpl implements ISysAnnouncementService {

    @Resource
    private SysAnnouncementMapper sysAnnouncementMapper;
    @Resource
    private SysAnnouncementSendMapper sysAnnouncementSendMapper;

    @Override
    public void saveAnnouncement(SysAnnouncementWithBLOBs sysAnnouncement) {

        if(sysAnnouncement.getMsgType().equals(CommonConstant.MSG_TYPE_ALL)) {
            sysAnnouncementMapper.insert(sysAnnouncement);
        }else {
            // 1.插入通告表记录
            sysAnnouncementMapper.insert(sysAnnouncement);
            // 2.插入用户通告阅读标记表记录
            String userId = sysAnnouncement.getUserIds();
            String[] userIds = userId.substring(0, (userId.length()-1)).split(",");
            String anntId = sysAnnouncement.getId();
            Date refDate = new Date();
            for(int i=0;i<userIds.length;i++) {
                SysAnnouncementSend announcementSend = new SysAnnouncementSend();
                announcementSend.setAnntId(anntId);
                announcementSend.setUserId(userIds[i]);
                announcementSend.setReadFlag(CommonConstant.NO_READ_FLAG);
                announcementSend.setReadTime(refDate);
                sysAnnouncementSendMapper.insert(announcementSend);
            }
        }
    }

    @Override
    public boolean updateAnnouncement(SysAnnouncementWithBLOBs sysAnnouncement) {
        // 1.更新系统信息表数据
        sysAnnouncementMapper.updateByPrimaryKey(sysAnnouncement);
        String userId = sysAnnouncement.getUserIds();
        if(StringUtils.isNotEmpty(userId) && sysAnnouncement.getMsgType().equals(CommonConstant.MSG_TYPE_UESR)) {
            // 2.补充新的通知用户数据
            String[] userIds = userId.substring(0, (userId.length()-1)).split(",");
            String anntId = sysAnnouncement.getId();
            Date refDate = new Date();
            for(int i=0;i<userIds.length;i++) {
                SysAnnouncementSendExample sysAnnouncementSendExample = new SysAnnouncementSendExample();
                sysAnnouncementSendExample.createCriteria().andAnntIdEqualTo(anntId).andUserIdEqualTo(userIds[i]);
                List<SysAnnouncementSend> sysAnnouncementSends = sysAnnouncementSendMapper.selectByExample(sysAnnouncementSendExample);
                if(sysAnnouncementSends.size()<=0) {
                    SysAnnouncementSend announcementSend = new SysAnnouncementSend();
                    announcementSend.setAnntId(anntId);
                    announcementSend.setUserId(userIds[i]);
                    announcementSend.setReadFlag(CommonConstant.NO_READ_FLAG);
                    announcementSend.setReadTime(refDate);
                    sysAnnouncementSendMapper.insert(announcementSend);
                }
            }
            // 3. 删除多余通知用户数据
            List<String> delUserIds = Arrays.asList(userIds);
            SysAnnouncementSendExample sysAnnouncementSendExample = new SysAnnouncementSendExample();
            sysAnnouncementSendExample.createCriteria().andUserIdNotIn(delUserIds).andAnntIdEqualTo(anntId);
            sysAnnouncementSendMapper.deleteByExample(sysAnnouncementSendExample);

        }
        return true;
    }

    @Override
    public void saveSysAnnouncement(String title, String msgContent) {

    }
}
