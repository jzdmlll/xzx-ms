package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Quote;

import java.util.List;

public interface IQuoteService {
    /**
     * 查询一条询价下的所有报价
     * @param inquiryId 询价id
     * @return 所有报价
     */
    List<Quote> findByInquiryId(long inquiryId);
}
