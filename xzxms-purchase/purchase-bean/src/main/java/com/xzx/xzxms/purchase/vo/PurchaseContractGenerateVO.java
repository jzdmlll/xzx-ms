package com.xzx.xzxms.purchase.vo;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/8 14:41
 * @修改人：
 * @修改时间：2021/1/8 14:41
 * @修改描述：默认描述
 */
public class PurchaseContractGenerateVO {
    private Long id;
    private Integer serialNumber;
    private String supplier;
    private String brand;
    private String model;
    private String item;
    private String unit;
    private Integer number;
    private Double price;
    private Double totalPrice;
    private String supplyParams;
    private String itemsParams;
    private String warranty;
    private String remark;

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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getSupplyParams() {
        return supplyParams;
    }

    public void setSupplyParams(String supplyParams) {
        this.supplyParams = supplyParams;
    }

    public String getItemsParams() {
        return itemsParams;
    }

    public void setItemsParams(String itemsParams) {
        this.itemsParams = itemsParams;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PurchaseContractGenerateVM{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", supplier='" + supplier + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", item='" + item + '\'' +
                ", unit='" + unit + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", supplyParams='" + supplyParams + '\'' +
                ", itemsParams='" + itemsParams + '\'' +
                ", warranty='" + warranty + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
