package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.SysCheckAndScheduleExtend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysIndexExtendMapper {

    List<SysCheckAndScheduleExtend> findAllProjectSchedule();

    List<SysCheckAndScheduleExtend> findProDetailSchedule(long proDetailId);
}
