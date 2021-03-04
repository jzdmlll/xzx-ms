package com.xzx.xzxms.chapter.service;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.system.bean.SysFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/19 14:35
 * @修改人：
 * @修改时间：2021/1/19 14:35
 * @修改描述：默认描述
 */

public interface ChapterAuditService {
    /**
     * 周嘉玮
     * 在文件表中新增文件；在用章审核表中新增信息
     * @param chapterAudit
     * @param files
     * @return
     */
    String insertChapterAuditService(ChapterAudit chapterAudit, List<SysFile> files);

    /**
     * 周嘉玮
     * 获取所有项目名
     * @return
     */
    List<ChapterAudit> findAllProjectNameService();

    /**
     * 周嘉玮
     * 根据项目名称查询该项目下所有审核信息审核信息
     * @return
     */
    List<ChapterAudit> findChapterAuditInfosByProjectNameService(String proName, Long startTime, Long overTime, Integer auditStatus);

    /**
     * 周嘉玮
     * 审核人审核回馈
     * @param chapterAudit
     * @return
     */
    String updateChapterAuditService(ChapterAudit chapterAudit);

    /**
     * 周嘉玮
     * 删除该条审核
     * @param id
     * @return
     */
    String deleteChapterAuditService(Long id);

    /**
     * 根据审核项id（在sys_file中是other_id）查询其文件
     * @param otherId
     * @return
     */
    List<SysFile> findFileUrlByOtherIdService(Long otherId);
}
