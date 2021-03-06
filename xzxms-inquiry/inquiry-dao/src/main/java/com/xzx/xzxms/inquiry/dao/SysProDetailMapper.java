package com.xzx.xzxms.inquiry.dao;

import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.bean.SysProDetailExample;
import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysProDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    long countByExample(SysProDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int deleteByExample(SysProDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int insert(SysProDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int insertSelective(SysProDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    List<SysProDetailWithBLOBs> selectByExampleWithBLOBs(SysProDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    List<SysProDetail> selectByExample(SysProDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    SysProDetailWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int updateByExampleSelective(@Param("record") SysProDetailWithBLOBs record, @Param("example") SysProDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") SysProDetailWithBLOBs record, @Param("example") SysProDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int updateByExample(@Param("record") SysProDetail record, @Param("example") SysProDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int updateByPrimaryKeySelective(SysProDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(SysProDetailWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Tue Jan 05 19:42:53 CST 2021
     */
    int updateByPrimaryKey(SysProDetail record);
}