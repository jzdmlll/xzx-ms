package com.xzx.xzxms.stock.service;/**
 * @Author sunny
 * @Date 2021/2/18 10:02
 * @Version 1.0
 */

import com.xzx.xzxms.stock.bean.StockDelivery;
import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.vo.StockDeliveryVO;

import java.util.List;

/**
 *@ClassName StockDeliveryService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface StockDeliveryService {

    /**
     * 查询出库记录
     * @param item
     * @return
     */
    List<StockDeliveryVO> findDeliveryByParams(String item);

    /**
     * 批量出库
     * @param stockDeliveries
     */
    void batchDelivery(List<StockDelivery> stockDeliveries);

    /**
     * 单个出库
     * @param stockDelivery
     */
    void signalDelivery(StockDelivery stockDelivery);
}
