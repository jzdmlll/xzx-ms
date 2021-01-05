package com.xzx.xzxms.purchase.bean;

public class PurchaseSupply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.supplier_id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Long supplierId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.supplier
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String supplier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.item_id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Long itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.model
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String model;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.brand
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String brand;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.price
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.delivery
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String delivery;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.remark
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.number
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Double number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.total_price
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Double totalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.warranty
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String warranty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.arrival_status
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Integer arrivalStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.is_active
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.is_useful
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Integer isUseful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.operator
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.time
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.image
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_supply.params
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    private String params;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.id
     *
     * @return the value of purchase_supply.id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.id
     *
     * @param id the value for purchase_supply.id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.supplier_id
     *
     * @return the value of purchase_supply.supplier_id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.supplier_id
     *
     * @param supplierId the value for purchase_supply.supplier_id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.supplier
     *
     * @return the value of purchase_supply.supplier
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.supplier
     *
     * @param supplier the value for purchase_supply.supplier
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.item_id
     *
     * @return the value of purchase_supply.item_id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.item_id
     *
     * @param itemId the value for purchase_supply.item_id
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.model
     *
     * @return the value of purchase_supply.model
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.model
     *
     * @param model the value for purchase_supply.model
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.brand
     *
     * @return the value of purchase_supply.brand
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.brand
     *
     * @param brand the value for purchase_supply.brand
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.price
     *
     * @return the value of purchase_supply.price
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.price
     *
     * @param price the value for purchase_supply.price
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.delivery
     *
     * @return the value of purchase_supply.delivery
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getDelivery() {
        return delivery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.delivery
     *
     * @param delivery the value for purchase_supply.delivery
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setDelivery(String delivery) {
        this.delivery = delivery == null ? null : delivery.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.remark
     *
     * @return the value of purchase_supply.remark
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.remark
     *
     * @param remark the value for purchase_supply.remark
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.number
     *
     * @return the value of purchase_supply.number
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Double getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.number
     *
     * @param number the value for purchase_supply.number
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setNumber(Double number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.total_price
     *
     * @return the value of purchase_supply.total_price
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.total_price
     *
     * @param totalPrice the value for purchase_supply.total_price
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.warranty
     *
     * @return the value of purchase_supply.warranty
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getWarranty() {
        return warranty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.warranty
     *
     * @param warranty the value for purchase_supply.warranty
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setWarranty(String warranty) {
        this.warranty = warranty == null ? null : warranty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.arrival_status
     *
     * @return the value of purchase_supply.arrival_status
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Integer getArrivalStatus() {
        return arrivalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.arrival_status
     *
     * @param arrivalStatus the value for purchase_supply.arrival_status
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setArrivalStatus(Integer arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.is_active
     *
     * @return the value of purchase_supply.is_active
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.is_active
     *
     * @param isActive the value for purchase_supply.is_active
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.is_useful
     *
     * @return the value of purchase_supply.is_useful
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Integer getIsUseful() {
        return isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.is_useful
     *
     * @param isUseful the value for purchase_supply.is_useful
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.operator
     *
     * @return the value of purchase_supply.operator
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.operator
     *
     * @param operator the value for purchase_supply.operator
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.time
     *
     * @return the value of purchase_supply.time
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.time
     *
     * @param time the value for purchase_supply.time
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.image
     *
     * @return the value of purchase_supply.image
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.image
     *
     * @param image the value for purchase_supply.image
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_supply.params
     *
     * @return the value of purchase_supply.params
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_supply.params
     *
     * @param params the value for purchase_supply.params
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}