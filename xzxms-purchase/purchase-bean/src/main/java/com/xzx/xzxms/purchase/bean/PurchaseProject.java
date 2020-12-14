package com.xzx.xzxms.purchase.bean;

public class PurchaseProject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.id
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.project_name
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    private String projectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.is_active
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.is_useful
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.operator
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_project.time
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    private Long time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.id
     *
     * @return the value of purchase_project.id
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_project.operator
     *
     * @param operator the value for purchase_project.operator
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_project.time
     *
     * @return the value of purchase_project.time
     *
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
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
     * @mbg.generated Mon Dec 14 08:55:02 GMT+08:00 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }
}