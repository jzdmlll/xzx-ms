package com.xzx.xzxms.system.bean;

public class SysUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.username
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.avatar
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.is_active
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.is_useful
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.operator
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.update_operator
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.update_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.username
     *
     * @return the value of sys_user.username
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.username
     *
     * @param username the value for sys_user.username
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.avatar
     *
     * @return the value of sys_user.avatar
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.avatar
     *
     * @param avatar the value for sys_user.avatar
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.is_active
     *
     * @return the value of sys_user.is_active
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.is_active
     *
     * @param isActive the value for sys_user.is_active
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.is_useful
     *
     * @return the value of sys_user.is_useful
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.is_useful
     *
     * @param isUseful the value for sys_user.is_useful
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.operator
     *
     * @return the value of sys_user.operator
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.operator
     *
     * @param operator the value for sys_user.operator
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.time
     *
     * @return the value of sys_user.time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.time
     *
     * @param time the value for sys_user.time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.update_operator
     *
     * @return the value of sys_user.update_operator
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.update_operator
     *
     * @param updateOperator the value for sys_user.update_operator
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.update_time
     *
     * @return the value of sys_user.update_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.update_time
     *
     * @param updateTime the value for sys_user.update_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}