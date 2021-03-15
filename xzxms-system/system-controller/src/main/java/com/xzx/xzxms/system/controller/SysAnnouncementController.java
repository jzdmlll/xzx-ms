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
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param resp
     * @return
     */
    @GetMapping("getMyAnnouncementSend")
    public Message getMyAnnouncementSend(HttpServletResponse resp,
                                         @RequestParam(name="readFlag", defaultValue="0") String readFlag,
                                         @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                         @RequestParam(name="pageSize", defaultValue="10") Integer pageSize) {
        // 获取当前用户ID
        String token = resp.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        Long userId = Long.parseLong(JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret));

        Page<SysAnnouncementExtend> page = new Page<>(pageNo, pageSize);
        page.setOrderBy("send_time desc");
        PageInfo<SysAnnouncementExtend> announcement = sysAnnouncementSendService.getMyAnnouncementSendPage(page, userId, readFlag, "1");
        PageInfo<SysAnnouncementExtend> sysAnnouncement = sysAnnouncementSendService.getMyAnnouncementSendPage(page, userId, readFlag, "2");

        Map<String, PageInfo<SysAnnouncementExtend>> result = new HashMap<>();
        result.put("announcement", announcement);
        result.put("sysAnnouncement", sysAnnouncement);

        return MessageUtil.success("success", result);
    }

}
