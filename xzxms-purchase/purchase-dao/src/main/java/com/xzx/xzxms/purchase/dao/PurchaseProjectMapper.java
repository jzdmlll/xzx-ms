package com.xzx.xzxms.purchase.dao;

import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.bean.PurchaseProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    long countByExample(PurchaseProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int deleteByExample(PurchaseProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int insert(PurchaseProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int insertSelective(PurchaseProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    List<PurchaseProject> selectByExample(PurchaseProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    PurchaseProject selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int updateByExampleSelective(@Param("record") PurchaseProject record, @Param("example") PurchaseProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int updateByExample(@Param("record") PurchaseProject record, @Param("example") PurchaseProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int updateByPrimaryKeySelective(PurchaseProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Tue Jan 05 19:43:42 CST 2021
     */
    int updateByPrimaryKey(PurchaseProject record);
}