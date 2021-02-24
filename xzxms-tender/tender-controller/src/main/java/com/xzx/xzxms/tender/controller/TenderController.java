package com.xzx.xzxms.tender.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.tender.bean.TenderProject;
import com.xzx.xzxms.tender.service.TenderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/24 16:26
 * @修改人：
 * @修改时间：2021/2/24 16:26
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/tender/tenderProject")
public class TenderController {
    @Resource
    TenderService tenderService;

    /**
     * 周嘉玮
     */
    @ApiOperation("根据投标项目id获取其所有信息")
    @GetMapping("findTenderProjectById")
    public Message findTenderProjectById(Long id){
        TenderProject tenderProjectInfo = tenderService.findTenderProjectByIdService(id);
        return  MessageUtil.success("success", tenderProjectInfo);
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("新建投标项目")
    @PostMapping("insertTenderProject")
    public Message insertTenderProject(TenderProject tenderProject){
        String result = tenderService.insertTenderProjectService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("修改投标项目的基本信息")
    @PostMapping("updateTenderProjectInfo")
    public Message updateTenderProjectInfo(TenderProject tenderProject){
        String result = tenderService.updateTenderProjectInfoService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("投标信息送审")
    @PostMapping("updateBidInfo")
    public Message updateBidInfo(TenderProject tenderProject){
        String result = tenderService.updateBidInfoService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("投标信息审核")
    @PostMapping("updateBidInfoAudit")
    public Message updateBidInfoAudit(TenderProject tenderProject){
        String result = tenderService.updateBidInfoAuditService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("投标报名")
    @PostMapping("updateBidApply")
    public Message updateBidApply(TenderProject tenderProject){
        String result = tenderService.updateBidApplyService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("技术方案送审")
    @PostMapping("updateTechnicalSolution")
    public Message updateTechnicalSolution(TenderProject tenderProject){
        String result = tenderService.updateTechnicalSolutionService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("技术方案审核")
    @PostMapping("updateTechnicalSolutionAudit")
    public Message updateTechnicalSolutionAudit(TenderProject tenderProject){
        String result = tenderService.updateTechnicalSolutionAuditService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("技术文件送审")
    @PostMapping("updateTechnicalDocumentation")
    public Message updateTechnicalDocumentation(TenderProject tenderProject){
        String result = tenderService.updateTechnicalDocumentationService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("技术文件审核")
    @PostMapping("updateTechnicalDocumentationAudit")
    public Message updateTechnicalDocumentationAudit(TenderProject tenderProject){
        String result = tenderService.updateTechnicalDocumentationAuditService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("中标")
    @PostMapping("updateWinBid")
    public Message updateWinBid(TenderProject tenderProject){
        String result = tenderService.updateWinBidService(tenderProject);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }


}
