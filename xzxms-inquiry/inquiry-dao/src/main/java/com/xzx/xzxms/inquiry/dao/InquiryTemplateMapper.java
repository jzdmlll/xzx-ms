package com.xzx.xzxms.inquiry.dao;

import com.xzx.xzxms.inquiry.bean.InquiryTemplate;
import com.xzx.xzxms.inquiry.bean.InquiryTemplateExample;
import com.xzx.xzxms.inquiry.bean.InquiryTemplateWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryTemplateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    long countByExample(InquiryTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int deleteByExample(InquiryTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int insert(InquiryTemplateWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int insertSelective(InquiryTemplateWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    List<InquiryTemplateWithBLOBs> selectByExampleWithBLOBs(InquiryTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    List<InquiryTemplate> selectByExample(InquiryTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    InquiryTemplateWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int updateByExampleSelective(@Param("record") InquiryTemplateWithBLOBs record, @Param("example") InquiryTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") InquiryTemplateWithBLOBs record, @Param("example") InquiryTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int updateByExample(@Param("record") InquiryTemplate record, @Param("example") InquiryTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int updateByPrimaryKeySelective(InquiryTemplateWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(InquiryTemplateWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry_template
     *
     * @mbg.generated Sun Jan 24 12:54:02 CST 2021
     */
    int updateByPrimaryKey(InquiryTemplate record);
}