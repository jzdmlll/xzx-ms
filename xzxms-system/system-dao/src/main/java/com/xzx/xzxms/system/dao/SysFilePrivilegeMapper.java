package com.xzx.xzxms.system.dao;

import com.xzx.xzxms.system.bean.SysFilePrivilege;
import com.xzx.xzxms.system.bean.SysFilePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFilePrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    long countByExample(SysFilePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int deleteByExample(SysFilePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int insert(SysFilePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int insertSelective(SysFilePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    List<SysFilePrivilege> selectByExample(SysFilePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    SysFilePrivilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int updateByExampleSelective(@Param("record") SysFilePrivilege record, @Param("example") SysFilePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int updateByExample(@Param("record") SysFilePrivilege record, @Param("example") SysFilePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int updateByPrimaryKeySelective(SysFilePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file_privilege
     *
     * @mbg.generated Fri Jan 15 10:59:51 CST 2021
     */
    int updateByPrimaryKey(SysFilePrivilege record);
}