package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.vm.BatchInquiryVM;
import com.xzx.xzxms.vm.InquiryVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

        List<InquiryWithBLOBs> inquiry = inquiryServiceImpl.findByProDetailId(id);
        return MessageUtil.success("success", inquiry);
    }

    @ApiOperation(value = "修改或是新增")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(@RequestBody InquiryVM inquiry){
        inquiryServiceImpl.saveOrUpdate(inquiry);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "批量置为无效")
    @PostMapping(value = "setInvalid")
    public Message setInvalid(long[] ids){
        inquiryServiceImpl.setInvalid(ids);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "批量删除")
    @PostMapping(value = "delete")
    public Message delete(long[] ids){
        inquiryServiceImpl.delete(ids);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "批量新增询价")
    @PostMapping(value = "batchAddInquiry")
    public Message batchAddInquiry(@RequestBody BatchInquiryVM batchInquiryVM){
        inquiryServiceImpl.batchAddInquiry(batchInquiryVM.getInquiryVMs());
        return MessageUtil.success("保存成功");
    }
}
