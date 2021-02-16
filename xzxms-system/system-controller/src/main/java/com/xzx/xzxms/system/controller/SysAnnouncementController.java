package com.xzx.xzxms.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.commons.utils.JwtTokenUtil;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.bean.extend.SysAnnouncementExtend;
import com.xzx.xzxms.system.service.ISysAnnouncementSendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 系统通知控制器
 * @Author Lzc
 * @Date 2021/1/15 16:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/annountCement")
public class SysAnnouncementController {

    @Resource
    private ISysAnnouncementSendService sysAnnouncementSendService;
    /**
     * 获取当前用户通知消息
     * @param request
     * @return
     */
    @GetMapping("getMyAnnouncementSend")
    public Message getMyAnnouncementSend(HttpServletRequest request,
                                         @RequestParam(name="readFlag", defaultValue="0") String readFlag,
                                         @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                         @RequestParam(name="pageSize", defaultValue="10") Integer pageSize) {
        // 获取当前用户ID
        String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        Long userId = Long.parseLong(JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret));

        Page<SysAnnouncementExtend> page = new Page<>(pageNo, pageSize);
        page.setOrderBy("send_time desc");
        PageInfo<SysAnnouncementExtend> announcementSendPage = sysAnnouncementSendService.getMyAnnouncementSendPage(page, userId, readFlag);

        return MessageUtil.success("success", announcementSendPage);
    }

}
