package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.extend.QuoteExtend;
import com.xzx.xzxms.service.IQuoteService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(QuoteExtend quote) {
        iQuoteServiceImpl.saveOrUpdate(quote);
        return MessageUtil.success("操作成功");
    }
    @ApiOperation("批量插入报价")
    @GetMapping("batchAddQuote")
    public Message batchAddQuote(@RequestParam("file") MultipartFile uploadFile) {

        return MessageUtil.success("导入成功");
    }
}
