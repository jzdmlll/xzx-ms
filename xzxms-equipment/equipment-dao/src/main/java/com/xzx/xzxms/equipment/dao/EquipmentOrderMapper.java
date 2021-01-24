package com.xzx.xzxms.equipment.dao;

import com.xzx.xzxms.equipment.bean.EquipmentOrder;
import com.xzx.xzxms.equipment.bean.EquipmentOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    long countByExample(EquipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int deleteByExample(EquipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int insert(EquipmentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int insertSelective(EquipmentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    List<EquipmentOrder> selectByExample(EquipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    EquipmentOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int updateByExampleSelective(@Param("record") EquipmentOrder record, @Param("example") EquipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int updateByExample(@Param("record") EquipmentOrder record, @Param("example") EquipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int updateByPrimaryKeySelective(EquipmentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sun Jan 24 11:16:56 CST 2021
     */
    int updateByPrimaryKey(EquipmentOrder record);
}