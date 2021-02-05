package com.xzx.xzxms.system.bean;

public class SysLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.id
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.log_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Integer logType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.log_content
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String logContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.operate_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Integer operateType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.userid
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.username
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.ip
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.method
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String method;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.request_url
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String requestUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.request_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String requestType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.cost_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long costTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.create_by
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.create_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.update_by
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.update_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private Long updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.request_param
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    private String requestParam;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.id
     *
     * @return the value of sys_log.id
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.id
     *
     * @param id the value for sys_log.id
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.log_type
     *
     * @return the value of sys_log.log_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.log_type
     *
     * @param logType the value for sys_log.log_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.log_content
     *
     * @return the value of sys_log.log_content
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.log_content
     *
     * @param logContent the value for sys_log.log_content
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.operate_type
     *
     * @return the value of sys_log.operate_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Integer getOperateType() {
        return operateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.operate_type
     *
     * @param operateType the value for sys_log.operate_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.userid
     *
     * @return the value of sys_log.userid
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.userid
     *
     * @param userid the value for sys_log.userid
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.username
     *
     * @return the value of sys_log.username
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.username
     *
     * @param username the value for sys_log.username
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.ip
     *
     * @return the value of sys_log.ip
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.ip
     *
     * @param ip the value for sys_log.ip
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.method
     *
     * @return the value of sys_log.method
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.method
     *
     * @param method the value for sys_log.method
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.request_url
     *
     * @return the value of sys_log.request_url
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.request_url
     *
     * @param requestUrl the value for sys_log.request_url
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.request_type
     *
     * @return the value of sys_log.request_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.request_type
     *
     * @param requestType the value for sys_log.request_type
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.cost_time
     *
     * @return the value of sys_log.cost_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getCostTime() {
        return costTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.cost_time
     *
     * @param costTime the value for sys_log.cost_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.create_by
     *
     * @return the value of sys_log.create_by
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.create_by
     *
     * @param createBy the value for sys_log.create_by
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.create_time
     *
     * @return the value of sys_log.create_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.create_time
     *
     * @param createTime the value for sys_log.create_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.update_by
     *
     * @return the value of sys_log.update_by
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.update_by
     *
     * @param updateBy the value for sys_log.update_by
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.update_time
     *
     * @return the value of sys_log.update_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.update_time
     *
     * @param updateTime the value for sys_log.update_time
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.request_param
     *
     * @return the value of sys_log.request_param
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public String getRequestParam() {
        return requestParam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.request_param
     *
     * @param requestParam the value for sys_log.request_param
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam == null ? null : requestParam.trim();
    }
}