package com.xzx.xzxms.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzx.xzxms.commons.constant.WebSocketConstant;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.commons.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lzc
 * @Date 2021/1/15 10:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/webSocket")
public class WebSocketController {
    
    @Autowired
    private WebSocket webSocket;

    @PostMapping("/sendAll")
    public Message sendAll(@RequestBody JSONObject jsonObject) {
        String message = jsonObject.getString("message");
        JSONObject obj = new JSONObject();
        obj.put(WebSocketConstant.MSG_CMD, WebSocketConstant.CMD_TOPIC);
        obj.put(WebSocketConstant.MSG_ID, "M0001");
        obj.put(WebSocketConstant.MSG_TXT, message);
        webSocket.sendAllMessage(obj.toJSONString());
        return MessageUtil.success("群发");
    }

    @PostMapping("/sendUser")
    public Message sendUser(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getString("userId");
        String message = jsonObject.getString("message");
        JSONObject obj = new JSONObject();
        obj.put(WebSocketConstant.MSG_CMD, WebSocketConstant.CMD_USER);
        obj.put(WebSocketConstant.MSG_USER_ID, userId);
        obj.put(WebSocketConstant.MSG_ID, "M0001");
        obj.put(WebSocketConstant.MSG_TXT, message);
        webSocket.sendOneMessage(userId, obj.toJSONString());
        return MessageUtil.success("单发");
    }
}
