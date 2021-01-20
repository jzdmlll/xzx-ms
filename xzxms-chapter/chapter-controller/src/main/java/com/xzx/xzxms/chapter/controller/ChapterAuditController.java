package com.xzx.xzxms.chapter.controller;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.chapter.dto.ChapterAuditDTO;
import com.xzx.xzxms.chapter.service.ChapterAuditService;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.bean.SysFile;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/19 15:52
 * @修改人：
 * @修改时间：2021/1/19 15:52
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/chapter/chapterAudit")
public class ChapterAuditController {

    @Autowired
    ChapterAuditService chapterAuditService;

    @ApiOperation("在文件表中新增文件；在用章审核表中新增信息")
    @PostMapping("insertChapterAudit")
    public Message insertChapterAudit(@RequestBody ChapterAuditDTO chapterAuditDTO){
        String result = chapterAuditService.insertChapterAudit(chapterAuditDTO.getChapterAudit(), chapterAuditDTO.getFiles());
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }
}
