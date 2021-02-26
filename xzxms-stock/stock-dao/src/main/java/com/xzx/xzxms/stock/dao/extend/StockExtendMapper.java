package com.xzx.xzxms.stock.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/25 19:18
 * @Version 1.0
 */

import org.apache.ibatis.annotations.Mapper;

/**
 *@ClassName StockExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Mapper
public interface StockExtendMapper {

    /**
     * 根据采购项ID查询库存数量
     * @param itemId
     * @return
     */
    Double findStockNumberByItemId(Long itemId);
}
