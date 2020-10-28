package com.xzx.xzxms.web.controller;
import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.vm.BatchInquiryVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
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

    @ApiOperation("行内编辑保存")
    @PostMapping("rowSave")
    public Message rowSave(@RequestBody Inquiry inquiry) {
        iInquiryServiceImpl.rowSave(inquiry);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation("查询所有询价")
    @GetMapping("findAll")
    public Message findAll() {
        List<Inquiry> inquiryList = iInquiryServiceImpl.findAll();
        return MessageUtil.success("success", inquiryList);
    }

    @ApiOperation(value = "批量新增询价")
    @PostMapping(value ="batchAddInquiry" )
    public Message batchAddInquiry(@RequestBody BatchInquiryVM inquiries){
        try {
            iInquiryServiceImpl.batchAddInquiry(inquiries.getInquiryList());
        } catch (SQLException e) {
            throw new CustomerException("sql异常");
        }
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value="批量删除询价内容")
    @PostMapping(value="batchSetInvalid")
    public Message batchSetInvalid(long[] ids){

        iInquiryServiceImpl.batchSetInvalid(ids);
        return MessageUtil.success("success");
    }

}
