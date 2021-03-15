package com.xzx.xzxms.system.controller;

import com.xzx.xzxms.commons.annotation.CurrentUser;
import com.xzx.xzxms.commons.model.base.bean.UserIdentity;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.service.ISysAnnouncementSendService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lzc
 * @Date 2021/3/15 9:59
 * @Version 1.0
 */
@RequestMapping("/sys/announcementSend")
@RestController
public class SysAnnouncementSendController {
    @Resource
    private ISysAnnouncementSendService sysAnnouncementSendService;

    /**
     * 更改用户消息已读状态
     * @param userIdentity
     * @param anntSendId
     * @return
     */
    @PostMapping("editByAnntIdAndUserId")
    public Message editByAnntIdAndUserId(@CurrentUser UserIdentity userIdentity, String anntSendId) {
        sysAnnouncementSendService.editByAnntIdAndUserId(userIdentity.getUserId(), anntSendId);
        return MessageUtil.success("success");
    }
}
