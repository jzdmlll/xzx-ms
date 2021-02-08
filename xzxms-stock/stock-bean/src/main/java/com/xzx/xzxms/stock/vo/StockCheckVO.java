package com.xzx.xzxms.stock.vo;/**
 * @Author sunny
 * @Date 2021/2/8 14:48
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

/**
 *@ClassName StockCheckVO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class StockCheckVO {

    private Double notSignedNum;
    private Long id;
    private Double number;
    private String item;
    private String model;
    private String brand;
    private String params;
    private String price;
    private String delivery;
    private String remark;
    private String warranty;

    public Double getNotSignedNum() {
        return notSignedNum;
    }

    public void setNotSignedNum(Double notSignedNum) {
        this.notSignedNum = notSignedNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}
