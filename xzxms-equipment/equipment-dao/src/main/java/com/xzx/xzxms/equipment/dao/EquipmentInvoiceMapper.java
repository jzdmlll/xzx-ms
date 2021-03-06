package com.xzx.xzxms.equipment.dao;

import com.xzx.xzxms.equipment.bean.EquipmentInvoice;
import com.xzx.xzxms.equipment.bean.EquipmentInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentInvoiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    long countByExample(EquipmentInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int deleteByExample(EquipmentInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int insert(EquipmentInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int insertSelective(EquipmentInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    List<EquipmentInvoice> selectByExample(EquipmentInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    EquipmentInvoice selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int updateByExampleSelective(@Param("record") EquipmentInvoice record, @Param("example") EquipmentInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int updateByExample(@Param("record") EquipmentInvoice record, @Param("example") EquipmentInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int updateByPrimaryKeySelective(EquipmentInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_invoice
     *
     * @mbg.generated Mon Feb 01 16:45:58 CST 2021
     */
    int updateByPrimaryKey(EquipmentInvoice record);
}