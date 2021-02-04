package com.xzx.xzxms.system.dao.extend;


import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

public interface SysFileExtendMapper {
    List<SysFile> selectByOtherId(long id);
}
