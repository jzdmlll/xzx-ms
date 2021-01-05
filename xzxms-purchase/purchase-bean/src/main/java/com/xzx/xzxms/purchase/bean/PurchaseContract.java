package com.xzx.xzxms.purchase.bean;

public class PurchaseContract {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.contract_no
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String contractNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.project_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.attribute_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long attributeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.contract_name
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String contractName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.first_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Integer firstAudit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.second_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Integer secondAudit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.three_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Integer threeAudit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.first_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String firstRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.second_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String secondRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.three_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String threeRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.is_active
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.update_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract.update_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.id
     *
     * @return the value of purchase_contract.id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.id
     *
     * @param id the value for purchase_contract.id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.contract_no
     *
     * @return the value of purchase_contract.contract_no
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.contract_no
     *
     * @param contractNo the value for purchase_contract.contract_no
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.project_id
     *
     * @return the value of purchase_contract.project_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.project_id
     *
     * @param projectId the value for purchase_contract.project_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.attribute_id
     *
     * @return the value of purchase_contract.attribute_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getAttributeId() {
        return attributeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.attribute_id
     *
     * @param attributeId the value for purchase_contract.attribute_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.contract_name
     *
     * @return the value of purchase_contract.contract_name
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.contract_name
     *
     * @param contractName the value for purchase_contract.contract_name
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.first_audit
     *
     * @return the value of purchase_contract.first_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Integer getFirstAudit() {
        return firstAudit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.first_audit
     *
     * @param firstAudit the value for purchase_contract.first_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setFirstAudit(Integer firstAudit) {
        this.firstAudit = firstAudit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.second_audit
     *
     * @return the value of purchase_contract.second_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Integer getSecondAudit() {
        return secondAudit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.second_audit
     *
     * @param secondAudit the value for purchase_contract.second_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setSecondAudit(Integer secondAudit) {
        this.secondAudit = secondAudit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.three_audit
     *
     * @return the value of purchase_contract.three_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Integer getThreeAudit() {
        return threeAudit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.three_audit
     *
     * @param threeAudit the value for purchase_contract.three_audit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setThreeAudit(Integer threeAudit) {
        this.threeAudit = threeAudit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.first_remark
     *
     * @return the value of purchase_contract.first_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getFirstRemark() {
        return firstRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.first_remark
     *
     * @param firstRemark the value for purchase_contract.first_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setFirstRemark(String firstRemark) {
        this.firstRemark = firstRemark == null ? null : firstRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.second_remark
     *
     * @return the value of purchase_contract.second_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getSecondRemark() {
        return secondRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.second_remark
     *
     * @param secondRemark the value for purchase_contract.second_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setSecondRemark(String secondRemark) {
        this.secondRemark = secondRemark == null ? null : secondRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.three_remark
     *
     * @return the value of purchase_contract.three_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getThreeRemark() {
        return threeRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.three_remark
     *
     * @param threeRemark the value for purchase_contract.three_remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setThreeRemark(String threeRemark) {
        this.threeRemark = threeRemark == null ? null : threeRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.remark
     *
     * @return the value of purchase_contract.remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.remark
     *
     * @param remark the value for purchase_contract.remark
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.is_active
     *
     * @return the value of purchase_contract.is_active
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.is_active
     *
     * @param isActive the value for purchase_contract.is_active
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.time
     *
     * @return the value of purchase_contract.time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.time
     *
     * @param time the value for purchase_contract.time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.operator
     *
     * @return the value of purchase_contract.operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.operator
     *
     * @param operator the value for purchase_contract.operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.update_operator
     *
     * @return the value of purchase_contract.update_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.update_operator
     *
     * @param updateOperator the value for purchase_contract.update_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract.update_time
     *
     * @return the value of purchase_contract.update_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract.update_time
     *
     * @param updateTime the value for purchase_contract.update_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}