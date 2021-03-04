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
import org.apache.ibatis.annotations.Param;
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
            return MessageUtil.success("操作成功");
        }else {
            return MessageUtil.error("error");
        }
    }

    @ApiOperation("下拉显示所有可发往的用章审核人")
    @GetMapping("findAllChapterAuditor")
    public Message findAllChapterAuditor(){
        List<ChapterAuditorDTO> allChapterAuditor = chapterAuditExtendMapper.findAllChapterAuditor();
        return MessageUtil.success("查询成功", allChapterAuditor);
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("获取所有项目名")
    @GetMapping("findAllProjectName")
    public Message findAllProjectName(){
        List<ChapterAudit> projectNames = chapterAuditService.findAllProjectNameService();
        return MessageUtil.success("查询成功", projectNames);
    }


    @GetMapping("findChapterAuditInfosByParams")
    public Message findChapterAuditInfosByParams(@Param("proId") String proId,
                                                      @Param("startTime") Long startTime,
                                                      @Param("overTime") Long overTime,
                                                      @Param("auditStatus") Integer auditStatus){
        List<ChapterAudit> chapterAuditInfos = chapterAuditService.findChapterAuditInfosByProjectNameService(proId, startTime, overTime, auditStatus);
        return MessageUtil.success("success", chapterAuditInfos);
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("审核人审核回馈")
    @PostMapping("updateChapterAudit")
    public Message updateChapterAudit(@RequestBody ChapterAudit chapterAudit){
        String result = chapterAuditService.updateChapterAuditService(chapterAudit);
        if (result.equals("success")){
            return MessageUtil.success("操作成功");
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
            return MessageUtil.success("操作成功");
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("根据审核项id（在sys_file中是other_id）查询其文件")
    @GetMapping("findFileUrlByOtherId")
    public Message findFileUrlByOtherId(Long id){
        List<SysFile> fileUrls = chapterAuditService.findFileUrlByOtherIdService(id);
        if (fileUrls.size()>0){
            return MessageUtil.success("查询成功", fileUrls);
        }else {
            return MessageUtil.error("无上传文件");
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("根据输入条件进行查询、模糊查询")
    @GetMapping("findChapterAuditorInfos")
    public Message findChapterAuditorInfos(@Param("proName") String proName,
                                           @Param("startTime") Long startTime,
                                           @Param("overTime") Long overTime,
                                           @Param("auditStatus") Integer auditStatus){
        List<ChapterAudit> chapterAuditorInfos = chapterAuditExtendMapper.findChapterAuditorInfoByLike(proName, startTime, overTime, auditStatus);
        if (chapterAuditorInfos.size() > 0){
            return MessageUtil.success("查询成功", chapterAuditorInfos);
        }else {
            return MessageUtil.error("无查询结果");
        }
    }

}
