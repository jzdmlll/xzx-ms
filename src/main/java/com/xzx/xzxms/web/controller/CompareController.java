package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.service.ICompareService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.vm.InquiryCompareVM;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/compare")
public class CompareController {
    @Resource
    private ICompareService compareServiceImpl;

    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll() {
        List<InquiryCompareVM> inquiry = compareServiceImpl.cascadeFindAll(-1, -1);
        return MessageUtil.success("success", inquiry);
    }

    @PostMapping("cascadeFindAll")
    public Message cascadeFindAll(@RequestParam(defaultValue="-1")int compareStatus,@RequestParam(defaultValue="-1") long proDetailId) {
        List<InquiryCompareVM> inquiry = compareServiceImpl.cascadeFindAll(compareStatus, proDetailId);
        return MessageUtil.success("success", inquiry);
    }
    @GetMapping("cascadeFindAllByParams")
    public Message cascadeFindAllByParams(long proDetailId, String name) {
        List<InquiryCompareVM> inquiryWithBLOBs = compareServiceImpl.cascadeFindAllByParams(proDetailId, name);
        return MessageUtil.success("success", inquiryWithBLOBs);
    }
    @PostMapping("completeCompare")
    public Message completeCompare(long compareId, long[] otherCompareId) {
        compareServiceImpl.completeCompare(compareId, otherCompareId);
        return MessageUtil.success("操作成功");
    }
}
