package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.vm.CompareReqVM;
import com.xzx.xzxms.vm.InquiryCompareVM;

import java.util.List;

public interface ICompareService {
    /**
     * 级联查询询价信息
     * @param compareStatus 增加比价状态查询条件
     * @param proDetailId 增加项目id查询条件
     * @return
     */
    List<InquiryCompareVM> cascadeFindAll(int compareStatus, long proDetailId);

    /**
     * 级联查询比价信息
     * @param proDetailId 增加项目id查询条件
     * @param name 增加询价name查询条件
     * @return
     */
    List<InquiryCompareVM> cascadeFindAllByParams(long proDetailId, String name);

    /**
     * 完成一条比价
     * @param compareId 选用
     * @param otherCompareId 未选用
     */
    void completeCompare(long compareId, long[] otherCompareId);

    /**
     * 批量获取比价信息
     * @param compareReqVM
     */
    List<?> batchGetCompare(CompareReqVM compareReqVM);
}
