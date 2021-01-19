package com.xzx.xzxms.chapter.service;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.system.bean.SysFile;

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
     * 在文件表中新增文件；在用章审核表中新增信息
     * @param chapterAudit
     * @param files
     * @return
     */
    String insertChapterAudit(ChapterAudit chapterAudit, List<SysFile> files);
}
