package com.xzx.xzxms.inquiry.bean;

public class InquiryTemplateWithBLOBs extends InquiryTemplate {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry_template.purchase_keys
     *
     * @mbg.generated Mon Feb 01 16:40:53 CST 2021
     */
    private String purchaseKeys;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry_template.json_keys
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    private String jsonKeys;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquiry_template.table_column
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    private String tableColumn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry_template.purchase_keys
     *
     * @return the value of inquiry_template.purchase_keys
     *
     * @mbg.generated Mon Feb 01 16:40:53 CST 2021
     */
    public String getPurchaseKeys() {
        return purchaseKeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry_template.purchase_keys
     *
     * @param purchaseKeys the value for inquiry_template.purchase_keys
     *
     * @mbg.generated Mon Feb 01 16:40:53 CST 2021
     */
    public void setPurchaseKeys(String purchaseKeys) {
        this.purchaseKeys = purchaseKeys == null ? null : purchaseKeys.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry_template.json_keys
     *
     * @return the value of inquiry_template.json_keys
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    public String getJsonKeys() {
        return jsonKeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry_template.json_keys
     *
     * @param jsonKeys the value for inquiry_template.json_keys
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    public void setJsonKeys(String jsonKeys) {
        this.jsonKeys = jsonKeys == null ? null : jsonKeys.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquiry_template.table_column
     *
     * @return the value of inquiry_template.table_column
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    public String getTableColumn() {
        return tableColumn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquiry_template.table_column
     *
     * @param tableColumn the value for inquiry_template.table_column
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    public void setTableColumn(String tableColumn) {
        this.tableColumn = tableColumn == null ? null : tableColumn.trim();
    }
}