package com.xzx.xzxms.inquiry.dao.extend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.inquiry.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.inquiry.vo.ProjectCompletionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    @Select("SELECT COUNT(1) as total, FROM_UNIXTIME(time/1000,'%m') t FROM sys_pro_detail where sys_pro_detail.is_active = 1 AND FROM_UNIXTIME(time/1000,'%Y年%m') LIKE CONCAT(#{year,jdbcType=VARCHAR},'%') GROUP BY t, time ORDER BY t")
    List<Map<String,String>> findYearPro(String year);

    @Select("SELECT COUNT(1) as total, FROM_UNIXTIME(time/1000,'%m') t FROM product_pool where product_pool.is_active = 1 AND FROM_UNIXTIME(time/1000,'%Y年%m') LIKE CONCAT(#{year,jdbcType=VARCHAR},'%') GROUP BY t, time ORDER BY t")
    List<Map<String,String>> findYearSupplier(String year);
    IPage<ProjectCompletionVO> findProAndCompletion(Page<?> page, @Param("orderBy") String orderBy);
}
