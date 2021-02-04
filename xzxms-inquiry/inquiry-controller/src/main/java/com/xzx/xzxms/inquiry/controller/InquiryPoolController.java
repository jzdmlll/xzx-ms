package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.IInquiryPoolService;
import com.xzx.xzxms.inquiry.bean.InquiryPool;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/inquiryPool")
public class InquiryPoolController {

    @Resource
    private IInquiryPoolService inquiryPoolServiceImpl;

    @ApiOperation(value = "查询")
    @GetMapping(value = "findByParams")
    public Message findByParams(@RequestParam(value="name", required=false, defaultValue = "")String name,
                                @RequestParam(value="brand", required=false, defaultValue = "")String brand,
                                @RequestParam(value="proDetailId", required=false, defaultValue = "")Long proDetailId,
                                @RequestParam(value="model", required=false, defaultValue = "")String model){
        List<InquiryPool> list = inquiryPoolServiceImpl.findByParams(name, brand, proDetailId, model);
        return MessageUtil.success("success", list);
    }

}
