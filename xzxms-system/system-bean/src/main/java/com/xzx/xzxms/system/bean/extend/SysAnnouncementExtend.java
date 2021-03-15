package com.xzx.xzxms.system.bean.extend;

import com.xzx.xzxms.system.bean.SysAnnouncementWithBLOBs;

/**
 * @Author Lzc
 * @Date 2021/2/16 16:42
 * @Version 1.0
 */
public class SysAnnouncementExtend extends SysAnnouncementWithBLOBs {

    private String anntSendId;

    private String userId;

    private String readFlag;

    public String getAnntSendId() {
        return anntSendId;
    }

    public void setAnntSendId(String anntSendId) {
        this.anntSendId = anntSendId;
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
