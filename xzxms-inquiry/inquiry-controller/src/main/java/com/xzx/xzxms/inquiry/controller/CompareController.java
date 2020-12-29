package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.service.ICompareService;
import com.xzx.xzxms.inquiry.service.IInquiryService;
import com.xzx.xzxms.inquiry.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.inquiry.vm.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

        //compareServiceImpl.completeCompare(compareRespVM.getCheckCompareIds(), compareRespVM.getOtherCompareIds(), compareRespVM.getRemarks(), compareRespVM.getUserId(), compareRespVM.getInquiries());
        //compareServiceImpl.completeCompare(compareRespVM.getCheckCompareIds(), compareRespVM.getOtherCompareIds(), compareRespVM.getRemarks());
        throw new CustomerException("该接口维护中，无法使用");
    }

    @ApiOperation("根据项目详情ID查询出所有询价需求")
    @GetMapping("findInquiryByProDetailId")
    public Message findInquiryByProDetailId(long proDetailId){

        List<InquiryVM> list = compareServiceImpl.findInquiryByProDetailId(proDetailId);
        return MessageUtil.success("查询成功",list);
    }

    @ApiOperation("根据询价ID查询出比价")
    @PostMapping("findQuoteByInquiryId")
    public Message findQuoteByInquiryId(long[] inquiryIds){

        List<CompareQuoteListVM> list = compareServiceImpl.findQuoteByInquiryId(inquiryIds);
        return MessageUtil.success("查询成功",list);
    }

    @ApiOperation("设置项目下所有询价的利率")
    @PostMapping("setInquiryRate")
    public Message setInquiryRate(long proDetailId, Double rate){

        compareServiceImpl.setInquiryRate(proDetailId, rate);
        return MessageUtil.success("设置成功");
    }

    @ApiOperation("比价修改拟定报价")
    @PostMapping("compareUpdateDraft")
    public Message compareUpdateDraft(@RequestBody InquirySuPriceVM inquirySuPriceVM){
        compareServiceImpl.compareUpdateDraft(inquirySuPriceVM);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("比价结果提交")
    @PostMapping("compareResultCommit")
    public Message compareResultCommit(@RequestBody CompareVM compareVM){
        compareServiceImpl.compareResultCommit(compareVM);
        return MessageUtil.success("操作成功");
    }
}


