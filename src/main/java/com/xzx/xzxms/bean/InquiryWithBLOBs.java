package com.xzx.xzxms.bean;

public class InquiryWithBLOBs extends Inquiry {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry.su_remark
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private String suRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry.su_require
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private String suRequire;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry.require
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    private String require;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry.su_remark
     *
     * @return the value of inquiry.su_remark
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public String getSuRemark() {
        return suRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry.su_remark
     *
     * @param suRemark the value for inquiry.su_remark
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setSuRemark(String suRemark) {
        this.suRemark = suRemark == null ? null : suRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry.su_require
     *
     * @return the value of inquiry.su_require
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public String getSuRequire() {
        return suRequire;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry.su_require
     *
     * @param suRequire the value for inquiry.su_require
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setSuRequire(String suRequire) {
        this.suRequire = suRequire == null ? null : suRequire.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry.require
     *
     * @return the value of inquiry.require
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public String getRequire() {
        return require;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry.require
     *
     * @param require the value for inquiry.require
     *
     * @mbg.generated Tue Sep 08 21:15:37 CST 2020
     */
    public void setRequire(String require) {
        this.require = require == null ? null : require.trim();
    }
}