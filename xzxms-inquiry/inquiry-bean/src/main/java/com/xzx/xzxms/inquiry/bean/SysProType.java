package com.xzx.xzxms.inquiry.bean;

public class SysProType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.id
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.name
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.parent_id
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.is_active
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.is_useful
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.operator
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.time
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.update_operator
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private String updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_type.update_time
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    private Long updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.id
     *
     * @return the value of sys_pro_type.id
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.id
     *
     * @param id the value for sys_pro_type.id
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.name
     *
     * @return the value of sys_pro_type.name
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.name
     *
     * @param name the value for sys_pro_type.name
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.parent_id
     *
     * @return the value of sys_pro_type.parent_id
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.parent_id
     *
     * @param parentId the value for sys_pro_type.parent_id
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.is_active
     *
     * @return the value of sys_pro_type.is_active
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.is_active
     *
     * @param isActive the value for sys_pro_type.is_active
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.is_useful
     *
     * @return the value of sys_pro_type.is_useful
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.is_useful
     *
     * @param isUseful the value for sys_pro_type.is_useful
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.operator
     *
     * @return the value of sys_pro_type.operator
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.operator
     *
     * @param operator the value for sys_pro_type.operator
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.time
     *
     * @return the value of sys_pro_type.time
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.time
     *
     * @param time the value for sys_pro_type.time
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.update_operator
     *
     * @return the value of sys_pro_type.update_operator
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.update_operator
     *
     * @param updateOperator the value for sys_pro_type.update_operator
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_type.update_time
     *
     * @return the value of sys_pro_type.update_time
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_type.update_time
     *
     * @param updateTime the value for sys_pro_type.update_time
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}