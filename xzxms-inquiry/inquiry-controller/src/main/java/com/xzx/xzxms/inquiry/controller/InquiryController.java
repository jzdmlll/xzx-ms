package com.xzx.xzxms.inquiry.controller;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.IInquiryService;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.extend.InquiryExtend;
import com.xzx.xzxms.inquiry.vm.BatchInquiryVM;
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
    public Message findByProDetailId(@RequestParam(value="name", required=false, defaultValue = "")String name,
                                     @RequestParam(value="proDetailId", required=false, defaultValue = "")Long proDetailId,
                                     @RequestParam(value="model", required=false, defaultValue = "")String model) {
        List<InquiryExtend> inquiryList = iInquiryServiceImpl.findByProDetailId(proDetailId, name, model);

        return MessageUtil.success("success", inquiryList);
    }

    @ApiOperation("行内编辑保存")
    @PostMapping("rowSave")
    public Message rowSave(@RequestBody Inquiry inquiry) {

        iInquiryServiceImpl.rowSave(inquiry);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation("终审修改拟定报价")
    @PostMapping("finallyUpdateDraft")
    public Message finallyUpdateDraft(@RequestBody Inquiry inquiry){

        iInquiryServiceImpl.finallyUpdateDraft(inquiry);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("查询所有询价")
    @GetMapping("findAll")
    public Message findAll() {
        List<InquiryExtend> inquiryList = iInquiryServiceImpl.findAll();
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
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "批量置为不询价")
    @PostMapping(value = "batchSetIsNotInquiry")
    public Message batchSetIsNotInquiry(long[] ids, Integer status){

        iInquiryServiceImpl.batchSetIsNotInquiry(ids, status);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "此条询价被否决")
    @GetMapping(value = "setVeto")
    public Message setVeto(long id){

        iInquiryServiceImpl.setVeto(id);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "此条询价选用此条产品池数据")
    @PostMapping(value = "inquiryChoosePool")
    public Message inquiryChoosePool(long inquiryId, long proPoolId, long operator){

        iInquiryServiceImpl.inquiryChoosePool(inquiryId,proPoolId,operator);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "重新询价")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(Inquiry inquiry){

        iInquiryServiceImpl.insertOrUpdateInquiry(inquiry);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "新增或修改询价设备类型")
    @PostMapping(value = "modifyDeviceType")
    public Message modifyDeviceType(long[] inquiryIds, Long code){
        iInquiryServiceImpl.modifyDeviceType(inquiryIds, code);
        return MessageUtil.success("success");
    }
}
