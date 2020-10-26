package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Quote;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IQuoteService {
    /**
     * 查询一条询价下的所有报价
     * @param inquiryId 询价id
     * @return 所有报价
     */
    List<Quote> findByInquiryId(long inquiryId);

    /**
     * 解析excel传来的数据
     * @param excelData Quote报价单excel数据
     */
    void ImportExcelQuote(MultipartFile excelData);
}
