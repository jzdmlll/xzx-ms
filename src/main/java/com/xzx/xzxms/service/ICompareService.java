package com.xzx.xzxms.service;

import com.xzx.xzxms.vm.CompareReqVM;
import com.xzx.xzxms.vm.QuoteRespVM;

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
}
