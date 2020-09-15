package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.bean.InquiryWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    long countByExample(InquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int deleteByExample(InquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int insert(InquiryWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int insertSelective(InquiryWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    List<InquiryWithBLOBs> selectByExampleWithBLOBs(InquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    List<Inquiry> selectByExample(InquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    InquiryWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") InquiryWithBLOBs record, @Param("example") InquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") InquiryWithBLOBs record, @Param("example") InquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int updateByExample(@Param("record") Inquiry record, @Param("example") InquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int updateByPrimaryKeySelective(InquiryWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(InquiryWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inquiry
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    int updateByPrimaryKey(Inquiry record);
}