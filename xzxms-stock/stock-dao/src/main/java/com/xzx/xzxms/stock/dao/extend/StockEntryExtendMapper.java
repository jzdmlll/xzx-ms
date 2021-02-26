package com.xzx.xzxms.stock.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/25 9:34
 * @Version 1.0
 */

import com.xzx.xzxms.stock.vo.StockEntryVO;
import org.apache.ibatis.annotations.Mapper;

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
     * @return
     */
    List<StockEntryVO> findEntryByParams(String item);
}
