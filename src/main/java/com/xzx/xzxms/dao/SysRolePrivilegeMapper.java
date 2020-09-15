package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.SysRolePrivilege;
import com.xzx.xzxms.bean.SysRolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    long countByExample(SysRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int deleteByExample(SysRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int insert(SysRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int insertSelective(SysRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    List<SysRolePrivilege> selectByExample(SysRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    SysRolePrivilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int updateByExample(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int updateByPrimaryKeySelective(SysRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Sep 15 14:27:28 CST 2020
     */
    int updateByPrimaryKey(SysRolePrivilege record);
}