package com.xzx.xzxms.stock.dao;

import com.xzx.xzxms.stock.bean.StockCheck;
import com.xzx.xzxms.stock.bean.StockCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockCheckMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    long countByExample(StockCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int deleteByExample(StockCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int insert(StockCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int insertSelective(StockCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    List<StockCheck> selectByExample(StockCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    StockCheck selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByExampleSelective(@Param("record") StockCheck record, @Param("example") StockCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByExample(@Param("record") StockCheck record, @Param("example") StockCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByPrimaryKeySelective(StockCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_check
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByPrimaryKey(StockCheck record);
}