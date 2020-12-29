package com.xzx.xzxms.inquiry.service;

import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.vm.*;

import java.util.List;
import java.util.Map;

public interface ICompareService {
    /**
     * 单个比价查询
     * @param inquiryId
     * @return
     */
    List<QuoteRespVM> cascadeFindAllByParams(long inquiryId);

    /**
     * 批量比价查询
     * @param compareReqVM
     * @return
     */
    List<?> batchGetCompare(CompareReqVM compareReqVM);

    /**
     * 比价选用
     * @param checkCompareIds
     * @param otherCompareIds
     * @param remarks
     */
    void completeCompare(long[] checkCompareIds, long[] otherCompareIds, List<Map> remarks, long userId, List<Map> inquiries);

    /**
     * 设置项目下所有询价的利率
     * @param proDetailId
     * @param rate
     */
    void setInquiryRate(long proDetailId,Double rate);

    /**
     * 根据项目详情ID查询出所有询价需求
     * @param proDetailId
     */
    List<InquiryVM> findInquiryByProDetailId(long proDetailId);

    /**
     * 根据询价ID查询出比价
     * @param inquiryIds
     * @return
     */
    List<CompareQuoteListVM> findQuoteByInquiryId(long[] inquiryIds);

    /**
     * 比价修改拟定报价
     * @param inquirySuPriceVM
     */
    void compareUpdateDraft(InquirySuPriceVM inquirySuPriceVM);

    /**
     * 比价结果提交
     * @param compareVM
     */
    void compareResultCommit(CompareVM compareVM);
}
