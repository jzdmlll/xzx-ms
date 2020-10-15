package com.xzx.xzxms.bean;

public class SysProOrigin {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_origin.id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_origin.name
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_origin.code
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_origin.is_active
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_origin.is_useful
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_origin.operator
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_origin.time
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Long time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_origin.id
     *
     * @return the value of sys_pro_origin.id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_origin.id
     *
     * @param id the value for sys_pro_origin.id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_origin.name
     *
     * @return the value of sys_pro_origin.name
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_origin.name
     *
     * @param name the value for sys_pro_origin.name
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_origin.code
     *
     * @return the value of sys_pro_origin.code
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_origin.code
     *
     * @param code the value for sys_pro_origin.code
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_origin.is_active
     *
     * @return the value of sys_pro_origin.is_active
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_origin.is_active
     *
     * @param isActive the value for sys_pro_origin.is_active
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_origin.is_useful
     *
     * @return the value of sys_pro_origin.is_useful
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_origin.is_useful
     *
     * @param isUseful the value for sys_pro_origin.is_useful
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_origin.operator
     *
     * @return the value of sys_pro_origin.operator
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_origin.operator
     *
     * @param operator the value for sys_pro_origin.operator
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_origin.time
     *
     * @return the value of sys_pro_origin.time
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_origin.time
     *
     * @param time the value for sys_pro_origin.time
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }
}