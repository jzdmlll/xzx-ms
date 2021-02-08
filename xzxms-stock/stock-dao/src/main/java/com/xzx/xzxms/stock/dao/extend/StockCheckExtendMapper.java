package com.xzx.xzxms.stock.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/8 15:02
 * @Version 1.0
 */

import com.xzx.xzxms.stock.vo.StockCheckVO;

import java.util.List;

/**
 *@ClassName StockCheckExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface StockCheckExtendMapper {

    /**
     * 查询签收
     * @param proId
     * @param contractId
     * @param startTime
     * @param endTime
     * @return
     */
    List<StockCheckVO> findStockCheckByParams(Long proId, Long contractId, Long startTime, Long endTime);
}
