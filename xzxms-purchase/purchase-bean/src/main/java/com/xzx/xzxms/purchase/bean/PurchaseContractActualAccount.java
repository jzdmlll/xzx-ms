package com.xzx.xzxms.purchase.bean;

public class PurchaseContractActualAccount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_actual_account.id
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_actual_account.account_id
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    private Long accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_actual_account.money
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    private Double money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_actual_account.payment_name
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    private String paymentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_actual_account.operator
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    private Long operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_actual_account.time
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    private Long time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_actual_account.id
     *
     * @return the value of purchase_contract_actual_account.id
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_actual_account.id
     *
     * @param id the value for purchase_contract_actual_account.id
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_actual_account.account_id
     *
     * @return the value of purchase_contract_actual_account.account_id
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_actual_account.account_id
     *
     * @param accountId the value for purchase_contract_actual_account.account_id
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_actual_account.money
     *
     * @return the value of purchase_contract_actual_account.money
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public Double getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_actual_account.money
     *
     * @param money the value for purchase_contract_actual_account.money
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_actual_account.payment_name
     *
     * @return the value of purchase_contract_actual_account.payment_name
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public String getPaymentName() {
        return paymentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_actual_account.payment_name
     *
     * @param paymentName the value for purchase_contract_actual_account.payment_name
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_actual_account.operator
     *
     * @return the value of purchase_contract_actual_account.operator
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_actual_account.operator
     *
     * @param operator the value for purchase_contract_actual_account.operator
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_actual_account.time
     *
     * @return the value of purchase_contract_actual_account.time
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_actual_account.time
     *
     * @param time the value for purchase_contract_actual_account.time
     *
     * @mbg.generated Tue Dec 29 15:36:37 CST 2020
     */
    public void setTime(Long time) {
        this.time = time;
    }
}