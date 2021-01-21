package com.xzx.xzxms.chapter.controller;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.chapter.dao.extend.ChapterAuditExtendMapper;
import com.xzx.xzxms.chapter.dto.ChapterAuditDTO;
import com.xzx.xzxms.chapter.dto.ChapterAuditorDTO;
import com.xzx.xzxms.chapter.service.ChapterAuditService;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.bean.SysFile;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    ChapterAuditExtendMapper chapterAuditExtendMapper;

    /**
     * 周嘉玮
     */
    @ApiOperation("在文件表中新增文件；在用章审核表中新增信息")
    @PostMapping("insertChapterAudit")
    public Message insertChapterAudit(@RequestBody ChapterAuditDTO chapterAuditDTO){
        String result = chapterAuditService.insertChapterAuditService(chapterAuditDTO.getChapterAudit(), chapterAuditDTO.getFiles());
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    @ApiOperation("下拉显示所有可发往的用章审核人")
    @GetMapping("findAllChapterAuditor")
    public Message findAllChapterAuditor(){
        List<ChapterAuditorDTO> allChapterAuditor = chapterAuditExtendMapper.findAllChapterAuditor();
        if (allChapterAuditor.size() > 0){
            return MessageUtil.success("success", allChapterAuditor);
        }else {
            return MessageUtil.error("无审核人");
        }
    }



    /**
     * 周嘉玮
     */
    @ApiOperation("获取所有项目名")
    @GetMapping("findAllProjectName")
    public Message findAllProjectName(){
        List<ChapterAudit> projectNames = chapterAuditService.findAllProjectNameService();
        if (projectNames.size() > 0){
            return MessageUtil.success("success", projectNames);
        }else {
            return MessageUtil.error("无查询结果");
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("根据项目名称查询该项目下所有审核信息审核信息")
    @GetMapping("findChapterAuditInfosByProjectName")
    public Message findChapterAuditInfosByProjectName(String projectName){
        List<ChapterAudit> chapterAuditInfos = chapterAuditService.findChapterAuditInfosByProjectNameService(projectName);
        if (chapterAuditInfos.size() > 0){
            return MessageUtil.success("success", chapterAuditInfos);
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("审核人审核回馈")
    @PostMapping("updateChapterAudit")
    public Message updateChapterAudit(@RequestBody ChapterAudit chapterAudit){
        String result = chapterAuditService.updateChapterAuditService(chapterAudit);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("删除该条审核")
    @GetMapping("deleteChapterAuditService")
    public Message deleteChapterAuditService(Long id){
        String result = chapterAuditService.deleteChapterAuditService(id);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    @ApiOperation("根据审核项id（在sys_file中是other_id）查询其文件")
    @GetMapping("findFileUrlByOtherId")
    public Message findFileUrlByOtherId(Long id){
        List<SysFile> fileUrls = chapterAuditService.findFileUrlByOtherIdService(id);
        if (fileUrls.size()>0){
            return MessageUtil.success("success",fileUrls);
        }else {
            return MessageUtil.error("无上传文件");
        }
    }

}
