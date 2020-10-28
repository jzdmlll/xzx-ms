package com.xzx.xzxms.web.controller;


import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CompareController {

    @Resource
    private IInquiryService iInquiryServiceImpl;

    @ApiOperation("根据项目或比价状态查询")
    @GetMapping("findByProIdOrCompareStatus")
    public Message findByProIdOrCompareStatus(@RequestParam(value = "proDetailId",required = false,defaultValue = "-1") long proDetailId, @RequestParam(value = "compareStatus",required = false,defaultValue = "-1") Integer compareStatus){

        List<Inquiry> inquirys = iInquiryServiceImpl.findByProIdOrCompareStatus(proDetailId,compareStatus);
        return MessageUtil.success("success",inquirys);
    }
}
