package com.xzx.xzxms.inquiry.dao;

import com.xzx.xzxms.inquiry.bean.SysProType;
import com.xzx.xzxms.inquiry.bean.SysProTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysProTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    long countByExample(SysProTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int deleteByExample(SysProTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int insert(SysProType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int insertSelective(SysProType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    List<SysProType> selectByExample(SysProTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    SysProType selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysProType record, @Param("example") SysProTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByExample(@Param("record") SysProType record, @Param("example") SysProTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByPrimaryKeySelective(SysProType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_type
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByPrimaryKey(SysProType record);
}