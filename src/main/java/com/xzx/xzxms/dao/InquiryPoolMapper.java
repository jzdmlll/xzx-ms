package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.InquiryPool;
import com.xzx.xzxms.bean.InquiryPoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryPoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    long countByExample(InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int deleteByExample(InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int insert(InquiryPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int insertSelective(InquiryPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    List<InquiryPool> selectByExample(InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    InquiryPool selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") InquiryPool record, @Param("example") InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int updateByExample(@Param("record") InquiryPool record, @Param("example") InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(InquiryPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Nov 14 09:17:47 GMT+08:00 2020
     */
    int updateByPrimaryKey(InquiryPool record);
}