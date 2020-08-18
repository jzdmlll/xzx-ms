package com.xzx.xzxms.web.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@ServerEndpoint(value="/Room/{username}") // 当创建好一个（服务）端点之后，将它以一个指定的URI发布到应用当中，这样远程客户端就能连接上它了
public class WSController {
    private static List<Session> sessions = new ArrayList<Session>();
    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "username") String username) {
        sessions.add(session);
        sendTextMsg("好友 [" + username + "]加入群聊");
    }
    @OnMessage
    public void OnMsg(String msg,@PathParam(value = "username") String username) {
        sendTextMsg(username + ":" +msg);
    }
    @OnClose
    public void OnClose(Session session, @PathParam("username") String username) throws IOException {
        sessions.remove(session);
        sendTextMsg("好友 ["+ username + "] 退出群聊");
    }
    @OnError
    public void OnError(Throwable e) {
        e.printStackTrace();
    }
    private void sendTextMsg(String msg) {
        for (Session session : sessions) {
            session.getAsyncRemote().sendText(msg);
        }
    }
}