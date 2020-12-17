package com.xzx.xzxms.inquiry.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.service.IQuoteService;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.bean.extend.QuoteExtend;
import com.xzx.xzxms.inquiry.bean.extend.QuoteExtendInquiry;
import com.xzx.xzxms.inquiry.bean.extend.QuoteProCheckExtend;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Resource
    private IQuoteService iQuoteServiceImpl;

    @ApiOperation("查询一条询价下的所有报价")
    @GetMapping("findByInquiryId")
    public Message findByProDetailId(long inquiryId) {
        List<QuoteProCheckExtend> quoteList = iQuoteServiceImpl.findByInquiryId(inquiryId);
        return MessageUtil.success("success", quoteList);
    }

    @ApiOperation("新增或修改报价")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(@RequestBody QuoteExtend quote) {
        iQuoteServiceImpl.saveOrUpdate(quote);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("批量插入报价")
    @PostMapping("batchAddQuote")
    public Message batchAddQuote(@RequestBody QuoteExtend quote) {
        try {
            iQuoteServiceImpl.batchAddQuote(quote);
        } catch (IOException e) {
            throw new CustomerException("导入失败，原因："+e.getMessage());
        }
        return MessageUtil.success("导入成功");
    }

    @ApiOperation("行内编辑保存")
    @PostMapping("rowSave")
    public Message rowSave(@RequestBody Quote quote) {
        iQuoteServiceImpl.rowSave(quote);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation("供应商报价查询/项目报价查询")
    @GetMapping("findBySupplierOrPro")
    public Message findBySupplierOrPro(@RequestParam(value = "supplier",required = false) String supplier,
                                       @RequestParam(value = "proId",required = false,defaultValue = "-1") long proId,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "50")int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<QuoteExtendInquiry> list = iQuoteServiceImpl.findBySupplierOrPro(supplier,proId);
        PageInfo<QuoteExtendInquiry> pageInfo = new PageInfo<>(list);
        return MessageUtil.success("success",pageInfo);
    }

    @ApiOperation("供应商报价批量置为无效")
    @PostMapping("batchSetInvalid")
    public Message batchSetInvalid(long[] ids){

        iQuoteServiceImpl.batchSetInvalid(ids);
        return MessageUtil.success("删除成功");
    }

/*    @ApiOperation("无需询价的在产品池中选用供应商")
    @GetMapping("chooseProductPoolSupplier")
    public Message chooseProductPoolSupplier(long inquiryId, long productPoolId, long operator){

        iQuoteServiceImpl.chooseProductPoolSupplier(inquiryId,productPoolId,operator);
        return MessageUtil.success("选用成功");
    }*/

    @ApiOperation("新增报价")
    @PostMapping("addQuote")
    public Message addQuote(Quote quote){

        iQuoteServiceImpl.addQuote(quote);
        return MessageUtil.success("success");
    }

    @ApiOperation("报价单个删除")
    @GetMapping("quoteSetInvalid")
    public Message quoteSetInvalid(long id){

        iQuoteServiceImpl.quoteSetInvalid(id);
        return MessageUtil.success("success");
    }

    @ApiOperation("报价手动发起审核")
    @GetMapping("initiateAudit")
    public Message initiateAudit(long inquiryId){

        iQuoteServiceImpl.initiateAudit(inquiryId);
        return MessageUtil.success("送审成功");
    }

    @ApiOperation("报价手动发往比价")
    @GetMapping("sendCompare")
    public Message sendCompare(long inquiryId){

        iQuoteServiceImpl.sendCompare(inquiryId);
        return MessageUtil.success("比价发送成功");
    }

    @ApiOperation("根据项目详情ID查询出所有询价需求")
    @GetMapping("findInquiryByProDetailId")
    public Message findInquiryByProDetailId(long proDetailId){

        List<Inquiry> inquiryByProDetailId = iQuoteServiceImpl.findInquiryByProDetailId(proDetailId);
        return MessageUtil.success("查询成功", inquiryByProDetailId);
    }


}

