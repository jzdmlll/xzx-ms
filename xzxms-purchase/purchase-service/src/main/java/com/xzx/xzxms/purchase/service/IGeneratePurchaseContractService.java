package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndSupplyVM;
import java.util.List;

public interface IGeneratePurchaseContractService {

    /**
     *通过项目id查询生成采购合同的内容
     * @param projectId
     * @return
     */
    List<PurchaseItemsAndSupplyVM> findItemsAndSupplyByProjectId(long projectId);
}
