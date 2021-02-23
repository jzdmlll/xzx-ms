package com.xzx.xzxms.recruit.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.recruit.bean.RecruitProject;
import com.xzx.xzxms.recruit.service.RecruitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/22 14:19
 * @修改人：
 * @修改时间：2021/2/22 14:19
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/recruit/recruitProject")
public class RecruitController {

    @Resource
    private RecruitService recruitService;

    /**
     * 周嘉玮
     */
    @ApiOperation("根据招标项目id获取其所有信息")
    @GetMapping("findRecruitProjectById")
    public Message findRecruitProjectById(Long id){
        RecruitProject recruitProjectInfo = recruitService.findRecruitProjectByIdService(id);
        return  MessageUtil.success("success", recruitProjectInfo);
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("新建招标项目")
    @PostMapping("insertRecruitProject")
    public Message insertRecruitProject(RecruitProject recruitProject){
        String result = recruitService.insertRecruitProjectService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("修改招标项目的基本信息")
    @PostMapping("updateRecruitProjectInfo")
    public Message updateRecruitProjectInfo(RecruitProject recruitProject){
        String result = recruitService.updateRecruitProjectInfoService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("发往商务审核")
    @PostMapping("updateRecruitBusiness")
    public Message updateRecruitBusiness(RecruitProject recruitProject){
        String result = recruitService.updateRecruitBusinessService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("商务审核")
    @PostMapping("updateRecruitBusinessAudit")
    public Message updateRecruitBusinessAudit(RecruitProject recruitProject){
        String result = recruitService.updateRecruitBusinessAuditService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("发往工程审核")
    @PostMapping("updateRecruitEngineering")
    public Message updateRecruitEngineering(RecruitProject recruitProject){
        String result = recruitService.updateRecruitEngineeringService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("工程审核")
    @PostMapping("updateRecruitEngineeringAudit")
    public Message updateRecruitEngineeringAudit(RecruitProject recruitProject){
        String result = recruitService.updateRecruitEngineeringAuditService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("发往发布审核")
    @PostMapping("updateRecruitRelease")
    public Message updateRecruitRelease(RecruitProject recruitProject){
        String result = recruitService.updateRecruitReleaseService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("发布审核")
    @PostMapping("updateRecruitReleaseAudit")
    public Message updateRecruitReleaseAudit(RecruitProject recruitProject){
        String result = recruitService.updateRecruitReleaseAuditService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("发往投标公司资质审核")
    @PostMapping("updateRecruitQualification")
    public Message updateRecruitQualification(RecruitProject recruitProject){
        String result = recruitService.updateRecruitQualificationService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("投标公司资质审核")
    @PostMapping("updateRecruitQualificationAudit")
    public Message updateRecruitQualificationAudit(RecruitProject recruitProject){
        String result = recruitService.updateRecruitQualificationAuditService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("发往评标、开标审核")
    @PostMapping("updateRecruitBidEvaluation")
    public Message updateRecruitBidEvaluation(RecruitProject recruitProject){
        String result = recruitService.updateRecruitBidEvaluationService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("评标、开标审核")
    @PostMapping("updateRecruitBidEvaluationAudit")
    public Message updateRecruitBidEvaluationAudit(RecruitProject recruitProject){
        String result = recruitService.updateRecruitBidEvaluationAuditService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("发往汇总评标报告审核")
    @PostMapping("updateRecruitReport")
    public Message updateRecruitReport(RecruitProject recruitProject){
        String result = recruitService.updateRecruitReportService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("汇总评标报告审核")
    @PostMapping("updateRecruitReportAudit")
    public Message updateRecruitReportAudit(RecruitProject recruitProject){
        String result = recruitService.updateRecruitReportAuditService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("更新中标人")
    @PostMapping("updateRecruitSuccessfulBidder")
    public Message updateRecruitSuccessfulBidder(RecruitProject recruitProject){
        String result = recruitService.updateRecruitSuccessfulBidderService(recruitProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

}
