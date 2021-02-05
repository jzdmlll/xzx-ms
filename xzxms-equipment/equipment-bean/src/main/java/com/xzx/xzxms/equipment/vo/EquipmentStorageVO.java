package com.xzx.xzxms.equipment.vo;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/4 15:28
 * @修改人：
 * @修改时间：2021/2/4 15:28
 * @修改描述：默认描述
 */
public class EquipmentStorageVO {
    private Long storageId;
    private Long projectId;
    private Long itemId;
    private String item;
    private String params;
    private String model;
    private Double number;
    private Long supplierId;
    private String remark;
    private String tagNumer;
    private String meter;
    private String measuringRange;
    private String meterSignal;
    private String connectionMode;
    private String tube;
    private String projectName;
    private String supplierName;

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTagNumer() {
        return tagNumer;
    }

    public void setTagNumer(String tagNumer) {
        this.tagNumer = tagNumer;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "EquipmentStorageVO{" +
                "storageId=" + storageId +
                ", projectId=" + projectId +
                ", itemId=" + itemId +
                ", item='" + item + '\'' +
                ", params='" + params + '\'' +
                ", model='" + model + '\'' +
                ", number=" + number +
                ", supplierId=" + supplierId +
                ", remark='" + remark + '\'' +
                ", tagNumer='" + tagNumer + '\'' +
                ", meter='" + meter + '\'' +
                ", measuringRange='" + measuringRange + '\'' +
                ", meterSignal='" + meterSignal + '\'' +
                ", connectionMode='" + connectionMode + '\'' +
                ", tube='" + tube + '\'' +
                ", projectName='" + projectName + '\'' +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }
}
