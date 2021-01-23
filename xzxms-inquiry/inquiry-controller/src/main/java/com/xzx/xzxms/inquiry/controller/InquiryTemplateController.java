package com.xzx.xzxms.inquiry.controller;/**
 * @Author sunny
 * @Date 2021/1/23 20:06
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.bean.InquiryTemplate;
import com.xzx.xzxms.inquiry.bean.InquiryTemplateWithBLOBs;
import com.xzx.xzxms.inquiry.service.IInquiryTemplateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName InquiryTemplateController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@RestController
@RequestMapping("/template")
public class InquiryTemplateController {

    @Resource
    private IInquiryTemplateService iInquiryTemplateServiceImpl;

    @ApiOperation(value = "查")
    @GetMapping(value = "findInquiryTemplate")
    public Message findInquiryTemplate(Long id){
        List<InquiryTemplateWithBLOBs> list = iInquiryTemplateServiceImpl.findInquiryTemplate(id);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "询价模板新增")
    @PostMapping(value = "insertInquiryTemplate")
    public Message insertInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs){
        iInquiryTemplateServiceImpl.insertInquiryTemplate(inquiryTemplateWithBLOBs);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "询价模板修改")
    @PostMapping(value = "updateInquiryTemplate")
    public Message updateInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs){
        iInquiryTemplateServiceImpl.updateInquiryTemplate(inquiryTemplateWithBLOBs);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "删")
    @PostMapping(value = "setInvalidInquiryTemplate")
    public Message setInvalidInquiryTemplate(InquiryTemplate inquiryTemplate){
        iInquiryTemplateServiceImpl.setInvalidInquiryTemplate(inquiryTemplate);
        return MessageUtil.success("success");
    }
}
