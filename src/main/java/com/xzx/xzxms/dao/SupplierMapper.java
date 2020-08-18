package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.Supplier;
import com.xzx.xzxms.bean.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    long countByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int deleteByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int insert(Supplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int insertSelective(Supplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    List<Supplier> selectByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    Supplier selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int updateByPrimaryKeySelective(Supplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xzx_supplier
     *
     * @mbg.generated Mon Aug 17 17:35:55 CST 2020
     */
    int updateByPrimaryKey(Supplier record);
}