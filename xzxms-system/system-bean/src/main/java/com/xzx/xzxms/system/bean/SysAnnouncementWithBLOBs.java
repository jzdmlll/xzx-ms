package com.xzx.xzxms.system.bean;

public class SysAnnouncementWithBLOBs extends SysAnnouncement {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.msg_content
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String msgContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.user_ids
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String userIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_announcement.msg_abstract
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    private String msgAbstract;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.msg_content
     *
     * @return the value of sys_announcement.msg_content
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.msg_content
     *
     * @param msgContent the value for sys_announcement.msg_content
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.user_ids
     *
     * @return the value of sys_announcement.user_ids
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getUserIds() {
        return userIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.user_ids
     *
     * @param userIds the value for sys_announcement.user_ids
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_announcement.msg_abstract
     *
     * @return the value of sys_announcement.msg_abstract
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public String getMsgAbstract() {
        return msgAbstract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_announcement.msg_abstract
     *
     * @param msgAbstract the value for sys_announcement.msg_abstract
     *
     * @mbg.generated Fri Jan 15 16:58:37 CST 2021
     */
    public void setMsgAbstract(String msgAbstract) {
        this.msgAbstract = msgAbstract == null ? null : msgAbstract.trim();
    }
}