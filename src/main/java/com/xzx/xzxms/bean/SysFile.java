package com.xzx.xzxms.bean;

public class SysFile {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.name
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.url
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.type
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.other_id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Long otherId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.is_active
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.is_useful
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.operator
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file.time
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    private Long time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.id
     *
     * @return the value of sys_file.id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.id
     *
     * @param id the value for sys_file.id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.name
     *
     * @return the value of sys_file.name
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.name
     *
     * @param name the value for sys_file.name
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.url
     *
     * @return the value of sys_file.url
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.url
     *
     * @param url the value for sys_file.url
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.type
     *
     * @return the value of sys_file.type
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.type
     *
     * @param type the value for sys_file.type
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.other_id
     *
     * @return the value of sys_file.other_id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Long getOtherId() {
        return otherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.other_id
     *
     * @param otherId the value for sys_file.other_id
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.is_active
     *
     * @return the value of sys_file.is_active
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.is_active
     *
     * @param isActive the value for sys_file.is_active
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.is_useful
     *
     * @return the value of sys_file.is_useful
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.is_useful
     *
     * @param isUseful the value for sys_file.is_useful
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.operator
     *
     * @return the value of sys_file.operator
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.operator
     *
     * @param operator the value for sys_file.operator
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file.time
     *
     * @return the value of sys_file.time
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file.time
     *
     * @param time the value for sys_file.time
     *
     * @mbg.generated Wed Oct 14 17:16:21 CST 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }
}