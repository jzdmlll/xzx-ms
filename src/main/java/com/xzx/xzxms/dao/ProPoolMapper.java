package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.ProPool;
import com.xzx.xzxms.bean.ProPoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProPoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    long countByExample(ProPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int deleteByExample(ProPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int insert(ProPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int insertSelective(ProPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    List<ProPool> selectByExample(ProPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    ProPool selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int updateByExampleSelective(@Param("record") ProPool record, @Param("example") ProPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int updateByExample(@Param("record") ProPool record, @Param("example") ProPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int updateByPrimaryKeySelective(ProPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_pool
     *
     * @mbg.generated Thu Nov 05 09:23:05 CST 2020
     */
    int updateByPrimaryKey(ProPool record);
}