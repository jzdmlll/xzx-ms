package com.xzx.xzxms.purchase.bean;

public class PurchaseProject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.id
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.project_name
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private String projectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.is_active
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.is_useful
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.operator
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.time
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.inquiry_pro_id
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private Long inquiryProId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.purchase_pro_no
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private String purchaseProNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.remark
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.update_operator
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private String updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project. update_time
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    private Long updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.id
     *
     * @return the value of purchase_project.id
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.id
     *
     * @param id the value for purchase_project.id
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.project_name
     *
     * @return the value of purchase_project.project_name
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.project_name
     *
     * @param projectName the value for purchase_project.project_name
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.is_active
     *
     * @return the value of purchase_project.is_active
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.is_active
     *
     * @param isActive the value for purchase_project.is_active
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.is_useful
     *
     * @return the value of purchase_project.is_useful
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.is_useful
     *
     * @param isUseful the value for purchase_project.is_useful
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.operator
     *
     * @return the value of purchase_project.operator
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.operator
     *
     * @param operator the value for purchase_project.operator
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.time
     *
     * @return the value of purchase_project.time
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.time
     *
     * @param time the value for purchase_project.time
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.inquiry_pro_id
     *
     * @return the value of purchase_project.inquiry_pro_id
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public Long getInquiryProId() {
        return inquiryProId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.inquiry_pro_id
     *
     * @param inquiryProId the value for purchase_project.inquiry_pro_id
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setInquiryProId(Long inquiryProId) {
        this.inquiryProId = inquiryProId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.purchase_pro_no
     *
     * @return the value of purchase_project.purchase_pro_no
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public String getPurchaseProNo() {
        return purchaseProNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.purchase_pro_no
     *
     * @param purchaseProNo the value for purchase_project.purchase_pro_no
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setPurchaseProNo(String purchaseProNo) {
        this.purchaseProNo = purchaseProNo == null ? null : purchaseProNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.remark
     *
     * @return the value of purchase_project.remark
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.remark
     *
     * @param remark the value for purchase_project.remark
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.update_operator
     *
     * @return the value of purchase_project.update_operator
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.update_operator
     *
     * @param updateOperator the value for purchase_project.update_operator
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project. update_time
     *
     * @return the value of purchase_project. update_time
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project. update_time
     *
     * @param updateTime the value for purchase_project. update_time
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}