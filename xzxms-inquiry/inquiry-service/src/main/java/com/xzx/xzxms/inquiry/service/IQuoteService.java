package com.xzx.xzxms.inquiry.service;

import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.bean.extend.QuoteExtend;
import com.xzx.xzxms.inquiry.bean.extend.QuoteExtendInquiry;
import com.xzx.xzxms.inquiry.bean.extend.QuoteProCheckExtend;
import com.xzx.xzxms.inquiry.vm.FinallyQuoteInquiryVM;
import com.xzx.xzxms.inquiry.vm.InquiryVM;

import java.io.IOException;
import java.util.List;

public interface IQuoteService {
    /**
     * 查询一条询价下的所有报价
     * @param inquiryId 询价id
     * @return 所有报价
     */
    List<QuoteProCheckExtend> findByInquiryId(long inquiryId);
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
    List<QuoteExtendInquiry> findBySupplierOrPro(String supplier, long proId);

    /**
     * 批量置为无效（假删）
     * @param ids
     */
    void batchSetInvalid(long[] ids);

    /**
     * 单个置为无效（删除）
     * @param id
     */
    void quoteSetInvalid(long id);

    /**
     * 选择产品池中的供应商（不需询价的内容）
     * @param inquiryId 询价ID
     * @param productPoolId 产品池ID
     */
    void chooseProductPoolSupplier(long inquiryId, long productPoolId, long operator);

    /**
     * 新增报价
     * @param quote 报价对象
     */
    void addQuote(Quote quote);

    /**
     * 报价发起审核
     * @param inquiryId 询价ID
     */
    void initiateAudit(long inquiryId);

    /**
     * 报价发送比价
     * @param inquiryId
     */
    void sendCompare(long inquiryId);
}
