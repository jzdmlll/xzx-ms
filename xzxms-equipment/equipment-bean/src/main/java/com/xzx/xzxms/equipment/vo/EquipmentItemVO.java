package com.xzx.xzxms.equipment.vo;

/**
 * @author：ZJW
 * @title：用于获取该合同下所有购买项的信息
 * @date：2021/1/24 15:43
 * @修改人：
 * @修改时间：2021/1/24 15:43
 * @修改描述：默认描述
 */
public class EquipmentItemVO {
    private Long id;
    private Integer serialNumber;
    private String item;
    private String brand;
    private String params;
    private String model;
    private Double number;
    private String unit;
    private Long supplyId;
    private String supplier;
    private Double price;
    private Double totalPrice;
    private String warranty; //保质期
    private Long OrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    @Override
    public String toString() {
        return "EquipmentItemVO{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", item='" + item + '\'' +
                ", brand='" + brand + '\'' +
                ", params='" + params + '\'' +
                ", model='" + model + '\'' +
                ", number=" + number +
                ", unit='" + unit + '\'' +
                ", supplyId=" + supplyId +
                ", supplier='" + supplier + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", warranty='" + warranty + '\'' +
                ", OrderId=" + OrderId +
                '}';
    }
}
