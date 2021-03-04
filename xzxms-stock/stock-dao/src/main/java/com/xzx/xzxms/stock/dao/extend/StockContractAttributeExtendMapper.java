package com.xzx.xzxms.stock.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseContract;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/3/4 10:53
 * @Version 1.0
 */
public interface StockContractAttributeExtendMapper {
    /**
     * 根据项目Id查询设置过属性的合同
     * @param projectId
     * @return
     */
    List<PurchaseContract> findContractHasContractAttributeByProId(Long projectId);
}
