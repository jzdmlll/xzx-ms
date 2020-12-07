package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.SysDeviceType;
import com.xzx.xzxms.bean.SysDeviceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDeviceTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    long countByExample(SysDeviceTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int deleteByExample(SysDeviceTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int insert(SysDeviceType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int insertSelective(SysDeviceType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    List<SysDeviceType> selectByExample(SysDeviceTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    SysDeviceType selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysDeviceType record, @Param("example") SysDeviceTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int updateByExample(@Param("record") SysDeviceType record, @Param("example") SysDeviceTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int updateByPrimaryKeySelective(SysDeviceType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_device_type
     *
     * @mbg.generated Mon Dec 07 09:18:47 CST 2020
     */
    int updateByPrimaryKey(SysDeviceType record);
}