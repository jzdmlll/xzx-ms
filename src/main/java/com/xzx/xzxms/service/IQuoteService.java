package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.extend.QuoteExtend;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IQuoteService {
    /**
     * 查询一条询价下的所有报价
     * @param inquiryId 询价id
     * @return 所有报价
     */
    List<Quote> findByInquiryId(long inquiryId);

    /**
     * 新增或更改报价内容
     * @param quote
     */
    void saveOrUpdate(QuoteExtend quote);
    /**
     * 批量新增报价
     * @param uploadFile 报价文件
     */
    void batchAddQuote(MultipartFile uploadFile) throws IOException;
}
