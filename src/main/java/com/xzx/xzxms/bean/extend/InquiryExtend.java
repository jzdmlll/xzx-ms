package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Inquiry;

public class InquiryExtend extends Inquiry {
    private int checkStatus;
    private int quoteNum;
    private int poolNum;
    private int refuseNum;
    private String deviceModel;

    public int getRefuseNum() {
        return refuseNum;
    }

    public void setRefuseNum(int refuseNum) {
        this.refuseNum = refuseNum;
    }

    public int getPoolNum() {
        return poolNum;
    }

    public void setPoolNum(int poolNum) {
        this.poolNum = poolNum;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getQuoteNum() {
        return quoteNum;
    }

    public void setQuoteNum(int quoteNum) {
        this.quoteNum = quoteNum;
    }
}
