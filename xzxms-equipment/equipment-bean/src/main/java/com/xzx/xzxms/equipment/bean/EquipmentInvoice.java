package com.xzx.xzxms.equipment.bean;

public class EquipmentInvoice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.id
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.contract_id
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private Long contractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.no
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private String no;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.image
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.is_active
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.operator
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.time
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.update_operator
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private String updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_invoice.update_time
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    private Long updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.id
     *
     * @return the value of equipment_invoice.id
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.id
     *
     * @param id the value for equipment_invoice.id
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.contract_id
     *
     * @return the value of equipment_invoice.contract_id
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.contract_id
     *
     * @param contractId the value for equipment_invoice.contract_id
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.no
     *
     * @return the value of equipment_invoice.no
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public String getNo() {
        return no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.no
     *
     * @param no the value for equipment_invoice.no
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.image
     *
     * @return the value of equipment_invoice.image
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.image
     *
     * @param image the value for equipment_invoice.image
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.is_active
     *
     * @return the value of equipment_invoice.is_active
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.is_active
     *
     * @param isActive the value for equipment_invoice.is_active
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.operator
     *
     * @return the value of equipment_invoice.operator
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.operator
     *
     * @param operator the value for equipment_invoice.operator
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.time
     *
     * @return the value of equipment_invoice.time
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.time
     *
     * @param time the value for equipment_invoice.time
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.update_operator
     *
     * @return the value of equipment_invoice.update_operator
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.update_operator
     *
     * @param updateOperator the value for equipment_invoice.update_operator
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_invoice.update_time
     *
     * @return the value of equipment_invoice.update_time
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_invoice.update_time
     *
     * @param updateTime the value for equipment_invoice.update_time
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}