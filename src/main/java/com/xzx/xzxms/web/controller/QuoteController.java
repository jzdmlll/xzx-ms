package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.extend.QuoteExtend;
import com.xzx.xzxms.bean.extend.QuoteExtendInquiry;
import com.xzx.xzxms.service.IQuoteService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
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
        List<Quote> quoteList = iQuoteServiceImpl.findByInquiryId(inquiryId);
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
    public Message findBySupplierOrPro(@RequestParam(value = "supplier",required = false) String supplier,@RequestParam(value = "proId",required = false,defaultValue = "-1") long proId){

        List<QuoteExtendInquiry> list = iQuoteServiceImpl.findBySupplierOrPro(supplier,proId);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("供应商报价批量置为无效")
    @PostMapping("batchSetInvalid")
    public Message batchSetInvalid(long[] ids){
        iQuoteServiceImpl.batchSetInvalid(ids);
        return MessageUtil.success("删除成功");
    }
}

