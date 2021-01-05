package com.xzx.xzxms.inquiry.dao;

import com.xzx.xzxms.inquiry.bean.InquiryPool;
import com.xzx.xzxms.inquiry.bean.InquiryPoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryPoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    long countByExample(InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int deleteByExample(InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int insert(InquiryPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int insertSelective(InquiryPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    List<InquiryPool> selectByExample(InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    InquiryPool selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") InquiryPool record, @Param("example") InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByExample(@Param("record") InquiryPool record, @Param("example") InquiryPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByPrimaryKeySelective(InquiryPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_pool
     *
     * @mbg.generated Sat Dec 12 12:14:48 CST 2020
     */
    int updateByPrimaryKey(InquiryPool record);
}