package com.xzx.xzxms.stock.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/25 9:34
 * @Version 1.0
 */

import com.xzx.xzxms.stock.vo.StockEntryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@ClassName StockEntryExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Mapper
public interface StockEntryExtendMapper {

    /**
     * 根据参数查询入库信息
     * @param item
     * @param contractId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<StockEntryVO> findEntryByParams(@Param("item") String item, @Param("contractId") String contractId, @Param("beginTime") String beginTime, @Param("endTime") String endTime);

    /**
     * 在入库表中查询已入库数量
     * @param itemId
     * @return
     */
    Double storedNum(@Param("itemId") Long itemId);
}
