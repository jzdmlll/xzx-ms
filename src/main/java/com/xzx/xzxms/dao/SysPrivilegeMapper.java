package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.SysPrivilege;
import com.xzx.xzxms.bean.SysPrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    long countByExample(SysPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int deleteByExample(SysPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int insert(SysPrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int insertSelective(SysPrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    List<SysPrivilege> selectByExample(SysPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    SysPrivilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByExample(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByPrimaryKeySelective(SysPrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_privilege
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByPrimaryKey(SysPrivilege record);
}