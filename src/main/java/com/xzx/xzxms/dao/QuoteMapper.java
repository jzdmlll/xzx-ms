package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.QuoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuoteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    long countByExample(QuoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int deleteByExample(QuoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int insert(Quote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int insertSelective(Quote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    List<Quote> selectByExample(QuoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    Quote selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") Quote record, @Param("example") QuoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int updateByExample(@Param("record") Quote record, @Param("example") QuoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(Quote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quote
     *
     * @mbg.generated Tue Nov 03 15:18:52 GMT+08:00 2020
     */
    int updateByPrimaryKey(Quote record);
}