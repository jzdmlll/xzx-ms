package com.xzx.xzxms.bean;

public class SysLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_log.id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_log.action_time
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Long actionTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_log.user_id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xzx_sys_log.content
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_log.id
     *
     * @return the value of xzx_sys_log.id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_log.id
     *
     * @param id the value for xzx_sys_log.id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_log.action_time
     *
     * @return the value of xzx_sys_log.action_time
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Long getActionTime() {
        return actionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_log.action_time
     *
     * @param actionTime the value for xzx_sys_log.action_time
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setActionTime(Long actionTime) {
        this.actionTime = actionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_log.user_id
     *
     * @return the value of xzx_sys_log.user_id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_log.user_id
     *
     * @param userId the value for xzx_sys_log.user_id
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xzx_sys_log.content
     *
     * @return the value of xzx_sys_log.content
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xzx_sys_log.content
     *
     * @param content the value for xzx_sys_log.content
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}