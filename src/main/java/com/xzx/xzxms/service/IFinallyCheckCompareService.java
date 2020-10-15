package com.xzx.xzxms.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IFinallyCheckCompareService {

    /***
     * 根据项目详情ID或比价状态查询出询价结果
     * @param proDetailId 项目详情ID
     * @param checkName 审核名称
     * @return
     */
    List<Map> FindDraftComparePrice(long proDetailId,String checkName);

    /**
     * 保存最终审核通过的询价内容信息
     * @param checkCompareIds 确认审核通过的比价ID
     * @param unCheckCompareIds 确认审核不通过的比价ID
     * @param allInquiryIds 所有询价内容ID
     * @param userId 操作用户id
     * @param roleId 操作用户角色id
     */
    void saveFinallyCheckMessage(long[] checkCompareIds,long[] unCheckCompareIds,long[] allInquiryIds,long userId,long roleId);
}
