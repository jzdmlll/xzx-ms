package com.xzx.xzxms.inquiry.vm;


import com.xzx.xzxms.inquiry.bean.SysProCheck;

public class FinallyCheckCompareVM extends QuoteRespVM {

    private SysProCheck finalCheck;
    private double price;
    private double totalPrice;
    private int sort;

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
