package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.SysFile;
import com.xzx.xzxms.bean.SysFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    long countByExample(SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int deleteByExample(SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int insert(SysFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int insertSelective(SysFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    List<SysFile> selectByExample(SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    SysFile selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int updateByPrimaryKeySelective(SysFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Tue Sep 15 19:49:48 CST 2020
     */
    int updateByPrimaryKey(SysFile record);
}