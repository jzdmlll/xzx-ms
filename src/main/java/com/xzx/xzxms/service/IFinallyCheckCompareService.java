package com.xzx.xzxms.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IFinallyCheckCompareService {

    /***
     * 根据项目详情ID或比价状态查询出询价结果
     * @param proDetailId 项目详情ID
     * @param compareStatus 比价状态
     * @return
     */
    List<Map> FindDraftComparePrice(long proDetailId,int compareStatus);
}
