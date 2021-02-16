package com.xzx.xzxms.system.bean.extend;

import com.xzx.xzxms.system.bean.SysAnnouncementWithBLOBs;

/**
 * @Author Lzc
 * @Date 2021/2/16 16:42
 * @Version 1.0
 */
public class SysAnnouncementExtend extends SysAnnouncementWithBLOBs {

    private String anntId;

    private String userId;

    private String readFlag;

    public String getAnntId() {
        return anntId;
    }

    public void setAnntId(String anntId) {
        this.anntId = anntId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }
}
