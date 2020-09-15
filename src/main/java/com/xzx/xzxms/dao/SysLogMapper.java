package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.SysLog;
import com.xzx.xzxms.bean.SysLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    long countByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int deleteByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int insert(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int insertSelective(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    List<SysLog> selectByExampleWithBLOBs(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    List<SysLog> selectByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    SysLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int updateByPrimaryKeySelective(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu Sep 10 10:28:07 CST 2020
     */
    int updateByPrimaryKey(SysLog record);
}