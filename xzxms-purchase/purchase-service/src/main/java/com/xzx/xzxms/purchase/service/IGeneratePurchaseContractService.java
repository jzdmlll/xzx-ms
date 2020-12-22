package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndSupplyVM;
import java.util.List;

public interface IGeneratePurchaseContractService {

    /**
     *
     * @param projectId
     * @return
     */
    List<PurchaseItemsAndSupplyVM> findItemsAndSupplyByProjectId(long projectId);
}
