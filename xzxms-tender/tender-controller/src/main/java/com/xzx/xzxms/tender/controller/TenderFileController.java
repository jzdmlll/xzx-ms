package com.xzx.xzxms.tender.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.tender.bean.TenderFile;
import com.xzx.xzxms.tender.service.TenderFileService;
import com.xzx.xzxms.tender.service.TenderService;
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
 * @date：2021/2/24 19:34
 * @修改人：
 * @修改时间：2021/2/24 19:34
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/tender/tenderFile")
public class TenderFileController {
    @Resource
    TenderFileService tenderFileService;

    /**
     * 周嘉玮
     */
    @ApiOperation("1-招标公告文件")
    @PostMapping("insertBidAnnouncementFile")
    public Message insertBidAnnouncementFile(List<TenderFile> fileList){
        String result = tenderFileService.insertBidAnnouncementFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("2 - 报名函")
    @PostMapping("insertApplicationLetterFile")
    public Message insertApplicationLetterFile(List<TenderFile> fileList){
        String result = tenderFileService.insertApplicationLetterFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("3 - 招标文件")
    @PostMapping("insertBidFile")
    public Message insertBidFile(List<TenderFile> fileList){
        String result = tenderFileService.insertBidFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("4 - 硬件清单")
    @PostMapping("insertHardwareFile")
    public Message insertHardwareFile(List<TenderFile> fileList){
        String result = tenderFileService.insertHardwareFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("5 - 技术文件")
    @PostMapping("insertTechnologyFile")
    public Message insertTechnologyFile(List<TenderFile> fileList){
        String result = tenderFileService.insertTechnologyFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("6 - 投标文件")
    @PostMapping("insertTenderFile")
    public Message insertTenderFile(List<TenderFile> fileList){
        String result = tenderFileService.insertTenderFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("7 - 归档文件")
    @PostMapping("insertArchiveFile")
    public Message insertArchiveFile(List<TenderFile> fileList){
        String result = tenderFileService.insertArchiveFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("8 - 最终报价清单文件")
    @PostMapping("insertFinalQuotationFile")
    public Message insertFinalQuotationFile(List<TenderFile> fileList){
        String result = tenderFileService.insertFinalQuotationFileService(fileList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error(result);
        }
    }

    /**
     * 周嘉玮
     */
    @ApiOperation("9 - 中标通知书")
    @PostMapping("insertLetterOfAcceptanceFile")
    public Message insertLetterOfAcceptanceFile(List<TenderFile> fileList){
        String result = tenderFileService.insertLetterOfAcceptanceFileService(fileList);
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
        String result = tenderFileService.deleteFileByIdService(id);
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
    @GetMapping("findFileByOrderIdAndTypeService")
    public Message findFileByOrderIdAndTypeService(TenderFile tenderFile){
        List<TenderFile> files = tenderFileService.findFileByOrderIdAndTypeService(tenderFile);
        return MessageUtil.success("success", files);
    }
}
