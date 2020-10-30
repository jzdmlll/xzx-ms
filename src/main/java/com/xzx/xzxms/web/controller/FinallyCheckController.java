package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.service.IFinallyCheckService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.vm.FinallyCheckReqVM;
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
        //finallyCheckCompareServiceImpl.saveFinallyCheckMessage(finallyCheckReqVM.getCheckInquiryIds(), finallyCheckReqVM.getRemarks(), finallyCheckReqVM.getAllInquiryIds(), finallyCheckReqVM.getUserId(), finallyCheckReqVM.getRoleId());
        return MessageUtil.success("操作成功");
    }
}
