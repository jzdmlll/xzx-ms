package com.xzx.xzxms.inquiry.bean;

public class SysProDetailWithBLOBs extends SysProDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_detail.remark
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_pro_detail.content
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_detail.remark
     *
     * @return the value of sys_pro_detail.remark
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_detail.remark
     *
     * @param remark the value for sys_pro_detail.remark
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_pro_detail.content
     *
     * @return the value of sys_pro_detail.content
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_pro_detail.content
     *
     * @param content the value for sys_pro_detail.content
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}