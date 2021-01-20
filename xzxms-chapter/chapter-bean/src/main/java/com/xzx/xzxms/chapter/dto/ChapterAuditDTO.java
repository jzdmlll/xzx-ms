package com.xzx.xzxms.chapter.dto;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/20 9:07
 * @修改人：
 * @修改时间：2021/1/20 9:07
 * @修改描述：默认描述
 */
public class ChapterAuditDTO {
    private ChapterAudit chapterAudit;
    private List<SysFile> files;

    public ChapterAudit getChapterAudit() {
        return chapterAudit;
    }

    public void setChapterAudit(ChapterAudit chapterAudit) {
        this.chapterAudit = chapterAudit;
    }

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }
}
