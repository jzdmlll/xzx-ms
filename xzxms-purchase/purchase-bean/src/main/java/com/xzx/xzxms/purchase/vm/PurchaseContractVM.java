package com.xzx.xzxms.purchase.vm;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/16 9:38
 * @修改人：
 * @修改时间：2020/12/16 9:38
 * @修改描述：默认描述
 */
public class PurchaseContractVM {
    /**
     * 主键
     */
    private Long id;
    private String contractNo;
    private Long projectId;
    private Long attributeId;
    private String contractName;
    private Integer firstAudit;
    private Integer secondAudit;
    private Integer threeAudit;
    private String firstRemark;
    private String secondRemark;
    private String threeRemark;
    private Integer isActive;
    private Long time;
    private String operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Integer getFirstAudit() {
        return firstAudit;
    }

    public void setFirstAudit(Integer firstAudit) {
        this.firstAudit = firstAudit;
    }

    public Integer getSecondAudit() {
        return secondAudit;
    }

    public void setSecondAudit(Integer secondAudit) {
        this.secondAudit = secondAudit;
    }

    public Integer getThreeAudit() {
        return threeAudit;
    }

    public void setThreeAudit(Integer threeAudit) {
        this.threeAudit = threeAudit;
    }

    public String getFirstRemark() {
        return firstRemark;
    }

    public void setFirstRemark(String firstRemark) {
        this.firstRemark = firstRemark;
    }

    public String getSecondRemark() {
        return secondRemark;
    }

    public void setSecondRemark(String secondRemark) {
        this.secondRemark = secondRemark;
    }

    public String getThreeRemark() {
        return threeRemark;
    }

    public void setThreeRemark(String threeRemark) {
        this.threeRemark = threeRemark;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "PurchaseContractVM{" +
                "id=" + id +
                ", contractNo='" + contractNo + '\'' +
                ", projectId=" + projectId +
                ", attributeId=" + attributeId +
                ", contractName='" + contractName + '\'' +
                ", firstAudit=" + firstAudit +
                ", secondAudit=" + secondAudit +
                ", threeAudit=" + threeAudit +
                ", firstRemark='" + firstRemark + '\'' +
                ", secondRemark='" + secondRemark + '\'' +
                ", threeRemark='" + threeRemark + '\'' +
                ", isActive=" + isActive +
                ", time=" + time +
                ", operator=" + operator +
                '}';
    }
}
