package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.SysCheckAndScheduleExtend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysIndexExtendMapper {

    List<SysCheckAndScheduleExtend> findAllProjectSchedule();

    List<SysCheckAndScheduleExtend> findProDetailSchedule(long proDetailId);

    List<SysCheckAndScheduleExtend> findProIsFinally(String proName);

    @Select("SELECT COUNT(1) as total from sys_pro_detail where sys_pro_detail.is_active = 1")
    int findPro();

    @Select("SELECT COUNT(1) as total from (SELECT COUNT(1) as total from product_pool where product_pool.is_active = 1 GROUP BY product_pool.supplier) t")
    int findSupplier();

    @Select("SELECT COUNT(1) as total, FROM_UNIXTIME(time/1000,'%m') t FROM sys_pro_detail where FROM_UNIXTIME(time/1000,'%Y年%m') LIKE CONCAT(#{year,jdbcType=VARCHAR},'%') GROUP BY t ORDER BY t")
    List<Map<String,Integer>> findYearPro(String year);

    @Select("SELECT COUNT(1) as total, FROM_UNIXTIME(time/1000,'%m') t FROM product_pool where FROM_UNIXTIME(time/1000,'%Y年%m') LIKE CONCAT(#{year,jdbcType=VARCHAR},'%') GROUP BY t ORDER BY t")
    List<Map<String,Integer>> findYearSupplier(String year);
}
