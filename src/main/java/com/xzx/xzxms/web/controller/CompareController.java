package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.service.ICompareService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.vm.CompareReqVM;
import com.xzx.xzxms.vm.CompareRespVM;
import com.xzx.xzxms.vm.InquiryCompareVM;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<InquiryCompareVM> inquiryCompareVMS = compareServiceImpl.cascadeFindAllByParams(proDetailId, name);
        // 数据格式：[{name: "", inquiryCompareVMS: List<inquiryCompareVMS>},{...}]
        // inquiryCompareVMS：[{...},{...}]
        Map map = new HashMap();
        map.put("name", name);
        map.put("inquiryCompareVMS", inquiryCompareVMS);
        List<Map> result = new ArrayList<>();
        result.add(map);
        return MessageUtil.success("success", result);
    }
    @PostMapping("completeCompare")
    public Message completeCompare(@RequestBody CompareRespVM compareRespVM) {
        compareServiceImpl.completeCompare(compareRespVM.getCheckCompareIds(), compareRespVM.getOtherCompareIds());
        return MessageUtil.success("操作成功");
    }
    @PostMapping("batchGetCompare")
    public Message batchGetCompare(@RequestBody CompareReqVM CompareReqVM) {
        List<?> result = compareServiceImpl.batchGetCompare(CompareReqVM);
        return MessageUtil.success("success", result);
    }
}
