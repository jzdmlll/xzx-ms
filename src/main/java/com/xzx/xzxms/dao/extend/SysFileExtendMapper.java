package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.SysFile;

import java.util.List;

public interface SysFileExtendMapper {
    List<SysFile> selectByOtherId(long id);
}
