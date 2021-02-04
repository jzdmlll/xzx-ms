package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.IFinallyCheckService;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.vm.FinallyCheckReqVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/finallyCheck")
public class FinallyCheckController {

    @Resource
    private IFinallyCheckService finallyCheckServiceImpl;

    @GetMapping("findDraftComparePrice")
    public Message FindDraftComparePrice(@RequestParam(defaultValue = "-1") Long proDetailId, String name) {
        List<Map> maps = finallyCheckServiceImpl.cascadeFindAllByParams(proDetailId, name);
        return MessageUtil.success("success", maps);
    }

    @PostMapping("saveFinallyCheckMessage")
    public Message saveFinallyCheckMessage(@RequestBody FinallyCheckReqVM finallyCheckReqVM){
        finallyCheckServiceImpl.FinallyCheckCommit(finallyCheckReqVM.getCheckCompareIds(), finallyCheckReqVM.getUncheckCompareIds(), finallyCheckReqVM.getRemarks(), finallyCheckReqVM.getUserId());
        return MessageUtil.success("操作成功");
    }

    @PostMapping("refuseInquiry")
    public Message refuseInquiry(Inquiry inquiry){
        finallyCheckServiceImpl.refuseInquiry(inquiry);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("根据项目ID查询出所有的询价名（询价名去重）")
    @GetMapping("findInquiryNameByProId")
    public Message findInquiryNameByProId(Long proId){
        List<Map> maps = finallyCheckServiceImpl.findInquiryNameByProId(proId);
        return MessageUtil.success("success", maps);
    }
}
