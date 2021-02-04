package com.xzx.xzxms.system.bean;

public class SysFilePrivilege {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.id
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.type
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.user_id
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.is_active
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.is_useful
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.operator
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.time
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.update_operator
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private String updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_privilege.update_time
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    private Long updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.id
     *
     * @return the value of sys_file_privilege.id
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.id
     *
     * @param id the value for sys_file_privilege.id
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.type
     *
     * @return the value of sys_file_privilege.type
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.type
     *
     * @param type the value for sys_file_privilege.type
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.user_id
     *
     * @return the value of sys_file_privilege.user_id
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.user_id
     *
     * @param userId the value for sys_file_privilege.user_id
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.is_active
     *
     * @return the value of sys_file_privilege.is_active
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.is_active
     *
     * @param isActive the value for sys_file_privilege.is_active
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.is_useful
     *
     * @return the value of sys_file_privilege.is_useful
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.is_useful
     *
     * @param isUseful the value for sys_file_privilege.is_useful
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.operator
     *
     * @return the value of sys_file_privilege.operator
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.operator
     *
     * @param operator the value for sys_file_privilege.operator
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.time
     *
     * @return the value of sys_file_privilege.time
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.time
     *
     * @param time the value for sys_file_privilege.time
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.update_operator
     *
     * @return the value of sys_file_privilege.update_operator
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.update_operator
     *
     * @param updateOperator the value for sys_file_privilege.update_operator
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_privilege.update_time
     *
     * @return the value of sys_file_privilege.update_time
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_privilege.update_time
     *
     * @param updateTime the value for sys_file_privilege.update_time
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}