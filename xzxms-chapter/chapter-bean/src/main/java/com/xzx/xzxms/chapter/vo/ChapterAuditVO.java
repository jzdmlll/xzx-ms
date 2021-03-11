package com.xzx.xzxms.chapter.vo;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/3/10 10:57
 * @Version 1.0
 */
public class ChapterAuditVO extends ChapterAudit {

    List<SysFile> files;

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }
}
