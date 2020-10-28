package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.extend.QuoteExtend;
import com.xzx.xzxms.bean.extend.QuoteExtendInquiry;

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
     * @param quote 项目详情id和文件内容
     */
    void batchAddQuote(QuoteExtend quote) throws IOException;
    /**
     * 行内编辑保存
     * @param quote
     */
    void rowSave(Quote quote);

    /**
     * 供应商报价查询/项目报价查询
     * @return
     */
    List<QuoteExtendInquiry> findBySupplierOrPro(String supplier,long proId);

    /**
     * 批量置为无效（假删）
     * @param ids
     */
    void batchSetInvalid(long[] ids);
}
