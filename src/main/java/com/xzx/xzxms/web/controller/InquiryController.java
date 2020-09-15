package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {

    @Resource
    private IInquiryService inquiryServiceImpl;

    @ApiOperation(value = "根据项目详情ID查询对应的所有询价内容")
    @GetMapping(value = "findByDetailId")
    public Message findByDetailId(long id){

        List<Inquiry> inquiry = inquiryServiceImpl.findByProDetailId(id);
        return MessageUtil.success("success",inquiry);
    }

    @ApiOperation(value = "修改或是新增")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(InquiryWithBLOBs inquiry){
        inquiryServiceImpl.saveOrUpdate(inquiry);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "批量置为无效")
    @PostMapping(value = "setInvalid")
    public Message setInvalid(long[] ids){
        inquiryServiceImpl.setInvalid(ids);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "批量删除")
    @PostMapping(value = "delete")
    public Message delete(long[] ids){
        inquiryServiceImpl.delete(ids);
        return MessageUtil.success("success");
    }
}
