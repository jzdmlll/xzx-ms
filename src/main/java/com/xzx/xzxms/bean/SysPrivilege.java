package com.xzx.xzxms.bean;

public class SysPrivilege {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.id
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.name
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.type
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.parent_id
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.icon
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.route
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private String route;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.remark
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.is_active
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.is_useful
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.operator
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.time
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    private Long time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.id
     *
     * @return the value of sys_privilege.id
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.id
     *
     * @param id the value for sys_privilege.id
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.name
     *
     * @return the value of sys_privilege.name
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.name
     *
     * @param name the value for sys_privilege.name
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.type
     *
     * @return the value of sys_privilege.type
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.type
     *
     * @param type the value for sys_privilege.type
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.parent_id
     *
     * @return the value of sys_privilege.parent_id
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.parent_id
     *
     * @param parentId the value for sys_privilege.parent_id
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.icon
     *
     * @return the value of sys_privilege.icon
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.icon
     *
     * @param icon the value for sys_privilege.icon
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.route
     *
     * @return the value of sys_privilege.route
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public String getRoute() {
        return route;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.route
     *
     * @param route the value for sys_privilege.route
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.remark
     *
     * @return the value of sys_privilege.remark
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.remark
     *
     * @param remark the value for sys_privilege.remark
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.is_active
     *
     * @return the value of sys_privilege.is_active
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.is_active
     *
     * @param isActive the value for sys_privilege.is_active
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.is_useful
     *
     * @return the value of sys_privilege.is_useful
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.is_useful
     *
     * @param isUseful the value for sys_privilege.is_useful
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.operator
     *
     * @return the value of sys_privilege.operator
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.operator
     *
     * @param operator the value for sys_privilege.operator
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.time
     *
     * @return the value of sys_privilege.time
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.time
     *
     * @param time the value for sys_privilege.time
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }
}