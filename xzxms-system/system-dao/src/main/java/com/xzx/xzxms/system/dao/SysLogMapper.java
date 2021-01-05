package com.xzx.xzxms.system.dao;

import com.xzx.xzxms.system.bean.SysLog;
import com.xzx.xzxms.system.bean.SysLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    long countByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int deleteByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int insert(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int insertSelective(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    List<SysLog> selectByExampleWithBLOBs(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    List<SysLog> selectByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    SysLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int updateByPrimaryKeySelective(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Tue Jan 05 19:44:11 CST 2021
     */
    int updateByPrimaryKey(SysLog record);
}