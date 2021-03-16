package com.xzx.xzxms.commons.aspect;

import com.alibaba.fastjson.JSONObject;
import com.xzx.xzxms.commons.aspect.annotation.AutoAnnouncementPush;
import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.constant.WebSocketConstant;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.commons.websocket.WebSocket;
import com.xzx.xzxms.system.bean.SysAnnouncementSend;
import com.xzx.xzxms.system.bean.SysAnnouncementWithBLOBs;
import com.xzx.xzxms.system.dao.SysAnnouncementMapper;
import com.xzx.xzxms.system.dao.SysAnnouncementSendMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统通知 切面处理类
 * @Author Lzc
 * @Date 2021/3/15 14:19
 * @Version 1.0
 */
@Aspect
@Component
public class AutoAnnouncementPushAspect {
    @Resource
    private SysAnnouncementMapper announcementMapper;
    @Resource
    private SysAnnouncementSendMapper announcementSendMapper;
    @Resource
    private WebSocket webSocket;

    // 切面
    @Pointcut("@annotation(com.xzx.xzxms.commons.aspect.annotation.AutoAnnouncementPush)")
    public void announcementPushPointCut() {

    }

    // 后置通知
    @Transactional
    @After("announcementPushPointCut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        // 获取注解内容
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AutoAnnouncementPush annotation = method.getAnnotation(AutoAnnouncementPush.class);
        String msgCategory = annotation.msgCategory();
        String msgType = annotation.msgType();

        Object[] args = joinPoint.getArgs();
        Date date = new Date();
        for (Object arg : args) {
            // 获取通知参数
            if (arg instanceof SysAnnouncementWithBLOBs) {
                // 如果是USER 指定用户通知
                SysAnnouncementWithBLOBs announcement = new SysAnnouncementWithBLOBs();
                String anntId = IDUtils.getId()+"";
                JSONObject obj = new JSONObject();
                obj.put(WebSocketConstant.MSG_CMD, WebSocketConstant.CMD_USER);
                if (CommonConstant.MSG_TYPE_UESR.equals(msgType)) {
                    // 获取通知人
                    announcement = (SysAnnouncementWithBLOBs) arg;
                    String userIds = announcement.getUserIds();
                    // 如果多个，遍历
                    String[] ids = {};
                    if (userIds.contains("-")) {
                        ids = userIds.split("-");
                    }else {
                        ids = new String[]{userIds};
                    }
                    // 插入通知表
                    announcement.setId(anntId);
                    announcement.setMsgCategory(msgCategory);
                    announcement.setMsgContent(annotation.value()+announcement.getMsgContent());
                    announcement.setMsgType(msgType);
                    announcement.setTitile(annotation.title());
                    announcement.setSendStatus(CommonConstant.HAS_SEND);
                    announcement.setSendTime(date);
                    announcement.setCreateTime(date);
                    announcement.setDelFlag(CommonConstant.DEL_FLAG_0+"");
                    announcementMapper.insert(announcement);
                    for (String id : ids) {
                        // 插入用户通知表
                        SysAnnouncementSend announcementSend = new SysAnnouncementSend();
                        announcementSend.setId(IDUtils.getId()+"");
                        announcementSend.setUserId(id);
                        announcementSend.setAnntId(anntId);
                        announcementSend.setReadFlag(CommonConstant.NO_READ_FLAG);
                        announcementSend.setCreateTime(date);
                        announcementSend.setCreateBy(announcement.getCreateBy());
                        announcementSendMapper.insert(announcementSend);
                    }
                    // 发送推送消息(单点消息(多人))
                    obj.put(WebSocketConstant.MSG_TXT, annotation.title());
                    webSocket.sendMoreMessage(ids, obj.toJSONString());
                }else {
                    // 如果是All 所有用户通知
                    announcement.setId(anntId);
                    announcement.setMsgCategory(msgCategory);
                    announcement.setMsgContent(annotation.value()+announcement.getMsgContent());
                    announcement.setMsgType(msgType);
                    announcement.setTitile(annotation.title());
                    announcement.setSendStatus(CommonConstant.HAS_SEND);
                    announcement.setSendTime(date);
                    announcement.setCreateTime(date);
                    announcement.setDelFlag(CommonConstant.DEL_FLAG_0+"");
                    announcementMapper.insert(announcement);
                    // 发送推送消息(广播消息)
                    obj.put(WebSocketConstant.MSG_TXT, annotation.title());
                    webSocket.sendAllMessage(obj.toJSONString());
                }
            }
        }
    }
}
