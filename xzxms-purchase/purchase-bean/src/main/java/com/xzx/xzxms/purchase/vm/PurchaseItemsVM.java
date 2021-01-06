package com.xzx.xzxms.purchase.vm;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/21 14:35
 * @修改人：
 * @修改时间：2020/12/21 14:35
 * @修改描述：默认描述
 */
public class PurchaseItemsVM {

    private Long id;
    private Long contractId;
    private Long projectId;
    private Integer serialNumber;
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
        return "PurchaseItemsVM{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", projectId='" + projectId + '\'' +
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
                ", operator=" + operator +
                ", time=" + time +
                '}';
    }
}
