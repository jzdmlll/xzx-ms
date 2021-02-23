package com.xzx.xzxms.recruit.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.recruit.bean.RecruitFile;
import com.xzx.xzxms.recruit.bean.RecruitProject;
import com.xzx.xzxms.recruit.service.RecruitFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/23 9:55
 * @修改人：
 * @修改时间：2021/2/23 9:55
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/recruit/recruitFile")
public class RecruitFileController {
    @Resource
    RecruitFileService recruitFileService;

    /**
     * 周嘉玮
     */
    @ApiOperation("1-招标信息文件")
    @PostMapping("insertRecruitInfoFile")
    public Message insertRecruitInfoFile(List<RecruitFile> fileList){
        String result = recruitFileService.insertRecruitInfoFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("2-投标公司资质文件")
    @PostMapping("insertQualificationFile")
    public Message insertQualificationFile(List<RecruitFile> fileList){
        String result = recruitFileService.insertQualificationFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("3-开标、评标过程信息文件")
    @PostMapping("insertBidEvaluationFile")
    public Message insertBidEvaluationFile(List<RecruitFile> fileList){
        String result = recruitFileService.insertBidEvaluationFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("4-汇总报告文件")
    @PostMapping("insertReportFile")
    public Message insertReportFile(List<RecruitFile> fileList){
        String result = recruitFileService.insertReportFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("删除文件")
    @PostMapping("deleteFileById")
    public Message deleteFileById(Long id){
        String result = recruitFileService.deleteFileByIdService(id);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("根据招标项目id和需要查看的文件类型(查看权限)来获取文件")
    @GetMapping("findFileByOrderIdAndType")
    public Message findFileByOrderIdAndType(RecruitFile recruitFile){
        List<RecruitFile> files = recruitFileService.findFileByOrderIdAndTypeService(recruitFile);
        return  MessageUtil.success("success", files);
    }

}
