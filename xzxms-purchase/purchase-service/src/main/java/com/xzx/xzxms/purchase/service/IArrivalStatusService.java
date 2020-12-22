package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.vm.PurchaseContractAndContractAttributeVM;
import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndPurchaseSupplyVM;

import java.util.List;

public interface IArrivalStatusService {
    /**
     * 通过项目名查询合同号和付款形式
     * @param projectName
     * @return
     */
    List<PurchaseContractAndContractAttributeVM> findContractNoAndFormOfPaymentByProjectName(String projectName);

    /**
     * 通过合同id查询合同下所有设备的到货情况
     * @param contractId
     * @return
     */
    List<PurchaseItemsAndPurchaseSupplyVM> findArrivalStatusByContractId(long contractId);
}
