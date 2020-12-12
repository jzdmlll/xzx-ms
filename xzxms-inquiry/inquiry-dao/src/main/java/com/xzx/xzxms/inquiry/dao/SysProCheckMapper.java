package com.xzx.xzxms.inquiry.dao;

import com.xzx.xzxms.inquiry.bean.SysProCheck;
import com.xzx.xzxms.inquiry.bean.SysProCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysProCheckMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    long countByExample(SysProCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int deleteByExample(SysProCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int insert(SysProCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int insertSelective(SysProCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    List<SysProCheck> selectByExample(SysProCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    SysProCheck selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysProCheck record, @Param("example") SysProCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByExample(@Param("record") SysProCheck record, @Param("example") SysProCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByPrimaryKeySelective(SysProCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByPrimaryKey(SysProCheck record);
}