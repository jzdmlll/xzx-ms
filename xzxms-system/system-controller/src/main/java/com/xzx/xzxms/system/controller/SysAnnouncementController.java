package com.xzx.xzxms.system.controller;

import com.xzx.xzxms.commons.websocket.WebSocket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    private WebSocket webSocket;
}
