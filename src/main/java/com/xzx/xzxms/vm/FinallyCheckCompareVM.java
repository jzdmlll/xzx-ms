package com.xzx.xzxms.vm;

public class FinallyCheckCompareVM extends QuoteRespVM {
    //最低价(1代表最低价)
    private int minPrice;
    private String finalRemark;

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public String getFinalRemark() {
        return finalRemark;
    }

    public void setFinalRemark(String finalRemark) {
        this.finalRemark = finalRemark;
    }
}
