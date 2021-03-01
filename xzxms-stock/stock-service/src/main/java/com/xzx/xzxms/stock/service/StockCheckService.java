package com.xzx.xzxms.stock.service;/**
 * @Author sunny
 * @Date 2021/2/8 14:48
 * @Version 1.0
 */

import com.xzx.xzxms.stock.bean.StockCheck;
import com.xzx.xzxms.stock.vo.StockCheckVO;

import java.util.List;

/**
 *@ClassName StockCheckService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface StockCheckService {

    /**
     * 根据参数查询出验收信息
     * @param proId
     * @param contractId
     * @param startTime
     * @param endTime
     * @return
     */
    List<StockCheckVO> findStockCheck(Long proId, Long contractId, Long startTime, Long endTime);

    /**
     * 签收
     * @param stockChecks
     */
    void sign(StockCheck stockChecks);
}
