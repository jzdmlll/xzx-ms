package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.SysProCheck;

import java.util.List;

public class FinallyCheckCompareVM extends QuoteRespVM {
    //最低价(1代表最低价)
    private int minPrice;
    private SysProCheck finalCheck;
    private double price;
    private double totalPrice;

    public SysProCheck getFinalCheck() {
        return finalCheck;
    }

    public void setFinalCheck(SysProCheck finalCheck) {
        this.finalCheck = finalCheck;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

}
