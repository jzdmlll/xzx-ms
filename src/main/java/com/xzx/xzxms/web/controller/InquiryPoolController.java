package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.InquiryPool;
import com.xzx.xzxms.service.IInquiryPoolService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
