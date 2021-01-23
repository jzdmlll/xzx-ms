package com.xzx.xzxms.equipment.dao;

import com.xzx.xzxms.equipment.bean.equipmentOutStorage;
import com.xzx.xzxms.equipment.bean.equipmentOutStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface equipmentOutStorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    long countByExample(equipmentOutStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int deleteByExample(equipmentOutStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int insert(equipmentOutStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int insertSelective(equipmentOutStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    List<equipmentOutStorage> selectByExample(equipmentOutStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    equipmentOutStorage selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByExampleSelective(@Param("record") equipmentOutStorage record, @Param("example") equipmentOutStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByExample(@Param("record") equipmentOutStorage record, @Param("example") equipmentOutStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByPrimaryKeySelective(equipmentOutStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment_out_storage
     *
     * @mbg.generated Sat Jan 23 12:46:02 CST 2021
     */
    int updateByPrimaryKey(equipmentOutStorage record);
}