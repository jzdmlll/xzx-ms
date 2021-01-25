package com.xzx.xzxms.equipment.bean;

public class EquipmentContractOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.project_id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.contract_id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long contractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.pay_type
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private String payType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.need_pay
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Double needPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.unit_money
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private String unitMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.currency
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private String currency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.scheduler_pay_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long schedulerPayTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.scheduler_delivery_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long schedulerDeliveryTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.already_payment
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Double alreadyPayment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.performance_bond
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Double performanceBond;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.performance_bond_status
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer performanceBondStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.performance_bond_pay_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long performanceBondPayTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.performance_bond_return_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long performanceBondReturnTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.supplier_invoice
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer supplierInvoice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.payment_notice
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer paymentNotice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.actual_payment
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer actualPayment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.order_status
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.remark
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.operator
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.update_operator
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.update_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Long updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_contract_order.is_active
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    private Integer isActive;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.id
     *
     * @return the value of equipment_contract_order.id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.id
     *
     * @param id the value for equipment_contract_order.id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.project_id
     *
     * @return the value of equipment_contract_order.project_id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.project_id
     *
     * @param projectId the value for equipment_contract_order.project_id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.contract_id
     *
     * @return the value of equipment_contract_order.contract_id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.contract_id
     *
     * @param contractId the value for equipment_contract_order.contract_id
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.pay_type
     *
     * @return the value of equipment_contract_order.pay_type
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public String getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.pay_type
     *
     * @param payType the value for equipment_contract_order.pay_type
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.need_pay
     *
     * @return the value of equipment_contract_order.need_pay
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Double getNeedPay() {
        return needPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.need_pay
     *
     * @param needPay the value for equipment_contract_order.need_pay
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setNeedPay(Double needPay) {
        this.needPay = needPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.unit_money
     *
     * @return the value of equipment_contract_order.unit_money
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public String getUnitMoney() {
        return unitMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.unit_money
     *
     * @param unitMoney the value for equipment_contract_order.unit_money
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setUnitMoney(String unitMoney) {
        this.unitMoney = unitMoney == null ? null : unitMoney.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.currency
     *
     * @return the value of equipment_contract_order.currency
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.currency
     *
     * @param currency the value for equipment_contract_order.currency
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.scheduler_pay_time
     *
     * @return the value of equipment_contract_order.scheduler_pay_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getSchedulerPayTime() {
        return schedulerPayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.scheduler_pay_time
     *
     * @param schedulerPayTime the value for equipment_contract_order.scheduler_pay_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setSchedulerPayTime(Long schedulerPayTime) {
        this.schedulerPayTime = schedulerPayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.scheduler_delivery_time
     *
     * @return the value of equipment_contract_order.scheduler_delivery_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getSchedulerDeliveryTime() {
        return schedulerDeliveryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.scheduler_delivery_time
     *
     * @param schedulerDeliveryTime the value for equipment_contract_order.scheduler_delivery_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setSchedulerDeliveryTime(Long schedulerDeliveryTime) {
        this.schedulerDeliveryTime = schedulerDeliveryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.already_payment
     *
     * @return the value of equipment_contract_order.already_payment
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Double getAlreadyPayment() {
        return alreadyPayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.already_payment
     *
     * @param alreadyPayment the value for equipment_contract_order.already_payment
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setAlreadyPayment(Double alreadyPayment) {
        this.alreadyPayment = alreadyPayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.performance_bond
     *
     * @return the value of equipment_contract_order.performance_bond
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Double getPerformanceBond() {
        return performanceBond;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.performance_bond
     *
     * @param performanceBond the value for equipment_contract_order.performance_bond
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setPerformanceBond(Double performanceBond) {
        this.performanceBond = performanceBond;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.performance_bond_status
     *
     * @return the value of equipment_contract_order.performance_bond_status
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getPerformanceBondStatus() {
        return performanceBondStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.performance_bond_status
     *
     * @param performanceBondStatus the value for equipment_contract_order.performance_bond_status
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setPerformanceBondStatus(Integer performanceBondStatus) {
        this.performanceBondStatus = performanceBondStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.performance_bond_pay_time
     *
     * @return the value of equipment_contract_order.performance_bond_pay_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getPerformanceBondPayTime() {
        return performanceBondPayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.performance_bond_pay_time
     *
     * @param performanceBondPayTime the value for equipment_contract_order.performance_bond_pay_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setPerformanceBondPayTime(Long performanceBondPayTime) {
        this.performanceBondPayTime = performanceBondPayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.performance_bond_return_time
     *
     * @return the value of equipment_contract_order.performance_bond_return_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getPerformanceBondReturnTime() {
        return performanceBondReturnTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.performance_bond_return_time
     *
     * @param performanceBondReturnTime the value for equipment_contract_order.performance_bond_return_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setPerformanceBondReturnTime(Long performanceBondReturnTime) {
        this.performanceBondReturnTime = performanceBondReturnTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.supplier_invoice
     *
     * @return the value of equipment_contract_order.supplier_invoice
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getSupplierInvoice() {
        return supplierInvoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.supplier_invoice
     *
     * @param supplierInvoice the value for equipment_contract_order.supplier_invoice
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setSupplierInvoice(Integer supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.payment_notice
     *
     * @return the value of equipment_contract_order.payment_notice
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getPaymentNotice() {
        return paymentNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.payment_notice
     *
     * @param paymentNotice the value for equipment_contract_order.payment_notice
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setPaymentNotice(Integer paymentNotice) {
        this.paymentNotice = paymentNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.actual_payment
     *
     * @return the value of equipment_contract_order.actual_payment
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getActualPayment() {
        return actualPayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.actual_payment
     *
     * @param actualPayment the value for equipment_contract_order.actual_payment
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setActualPayment(Integer actualPayment) {
        this.actualPayment = actualPayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.order_status
     *
     * @return the value of equipment_contract_order.order_status
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.order_status
     *
     * @param orderStatus the value for equipment_contract_order.order_status
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.remark
     *
     * @return the value of equipment_contract_order.remark
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.remark
     *
     * @param remark the value for equipment_contract_order.remark
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.operator
     *
     * @return the value of equipment_contract_order.operator
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.operator
     *
     * @param operator the value for equipment_contract_order.operator
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.time
     *
     * @return the value of equipment_contract_order.time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.time
     *
     * @param time the value for equipment_contract_order.time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.update_operator
     *
     * @return the value of equipment_contract_order.update_operator
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.update_operator
     *
     * @param updateOperator the value for equipment_contract_order.update_operator
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setUpdateOperator(Integer updateOperator) {
        this.updateOperator = updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.update_time
     *
     * @return the value of equipment_contract_order.update_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.update_time
     *
     * @param updateTime the value for equipment_contract_order.update_time
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_contract_order.is_active
     *
     * @return the value of equipment_contract_order.is_active
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_contract_order.is_active
     *
     * @param isActive the value for equipment_contract_order.is_active
     *
     * @mbg.generated Mon Jan 25 11:52:10 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}