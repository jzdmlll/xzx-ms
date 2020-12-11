package com.xzx.xzxms.bean;

public class Purchase {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.id
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.name
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.model
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private String model;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.unit
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private String unit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.number
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Integer number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.price
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.total_price
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Double totalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.contract_id
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Long contractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.is_active
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.time
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.operator
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.params
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    private String params;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.id
     *
     * @return the value of purchase.id
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.id
     *
     * @param id the value for purchase.id
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.name
     *
     * @return the value of purchase.name
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.name
     *
     * @param name the value for purchase.name
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.model
     *
     * @return the value of purchase.model
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.model
     *
     * @param model the value for purchase.model
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.unit
     *
     * @return the value of purchase.unit
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.unit
     *
     * @param unit the value for purchase.unit
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.number
     *
     * @return the value of purchase.number
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.number
     *
     * @param number the value for purchase.number
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.price
     *
     * @return the value of purchase.price
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.price
     *
     * @param price the value for purchase.price
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.total_price
     *
     * @return the value of purchase.total_price
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.total_price
     *
     * @param totalPrice the value for purchase.total_price
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.contract_id
     *
     * @return the value of purchase.contract_id
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.contract_id
     *
     * @param contractId the value for purchase.contract_id
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.is_active
     *
     * @return the value of purchase.is_active
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.is_active
     *
     * @param isActive the value for purchase.is_active
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.time
     *
     * @return the value of purchase.time
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.time
     *
     * @param time the value for purchase.time
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.operator
     *
     * @return the value of purchase.operator
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.operator
     *
     * @param operator the value for purchase.operator
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.params
     *
     * @return the value of purchase.params
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.params
     *
     * @param params the value for purchase.params
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}