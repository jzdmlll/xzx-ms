package com.xzx.xzxms.bean;

public class SysRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.id
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.name
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.is_active
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.is_useful
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.operator
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.time
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private Long time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.id
     *
     * @return the value of sys_role.id
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.id
     *
     * @param id the value for sys_role.id
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.name
     *
     * @return the value of sys_role.name
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.name
     *
     * @param name the value for sys_role.name
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.is_active
     *
     * @return the value of sys_role.is_active
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.is_active
     *
     * @param isActive the value for sys_role.is_active
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.is_useful
     *
     * @return the value of sys_role.is_useful
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.is_useful
     *
     * @param isUseful the value for sys_role.is_useful
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.operator
     *
     * @return the value of sys_role.operator
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.operator
     *
     * @param operator the value for sys_role.operator
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.time
     *
     * @return the value of sys_role.time
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.time
     *
     * @param time the value for sys_role.time
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }
}