package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.bean.SysProOriginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysProOriginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    long countByExample(SysProOriginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int deleteByExample(SysProOriginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int insert(SysProOrigin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int insertSelective(SysProOrigin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    List<SysProOrigin> selectByExample(SysProOriginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    SysProOrigin selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysProOrigin record, @Param("example") SysProOriginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByExample(@Param("record") SysProOrigin record, @Param("example") SysProOriginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByPrimaryKeySelective(SysProOrigin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_origin
     *
     * @mbg.generated Wed Aug 19 16:33:19 CST 2020
     */
    int updateByPrimaryKey(SysProOrigin record);
}