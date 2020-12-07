package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Inquiry;

public class InquiryExtend extends Inquiry {
    private int checkStatus;
    private int quoteNum;
    private String deviceModel;

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
