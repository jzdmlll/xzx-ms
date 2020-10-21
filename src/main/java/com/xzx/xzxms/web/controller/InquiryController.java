package com.xzx.xzxms.web.controller;
import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {
    @Resource
    private IInquiryService iInquiryServiceImpl;

    @ApiOperation("根据项目id查询所有询价")
    @GetMapping("findByProDetailId")
    public Message findByProDetailId(long proDetailId) {
        List<Inquiry> inquiryList = iInquiryServiceImpl.findByProDetailId(proDetailId);

        return MessageUtil.success("success", inquiryList);
    }


}
