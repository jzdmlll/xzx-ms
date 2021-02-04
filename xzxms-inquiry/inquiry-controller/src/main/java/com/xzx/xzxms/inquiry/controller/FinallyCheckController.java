package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.IFinallyCheckService;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.vm.FinallyCheckReqVM;
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
    public Message FindDraftComparePrice(@RequestParam(defaultValue = "-1") long proDetailId) {
        List<Map> maps = finallyCheckServiceImpl.cascadeFindAllByParams(proDetailId);
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
}
