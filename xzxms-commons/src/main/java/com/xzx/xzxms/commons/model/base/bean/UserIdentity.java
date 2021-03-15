package com.xzx.xzxms.commons.model.base.bean;

/**
 * @Author Lzc
 * @Date 2021/3/15 12:48
 * @Version 1.0
 */
public class UserIdentity {

    private Long userId;
    private String token;
    private String username;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
