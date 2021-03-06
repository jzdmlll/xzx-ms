package com.xzx.xzxms.purchase.bean;

public class PurchaseContractAccount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.contract_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long contractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.form_of_payment
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String formOfPayment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.amount_of_advance_payment
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Double amountOfAdvancePayment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.advance_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long advanceTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.is_advance
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Integer isAdvance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.amount_of_deposit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Double amountOfDeposit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.deposit_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long depositTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.is_deposit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Integer isDeposit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.accounts_payable_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long accountsPayableTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.accounts_payable
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Double accountsPayable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.add_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long addOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.add_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.update_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Long updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.update_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private String updateOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase_contract_account.is_active
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    private Integer isActive;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.id
     *
     * @return the value of purchase_contract_account.id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.id
     *
     * @param id the value for purchase_contract_account.id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.contract_id
     *
     * @return the value of purchase_contract_account.contract_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.contract_id
     *
     * @param contractId the value for purchase_contract_account.contract_id
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.form_of_payment
     *
     * @return the value of purchase_contract_account.form_of_payment
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getFormOfPayment() {
        return formOfPayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.form_of_payment
     *
     * @param formOfPayment the value for purchase_contract_account.form_of_payment
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setFormOfPayment(String formOfPayment) {
        this.formOfPayment = formOfPayment == null ? null : formOfPayment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.amount_of_advance_payment
     *
     * @return the value of purchase_contract_account.amount_of_advance_payment
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Double getAmountOfAdvancePayment() {
        return amountOfAdvancePayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.amount_of_advance_payment
     *
     * @param amountOfAdvancePayment the value for purchase_contract_account.amount_of_advance_payment
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAmountOfAdvancePayment(Double amountOfAdvancePayment) {
        this.amountOfAdvancePayment = amountOfAdvancePayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.advance_time
     *
     * @return the value of purchase_contract_account.advance_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getAdvanceTime() {
        return advanceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.advance_time
     *
     * @param advanceTime the value for purchase_contract_account.advance_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAdvanceTime(Long advanceTime) {
        this.advanceTime = advanceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.is_advance
     *
     * @return the value of purchase_contract_account.is_advance
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Integer getIsAdvance() {
        return isAdvance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.is_advance
     *
     * @param isAdvance the value for purchase_contract_account.is_advance
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setIsAdvance(Integer isAdvance) {
        this.isAdvance = isAdvance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.amount_of_deposit
     *
     * @return the value of purchase_contract_account.amount_of_deposit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Double getAmountOfDeposit() {
        return amountOfDeposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.amount_of_deposit
     *
     * @param amountOfDeposit the value for purchase_contract_account.amount_of_deposit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAmountOfDeposit(Double amountOfDeposit) {
        this.amountOfDeposit = amountOfDeposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.deposit_time
     *
     * @return the value of purchase_contract_account.deposit_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getDepositTime() {
        return depositTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.deposit_time
     *
     * @param depositTime the value for purchase_contract_account.deposit_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setDepositTime(Long depositTime) {
        this.depositTime = depositTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.is_deposit
     *
     * @return the value of purchase_contract_account.is_deposit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Integer getIsDeposit() {
        return isDeposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.is_deposit
     *
     * @param isDeposit the value for purchase_contract_account.is_deposit
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setIsDeposit(Integer isDeposit) {
        this.isDeposit = isDeposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.accounts_payable_time
     *
     * @return the value of purchase_contract_account.accounts_payable_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getAccountsPayableTime() {
        return accountsPayableTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.accounts_payable_time
     *
     * @param accountsPayableTime the value for purchase_contract_account.accounts_payable_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAccountsPayableTime(Long accountsPayableTime) {
        this.accountsPayableTime = accountsPayableTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.accounts_payable
     *
     * @return the value of purchase_contract_account.accounts_payable
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Double getAccountsPayable() {
        return accountsPayable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.accounts_payable
     *
     * @param accountsPayable the value for purchase_contract_account.accounts_payable
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAccountsPayable(Double accountsPayable) {
        this.accountsPayable = accountsPayable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.add_operator
     *
     * @return the value of purchase_contract_account.add_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getAddOperator() {
        return addOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.add_operator
     *
     * @param addOperator the value for purchase_contract_account.add_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAddOperator(Long addOperator) {
        this.addOperator = addOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.add_time
     *
     * @return the value of purchase_contract_account.add_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.add_time
     *
     * @param addTime the value for purchase_contract_account.add_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.update_time
     *
     * @return the value of purchase_contract_account.update_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.update_time
     *
     * @param updateTime the value for purchase_contract_account.update_time
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.update_operator
     *
     * @return the value of purchase_contract_account.update_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.update_operator
     *
     * @param updateOperator the value for purchase_contract_account.update_operator
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase_contract_account.is_active
     *
     * @return the value of purchase_contract_account.is_active
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase_contract_account.is_active
     *
     * @param isActive the value for purchase_contract_account.is_active
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}