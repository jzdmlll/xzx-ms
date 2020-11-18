package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.ProPoolExtend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProPoolExtendMapper {

    @Select("SELECT count(*) from quote qu " +
            "LEFT JOIN sys_pro_check pc on qu.id = pc.content_id " +
            "where qu.inquiry_id =  " +
            "( " +
            "SELECT  " +
            "i.id " +
            "FROM  " +
            "\tsys_pro_check spc  " +
            "LEFT JOIN quote q on q.id=spc.content_id " +
            "LEFT JOIN inquiry i on q.inquiry_id = i.id " +
            " " +
            "WHERE spc.id = #{0} " +
            ") " +
            "and pc.type=\"最终审核\" and pc.check_status != 0")
    int isFinalCheck(long proCheckId);

    List<ProPoolExtend> findByParams(String name,String brand);
}
