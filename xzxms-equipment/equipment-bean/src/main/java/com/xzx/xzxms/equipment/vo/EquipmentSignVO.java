package com.xzx.xzxms.equipment.vo;

/**
 * @author：ZJW
 * @title：签收界面显示字段信息
 * @date：2021/1/31 13:14
 * @修改人：
 * @修改时间：2021/1/31 13:14
 * @修改描述：默认描述
 */
public class EquipmentSignVO {
    private Long itemId;
    private Long contractId;
    private Long projectId;
    private Double serialNumber;
    private String item;
    private String brand;
    private String params;
    private String model;
    private Double number;
    private String unit;
    private String tagNumber;
    private String meter;
    private String measuringRange;
    private String meterSignal;
    private String connectionMode;
    private String tube;
    private Long supplierId;
    private String supplier;
    private Double price;
    private String contractName;
    private String projectName;
    private Long orderId;
    private Double alreadySignNum; //已签收数量
    private Double notSignNum; //剩余签收数量
    private Double alreadyInStorageNum; // 已入库数量
    private Double notInStorageNum; // 可入库数量

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Double getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Double serialNumber) {
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

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getMeasuringRange() {
        return measuringRange;
    }

    public void setMeasuringRange(String measuringRange) {
        this.measuringRange = measuringRange;
    }

    public String getMeterSignal() {
        return meterSignal;
    }

    public void setMeterSignal(String meterSignal) {
        this.meterSignal = meterSignal;
    }

    public String getConnectionMode() {
        return connectionMode;
    }

    public void setConnectionMode(String connectionMode) {
        this.connectionMode = connectionMode;
    }

    public String getTube() {
        return tube;
    }

    public void setTube(String tube) {
        this.tube = tube;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getNotSignNum() {
        return notSignNum;
    }

    public void setNotSignNum(Double notSignNum) {
        this.notSignNum = notSignNum;
    }

    public Double getAlreadySignNum() {
        return alreadySignNum;
    }

    public void setAlreadySignNum(Double alreadySignNum) {
        this.alreadySignNum = alreadySignNum;
    }

    public Double getAlreadyInStorageNum() {
        return alreadyInStorageNum;
    }

    public void setAlreadyInStorageNum(Double alreadyInStorageNum) {
        this.alreadyInStorageNum = alreadyInStorageNum;
    }

    public Double getNotInStorageNum() {
        return notInStorageNum;
    }

    public void setNotInStorageNum(Double notInStorageNum) {
        this.notInStorageNum = notInStorageNum;
    }

    @Override
    public String toString() {
        return "EquipmentSignVO{" +
                "itemId=" + itemId +
                ", contractId=" + contractId +
                ", projectId=" + projectId +
                ", serialNumber=" + serialNumber +
                ", item='" + item + '\'' +
                ", brand='" + brand + '\'' +
                ", params='" + params + '\'' +
                ", model='" + model + '\'' +
                ", number=" + number +
                ", unit='" + unit + '\'' +
                ", tagNumber='" + tagNumber + '\'' +
                ", meter='" + meter + '\'' +
                ", measuringRange='" + measuringRange + '\'' +
                ", meterSignal='" + meterSignal + '\'' +
                ", connectionMode='" + connectionMode + '\'' +
                ", tube='" + tube + '\'' +
                ", supplierId=" + supplierId +
                ", supplier='" + supplier + '\'' +
                ", price=" + price +
                ", contractName='" + contractName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", orderId=" + orderId +
                ", alreadySignNum=" + alreadySignNum +
                ", notSignNum=" + notSignNum +
                ", alreadyInStorageNum=" + alreadyInStorageNum +
                ", notInStorageNum=" + notInStorageNum +
                '}';
    }
}
