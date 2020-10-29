package com.xzx.xzxms.web.controller;


import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/compare")
public class CompareController {

    @Resource
    private IInquiryService iInquiryServiceImpl;

    @ApiOperation("根据项目或比价状态查询")
    @GetMapping("findByProIdOrCompareStatus")
    public Message findByProIdOrCompareStatus(@RequestParam(value = "proDetailId",required = false,defaultValue = "-1") long proDetailId, @RequestParam(value = "compareStatus",required = false,defaultValue = "-1") int compareStatus){

        List<Inquiry> inquiries = iInquiryServiceImpl.findByProIdOrCompareStatus(proDetailId,compareStatus);
        return MessageUtil.success("success", inquiries);
    }

    @GetMapping("cascadeFindAllByParams")
    public Message cascadeFindAllByParams(long inquiryId) {
        /*List<InquiryCompareVM> inquiryCompareVMS = compareServiceImpl.cascadeFindAllByParams(proDetailId, name, params);
        // 数据格式：[{name: "", inquiryCompareVMS: List<inquiryCompareVMS>},{...}]
        // inquiryCompareVMS：[{...},{...}]
        Map map = new HashMap();
        map.put("name", name);
        map.put("inquiryCompareVMS", inquiryCompareVMS);
        List<Map> result = new ArrayList<>();
        result.add(map);*/
        return MessageUtil.success("success");
    }
}
