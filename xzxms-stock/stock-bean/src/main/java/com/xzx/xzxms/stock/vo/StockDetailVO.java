package com.xzx.xzxms.stock.vo;

/**
 * @author：ZJW
 * @title：库存暂估明细表
 * @date：2021/2/26 14:27
 * @修改人：
 * @修改时间：2021/2/26 14:27
 * @修改描述：默认描述
 */
public class StockDetailVO {
    private String itemName; // 品名
    private String specification; // 规格型号
    private String unit; // 计量单位
    private Double price; // 单价
    private Double lastNum; // 上月暂估数量
    private Double lasePrice; // 上月暂估金额
    private Double addNum; // 本月增加数量
    private Double addPrice; // 本月增加金额
    private Double reduceNum; // 本月减少数量
    private Double reducePrice; // 本月减少金额
    private Double number; // 月末暂估数量
    private Double totalPrice; // 月末暂估金额

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getLastNum() {
        return lastNum;
    }

    public void setLastNum(Double lastNum) {
        this.lastNum = lastNum;
    }

    public Double getLasePrice() {
        return lasePrice;
    }

    public void setLasePrice(Double lasePrice) {
        this.lasePrice = lasePrice;
    }

    public Double getAddNum() {
        return addNum;
    }

    public void setAddNum(Double addNum) {
        this.addNum = addNum;
    }

    public Double getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(Double addPrice) {
        this.addPrice = addPrice;
    }

    public Double getReduceNum() {
        return reduceNum;
    }

    public void setReduceNum(Double reduceNum) {
        this.reduceNum = reduceNum;
    }

    public Double getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(Double reducePrice) {
        this.reducePrice = reducePrice;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "StockDetailVO{" +
                "itemName='" + itemName + '\'' +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", lastNum=" + lastNum +
                ", lasePrice=" + lasePrice +
                ", addNum=" + addNum +
                ", addPrice=" + addPrice +
                ", reduceNum=" + reduceNum +
                ", reducePrice=" + reducePrice +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
