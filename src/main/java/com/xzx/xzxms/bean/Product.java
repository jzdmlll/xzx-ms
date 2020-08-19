package com.xzx.xzxms.bean;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.id
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.name
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.is_active
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.is_useful
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.time
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.operator
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.price
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.supplier_id
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    private Long supplierId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.id
     *
     * @return the value of product.id
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.id
     *
     * @param id the value for product.id
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.name
     *
     * @return the value of product.name
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.name
     *
     * @param name the value for product.name
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.is_active
     *
     * @return the value of product.is_active
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.is_active
     *
     * @param isActive the value for product.is_active
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.is_useful
     *
     * @return the value of product.is_useful
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.is_useful
     *
     * @param isUseful the value for product.is_useful
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.time
     *
     * @return the value of product.time
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.time
     *
     * @param time the value for product.time
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.operator
     *
     * @return the value of product.operator
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.operator
     *
     * @param operator the value for product.operator
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.price
     *
     * @return the value of product.price
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.price
     *
     * @param price the value for product.price
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.supplier_id
     *
     * @return the value of product.supplier_id
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.supplier_id
     *
     * @param supplierId the value for product.supplier_id
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}