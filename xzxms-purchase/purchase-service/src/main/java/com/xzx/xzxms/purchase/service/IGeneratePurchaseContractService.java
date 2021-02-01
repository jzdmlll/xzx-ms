package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndSupplyVM;
import java.util.List;

public interface IGeneratePurchaseContractService {

    /**
     *通过项目id查询生成采购合同的内容
     * @param projectIds
     * @param name
     * @return
     */
    List<PurchaseItemsAndSupplyVM> findItemsAndSupplyByProjectId(Long[] projectIds, String name);
}
