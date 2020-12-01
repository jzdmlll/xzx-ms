package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SysProDetailExtendMapper {

    SysProDetailExtend findById(long proDetailId);

    List<SysProDetailExtend> findById();

    @Select("select a.id from sys_pro_detail a RIGHT JOIN inquiry b on a.id=b.pro_detail_id " +
            "RIGHT JOIN quote c on b.id=c.inquiry_id  " +
            "RIGHT JOIN sys_pro_check d on c.id=d.quote_id where d.id = #{0} GROUP BY a.id")
    Long isExistsProDetailId(long proCheckId);

    @Select("SELECT COUNT(1) FROM sys_pro_detail WHERE pro_no LIKE CONCAT(#{currentTime,jdbcType=VARCHAR} AND is_active = 1,'%')")
    int findCurrentExists(String currentTime);
}