package com.xzx.xzxms.stock.service;/**
 * @Author sunny
 * @Date 2021/2/8 16:59
 * @Version 1.0
 */

import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.vo.StockEntryVO;

import java.util.List;

/**
 *@ClassName StockEntryService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface StockEntryService {

    /**
     * 查询入库信息
     * @param item
     * @param contractId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<StockEntryVO> findEntryByParams(String item, String contractId, String beginTime, String endTime);

    /**
     * 批量入库
     * @param stockEntries
     */
    void batchEntry(List<StockEntry> stockEntries);

    /**
     * 单个入库
     * @param stockEntry
     */
    void signalEntry(StockEntry stockEntry);

    /**
     * 批量入库撤销
     * @param stockEntries
     */
    void revokeBatchEntry(List<StockEntry> stockEntries);

    /**
     * 单个入库撤销
     * @param stockEntry
     */
    void revokeSignalEntry(StockEntry stockEntry);

    /**
     * 单个入库数量修改
     * @param stockEntry
     */
    void updateEntryNumber(StockEntry stockEntry);
}
