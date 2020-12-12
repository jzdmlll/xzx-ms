package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.ICompareService;
import com.xzx.xzxms.inquiry.service.IInquiryService;
import com.xzx.xzxms.inquiry.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.inquiry.vm.CompareReqVM;
import com.xzx.xzxms.inquiry.vm.CompareRespVM;
import com.xzx.xzxms.inquiry.vm.QuoteRespVM;
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
//        List<InquiryCompareExtend> byProIdOrCompareStatus = inquiryServiceImpl.findByProIdOrCompareStatus(proDetailId, compareStatus);
        List<InquiryAndProDetailExtend> byProIdOrCompareStatus = inquiryServiceImpl.findByProIdOrCompareStatus(proDetailId, compareStatus);

        return MessageUtil.success("success", byProIdOrCompareStatus);
    }

    @ApiOperation("单个比价查询")
    @GetMapping("cascadeFindAllByParams")
    public Message cascadeFindAllByParams(long inquiryId, String name) {
        List<QuoteRespVM> quoteRespVMS = compareServiceImpl.cascadeFindAllByParams(inquiryId);

        Map map = new HashMap();
        map.put("name", name);
        map.put("inquiryId", inquiryId);
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
        compareServiceImpl.completeCompare(compareRespVM.getCheckCompareIds(), compareRespVM.getOtherCompareIds(), compareRespVM.getRemarks(), compareRespVM.getUserId(), compareRespVM.getInquiries());
        //compareServiceImpl.completeCompare(compareRespVM.getCheckCompareIds(), compareRespVM.getOtherCompareIds(), compareRespVM.getRemarks());
        return MessageUtil.success("操作成功");
    }
}


