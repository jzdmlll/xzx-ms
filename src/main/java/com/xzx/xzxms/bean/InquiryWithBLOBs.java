package com.xzx.xzxms.bean;

public class InquiryWithBLOBs extends Inquiry {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry.pro_param
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private String proParam;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry.remark
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry.pro_param
     *
     * @return the value of inquiry.pro_param
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public String getProParam() {
        return proParam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry.pro_param
     *
     * @param proParam the value for inquiry.pro_param
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setProParam(String proParam) {
        this.proParam = proParam == null ? null : proParam.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry.remark
     *
     * @return the value of inquiry.remark
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry.remark
     *
     * @param remark the value for inquiry.remark
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}