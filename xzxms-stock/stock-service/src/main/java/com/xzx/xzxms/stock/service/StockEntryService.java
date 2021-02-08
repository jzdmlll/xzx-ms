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
     * 查询出入库信息
     * @param item
     * @return
     */
    List<StockEntryVO> findEntryByParams(String item);

    /**
     * 批量入库
     * @param stockEntries
     */
    void entry(List<StockEntry> stockEntries);
}
