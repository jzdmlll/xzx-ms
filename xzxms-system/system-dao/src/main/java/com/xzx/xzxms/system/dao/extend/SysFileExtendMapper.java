package com.xzx.xzxms.system.dao.extend;


import com.xzx.xzxms.system.bean.SysFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysFileExtendMapper {
    List<SysFile> selectByOtherId(@Param("otherId") Long otherId, @Param("type") Integer type);
}
