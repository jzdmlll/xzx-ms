package com.xzx.xzxms.system.dao.extend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.system.bean.extend.SysAnnouncementExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/1/18 10:46
 * @Version 1.0
 */
public interface SysAnnouncementSendExtendMapper {

    List<String> findByUserId(@Param("userId") String userId);

    IPage<SysAnnouncementExtend> getMyAnnouncementSendPage(Page<?> page,
                                                           @Param("userId") Long userId,
                                                           @Param("readFlag") String readFlag,
                                                           @Param("msgCategory") String msgCategory);
}
