package com.xzx.xzxms.bean;

public class SysQualification {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_qualification.id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_qualification.name
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_qualification.isActive
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Integer isactive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_qualification.useful
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Integer useful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_qualification.time
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_qualification.operator
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Long operator;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_qualification.id
     *
     * @return the value of xzx_sys_qualification.id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_qualification.id
     *
     * @param id the value for xzx_sys_qualification.id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_qualification.name
     *
     * @return the value of xzx_sys_qualification.name
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_qualification.name
     *
     * @param name the value for xzx_sys_qualification.name
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_qualification.isActive
     *
     * @return the value of xzx_sys_qualification.isActive
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Integer getIsactive() {
        return isactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_qualification.isActive
     *
     * @param isactive the value for xzx_sys_qualification.isActive
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_qualification.useful
     *
     * @return the value of xzx_sys_qualification.useful
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Integer getUseful() {
        return useful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_qualification.useful
     *
     * @param useful the value for xzx_sys_qualification.useful
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setUseful(Integer useful) {
        this.useful = useful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_qualification.time
     *
     * @return the value of xzx_sys_qualification.time
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_qualification.time
     *
     * @param time the value for xzx_sys_qualification.time
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_qualification.operator
     *
     * @return the value of xzx_sys_qualification.operator
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_qualification.operator
     *
     * @param operator the value for xzx_sys_qualification.operator
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }
}