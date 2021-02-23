package com.xzx.xzxms.recruit.dao;

import com.xzx.xzxms.recruit.bean.RecruitFile;
import com.xzx.xzxms.recruit.bean.RecruitFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    long countByExample(RecruitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int deleteByExample(RecruitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int insert(RecruitFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int insertSelective(RecruitFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    List<RecruitFile> selectByExample(RecruitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    RecruitFile selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int updateByExampleSelective(@Param("record") RecruitFile record, @Param("example") RecruitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int updateByExample(@Param("record") RecruitFile record, @Param("example") RecruitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int updateByPrimaryKeySelective(RecruitFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit_file
     *
     * @mbg.generated Tue Feb 23 09:27:41 CST 2021
     */
    int updateByPrimaryKey(RecruitFile record);
}