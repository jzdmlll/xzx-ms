package com.xzx.xzxms.equipment.dao;

import com.xzx.xzxms.equipment.bean.equipmentOrder;
import com.xzx.xzxms.equipment.bean.equipmentOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface equipmentOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    long countByExample(equipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int deleteByExample(equipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int insert(equipmentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int insertSelective(equipmentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    List<equipmentOrder> selectByExample(equipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    equipmentOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByExampleSelective(@Param("record") equipmentOrder record, @Param("example") equipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByExample(@Param("record") equipmentOrder record, @Param("example") equipmentOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByPrimaryKeySelective(equipmentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_order
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByPrimaryKey(equipmentOrder record);
}