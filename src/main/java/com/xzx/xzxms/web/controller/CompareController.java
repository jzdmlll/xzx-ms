package com.xzx.xzxms.web.controller;


import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import com.xzx.xzxms.service.ICompareService;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.vm.CompareReqVM;
import com.xzx.xzxms.vm.CompareRespVM;
import com.xzx.xzxms.vm.QuoteRespVM;
import io.swagger.annotations.ApiOperation;
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
    private IInquiryService inquiryServiceImpl;
    @Resource
    private ICompareService compareServiceImpl;

    @ApiOperation("根据项目或比价状态查询")
    @GetMapping("findByProIdOrCompareStatus")
    public Message findByProIdOrCompareStatus(@RequestParam(value = "proDetailId",required = false,defaultValue = "-1") long proDetailId, @RequestParam(value = "compareStatus",required = false,defaultValue = "-1") int compareStatus){
        List<InquiryExtend> byProIdOrCompareStatus = inquiryServiceImpl.findByProIdOrCompareStatus(proDetailId, compareStatus);

        //List<Inquiry> inquiries = iInquiryServiceImpl.findByProIdOrCompareStatus(proDetailId,compareStatus);
        return MessageUtil.success("success", byProIdOrCompareStatus);
    }
    @ApiOperation("单个比价查询")
    @GetMapping("cascadeFindAllByParams")
    public Message cascadeFindAllByParams(long inquiryId, String name) {
        List<QuoteRespVM> quoteRespVMS = compareServiceImpl.cascadeFindAllByParams(inquiryId);

        Map map = new HashMap();
        map.put("name", name);
        map.put("inquiryCompareVMS", quoteRespVMS);
        List<Map> result = new ArrayList<>();
        result.add(map);
        return MessageUtil.success("success", result);
    }
    @ApiOperation("批量比价查询")
    @PostMapping("batchGetCompare")
    public Message batchGetCompare(@RequestBody CompareReqVM CompareReqVM) {
        List<?> result = compareServiceImpl.batchGetCompare(CompareReqVM);

        return MessageUtil.success("success", result);
    }
    @ApiOperation("比价选用")
    @PostMapping("completeCompare")
    public Message completeCompare(@RequestBody CompareRespVM compareRespVM) {
        compareServiceImpl.completeCompare(compareRespVM.getCheckCompareIds(), compareRespVM.getOtherCompareIds(), compareRespVM.getRemarks(), compareRespVM.getUserId());
        //compareServiceImpl.completeCompare(compareRespVM.getCheckCompareIds(), compareRespVM.getOtherCompareIds(), compareRespVM.getRemarks());
        return MessageUtil.success("操作成功");
    }
}
