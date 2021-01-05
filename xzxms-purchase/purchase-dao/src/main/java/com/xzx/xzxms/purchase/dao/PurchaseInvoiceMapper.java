package com.xzx.xzxms.purchase.dao;

import com.xzx.xzxms.purchase.bean.PurchaseInvoice;
import com.xzx.xzxms.purchase.bean.PurchaseInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseInvoiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    long countByExample(PurchaseInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int deleteByExample(PurchaseInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int insert(PurchaseInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int insertSelective(PurchaseInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    List<PurchaseInvoice> selectByExample(PurchaseInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    PurchaseInvoice selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int updateByExampleSelective(@Param("record") PurchaseInvoice record, @Param("example") PurchaseInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int updateByExample(@Param("record") PurchaseInvoice record, @Param("example") PurchaseInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int updateByPrimaryKeySelective(PurchaseInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_invoice
     *
     * @mbg.generated Tue Jan 05 17:50:26 CST 2021
     */
    int updateByPrimaryKey(PurchaseInvoice record);
}