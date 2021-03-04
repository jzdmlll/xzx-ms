package com.xzx.xzxms.inquiry.vo;/**
 * @Author sunny
 * @Date 2021/3/4 15:09
 * @Version 1.0
 */

/**
 *@ClassName ContractAuditDealVO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class ContractAuditDealVO {

    private Long contractId;
    private String proName;
    private String contractNo;
    private String firstAudit;
    private String firstOperator;
    private String firstTime;
    private String secondAudit;
    private String secondOperator;
    private String secondTime;
    private String threeAudit;
    private String threeOperator;
    private String threeTime;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getFirstAudit() {
        return firstAudit;
    }

    public void setFirstAudit(String firstAudit) {
        this.firstAudit = firstAudit;
    }

    public String getFirstOperator() {
        return firstOperator;
    }

    public void setFirstOperator(String firstOperator) {
        this.firstOperator = firstOperator;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getSecondAudit() {
        return secondAudit;
    }

    public void setSecondAudit(String secondAudit) {
        this.secondAudit = secondAudit;
    }

    public String getSecondOperator() {
        return secondOperator;
    }

    public void setSecondOperator(String secondOperator) {
        this.secondOperator = secondOperator;
    }

    public String getSecondTime() {
        return secondTime;
    }

    public void setSecondTime(String secondTime) {
        this.secondTime = secondTime;
    }

    public String getThreeAudit() {
        return threeAudit;
    }

    public void setThreeAudit(String threeAudit) {
        this.threeAudit = threeAudit;
    }

    public String getThreeOperator() {
        return threeOperator;
    }

    public void setThreeOperator(String threeOperator) {
        this.threeOperator = threeOperator;
    }

    public String getThreeTime() {
        return threeTime;
    }

    public void setThreeTime(String threeTime) {
        this.threeTime = threeTime;
    }
}
