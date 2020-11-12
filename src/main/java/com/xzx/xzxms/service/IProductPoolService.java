package com.xzx.xzxms.service;
import com.xzx.xzxms.bean.ProPool;
import java.util.List;

public interface IProductPoolService {

    /**
     * 修改
     * @param proPool
     */
    void updateMessage(ProPool proPool);

    /**
     * 查询
     * @param name
     * @param brand 品牌
     //* @param choose 选用标识
     * @return
     */
    List<ProPool> findByParams(String name, String brand);

    /**
     * 批量置为无效（假删）
     * @param ids
     */
    void batchSetInvalid(long[] ids);

    /**
     * 查询历史报价和成本价
     * @param name（设备名）
     * @return
     */
    List<ProPool> findHistoryPrices(String name);
}
