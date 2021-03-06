package com.xzx.xzxms.chapter.bean;

public class ChapterAudit {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.id
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.project_name
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String projectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.contract_name
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String contractName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.contract_no
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String contractNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.main_content
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String mainContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.price
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.file
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String file;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.first_party
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String firstParty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.second_party
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String secondParty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.type
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.sender
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String sender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.sender_time
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private Long senderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.auditor
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String auditor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.audit_time
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private Long auditTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.is_active
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private Integer isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.sender_remark
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String senderRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.audit_remark
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private String auditRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chapter_audit.audit_status
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    private Integer auditStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.id
     *
     * @return the value of chapter_audit.id
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.id
     *
     * @param id the value for chapter_audit.id
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.project_name
     *
     * @return the value of chapter_audit.project_name
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.project_name
     *
     * @param projectName the value for chapter_audit.project_name
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.contract_name
     *
     * @return the value of chapter_audit.contract_name
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.contract_name
     *
     * @param contractName the value for chapter_audit.contract_name
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.contract_no
     *
     * @return the value of chapter_audit.contract_no
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.contract_no
     *
     * @param contractNo the value for chapter_audit.contract_no
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.main_content
     *
     * @return the value of chapter_audit.main_content
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getMainContent() {
        return mainContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.main_content
     *
     * @param mainContent the value for chapter_audit.main_content
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setMainContent(String mainContent) {
        this.mainContent = mainContent == null ? null : mainContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.price
     *
     * @return the value of chapter_audit.price
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.price
     *
     * @param price the value for chapter_audit.price
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.file
     *
     * @return the value of chapter_audit.file
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.file
     *
     * @param file the value for chapter_audit.file
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.first_party
     *
     * @return the value of chapter_audit.first_party
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getFirstParty() {
        return firstParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.first_party
     *
     * @param firstParty the value for chapter_audit.first_party
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty == null ? null : firstParty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.second_party
     *
     * @return the value of chapter_audit.second_party
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getSecondParty() {
        return secondParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.second_party
     *
     * @param secondParty the value for chapter_audit.second_party
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty == null ? null : secondParty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.type
     *
     * @return the value of chapter_audit.type
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.type
     *
     * @param type the value for chapter_audit.type
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.sender
     *
     * @return the value of chapter_audit.sender
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getSender() {
        return sender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.sender
     *
     * @param sender the value for chapter_audit.sender
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.sender_time
     *
     * @return the value of chapter_audit.sender_time
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public Long getSenderTime() {
        return senderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.sender_time
     *
     * @param senderTime the value for chapter_audit.sender_time
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setSenderTime(Long senderTime) {
        this.senderTime = senderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.auditor
     *
     * @return the value of chapter_audit.auditor
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.auditor
     *
     * @param auditor the value for chapter_audit.auditor
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.audit_time
     *
     * @return the value of chapter_audit.audit_time
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public Long getAuditTime() {
        return auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.audit_time
     *
     * @param auditTime the value for chapter_audit.audit_time
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setAuditTime(Long auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.is_active
     *
     * @return the value of chapter_audit.is_active
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.is_active
     *
     * @param isActive the value for chapter_audit.is_active
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.sender_remark
     *
     * @return the value of chapter_audit.sender_remark
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getSenderRemark() {
        return senderRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.sender_remark
     *
     * @param senderRemark the value for chapter_audit.sender_remark
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setSenderRemark(String senderRemark) {
        this.senderRemark = senderRemark == null ? null : senderRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.audit_remark
     *
     * @return the value of chapter_audit.audit_remark
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.audit_remark
     *
     * @param auditRemark the value for chapter_audit.audit_remark
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chapter_audit.audit_status
     *
     * @return the value of chapter_audit.audit_status
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chapter_audit.audit_status
     *
     * @param auditStatus the value for chapter_audit.audit_status
     *
     * @mbg.generated Mon Jan 18 15:31:17 CST 2021
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public String toString() {
        return "ChapterAudit{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", contractName='" + contractName + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", mainContent='" + mainContent + '\'' +
                ", price=" + price +
                ", file='" + file + '\'' +
                ", firstParty='" + firstParty + '\'' +
                ", secondParty='" + secondParty + '\'' +
                ", type='" + type + '\'' +
                ", sender='" + sender + '\'' +
                ", senderTime=" + senderTime +
                ", auditor='" + auditor + '\'' +
                ", auditTime=" + auditTime +
                ", isActive=" + isActive +
                ", senderRemark='" + senderRemark + '\'' +
                ", auditRemark='" + auditRemark + '\'' +
                ", auditStatus=" + auditStatus +
                '}';
    }
}