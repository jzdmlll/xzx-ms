package com.xzx.xzxms.purchase.vo;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/8 14:47
 * @修改人：
 * @修改时间：2021/1/8 14:47
 * @修改描述：默认描述
 */
public class PurchaseItemsVO {
    private Long id;
    private Long contractId;
    private Long projectId;
    private Double serialNumber;
    private String item;
    private String brand;
    private String params;
    private String model;
    private String unit;
    private Double number;
    private Integer isInquiry;
    private String remark;
    private Integer isActive;
    private String operator;
    private Long time;

    private String parentId;
    private String tagNumer;
    private String meter;
    private String measuringRange;
    private String meterSignal;
    private String connectionMode;
    private String tube;
    private Long templateId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Integer getIsInquiry() {
        return isInquiry;
    }

    public void setIsInquiry(Integer isInquiry) {
        this.isInquiry = isInquiry;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PurchaseItemsVO{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", projectId=" + projectId +
                ", serialNumber=" + serialNumber +
                ", item='" + item + '\'' +
                ", brand='" + brand + '\'' +
                ", params='" + params + '\'' +
                ", model='" + model + '\'' +
                ", unit='" + unit + '\'' +
                ", number=" + number +
                ", isInquiry=" + isInquiry +
                ", remark='" + remark + '\'' +
                ", isActive=" + isActive +
                ", operator='" + operator + '\'' +
                ", time=" + time +
                '}';
    }
}
