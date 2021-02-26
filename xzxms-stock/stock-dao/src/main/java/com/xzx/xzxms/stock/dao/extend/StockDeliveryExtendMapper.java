package com.xzx.xzxms.stock.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/25 9:36
 * @Version 1.0
 */

import com.xzx.xzxms.stock.vo.StockDeliveryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *@ClassName StockDeliveryExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Mapper
public interface StockDeliveryExtendMapper {

    /**
     * 根据参数查询出库信息
     * @param item
     * @return
     */
    List<StockDeliveryVO> findDeliveryByParams(String item);

}
