package com.xzx.xzxms.system.bean;

import java.util.Date;

public class SysAnnouncement {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.id
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.titile
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String titile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.start_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.end_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.sender
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String sender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.priority
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String priority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.msg_category
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String msgCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.msg_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String msgType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.send_status
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String sendStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.send_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private Date sendTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.cancel_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private Date cancelTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.del_flag
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String delFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.bus_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String busType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.bus_id
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String busId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.open_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String openType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.open_page
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String openPage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.create_by
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.create_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.update_by
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.update_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.id
     *
     * @return the value of sys_announcement.id
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.id
     *
     * @param id the value for sys_announcement.id
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.titile
     *
     * @return the value of sys_announcement.titile
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getTitile() {
        return titile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.titile
     *
     * @param titile the value for sys_announcement.titile
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setTitile(String titile) {
        this.titile = titile == null ? null : titile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.start_time
     *
     * @return the value of sys_announcement.start_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.start_time
     *
     * @param startTime the value for sys_announcement.start_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.end_time
     *
     * @return the value of sys_announcement.end_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.end_time
     *
     * @param endTime the value for sys_announcement.end_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.sender
     *
     * @return the value of sys_announcement.sender
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getSender() {
        return sender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.sender
     *
     * @param sender the value for sys_announcement.sender
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.priority
     *
     * @return the value of sys_announcement.priority
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.priority
     *
     * @param priority the value for sys_announcement.priority
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.msg_category
     *
     * @return the value of sys_announcement.msg_category
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getMsgCategory() {
        return msgCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.msg_category
     *
     * @param msgCategory the value for sys_announcement.msg_category
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setMsgCategory(String msgCategory) {
        this.msgCategory = msgCategory == null ? null : msgCategory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.msg_type
     *
     * @return the value of sys_announcement.msg_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.msg_type
     *
     * @param msgType the value for sys_announcement.msg_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.send_status
     *
     * @return the value of sys_announcement.send_status
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getSendStatus() {
        return sendStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.send_status
     *
     * @param sendStatus the value for sys_announcement.send_status
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus == null ? null : sendStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.send_time
     *
     * @return the value of sys_announcement.send_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.send_time
     *
     * @param sendTime the value for sys_announcement.send_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.cancel_time
     *
     * @return the value of sys_announcement.cancel_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.cancel_time
     *
     * @param cancelTime the value for sys_announcement.cancel_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.del_flag
     *
     * @return the value of sys_announcement.del_flag
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.del_flag
     *
     * @param delFlag the value for sys_announcement.del_flag
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.bus_type
     *
     * @return the value of sys_announcement.bus_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getBusType() {
        return busType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.bus_type
     *
     * @param busType the value for sys_announcement.bus_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setBusType(String busType) {
        this.busType = busType == null ? null : busType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.bus_id
     *
     * @return the value of sys_announcement.bus_id
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getBusId() {
        return busId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.bus_id
     *
     * @param busId the value for sys_announcement.bus_id
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setBusId(String busId) {
        this.busId = busId == null ? null : busId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.open_type
     *
     * @return the value of sys_announcement.open_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.open_type
     *
     * @param openType the value for sys_announcement.open_type
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setOpenType(String openType) {
        this.openType = openType == null ? null : openType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.open_page
     *
     * @return the value of sys_announcement.open_page
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getOpenPage() {
        return openPage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.open_page
     *
     * @param openPage the value for sys_announcement.open_page
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setOpenPage(String openPage) {
        this.openPage = openPage == null ? null : openPage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.create_by
     *
     * @return the value of sys_announcement.create_by
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.create_by
     *
     * @param createBy the value for sys_announcement.create_by
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.create_time
     *
     * @return the value of sys_announcement.create_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.create_time
     *
     * @param createTime the value for sys_announcement.create_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.update_by
     *
     * @return the value of sys_announcement.update_by
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.update_by
     *
     * @param updateBy the value for sys_announcement.update_by
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.update_time
     *
     * @return the value of sys_announcement.update_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.update_time
     *
     * @param updateTime the value for sys_announcement.update_time
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}