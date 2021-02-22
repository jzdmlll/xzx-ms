package com.xzx.xzxms.stock.dao;

import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.bean.StockEntryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockEntryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    long countByExample(StockEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int deleteByExample(StockEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int insert(StockEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int insertSelective(StockEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    List<StockEntry> selectByExample(StockEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    StockEntry selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByExampleSelective(@Param("record") StockEntry record, @Param("example") StockEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByExample(@Param("record") StockEntry record, @Param("example") StockEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByPrimaryKeySelective(StockEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_entry
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    int updateByPrimaryKey(StockEntry record);
}