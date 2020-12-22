package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.vm.PurchaseContractAndContractAttributeVM;
import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndPurchaseSupplyVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArrivalStatusExtendMapper {
    /**
     * 通过项目名查询合同号和付款形式
     * @param projectName
     * @return
     */
    List<PurchaseContractAndContractAttributeVM> findContractNoAndFormOfPaymentByProjectName(@Param("projectName") String projectName);

    /**
     * 通过合同id查询合同下所有设备的到货情况
     * @param contractId
     * @return
     */
    List<PurchaseItemsAndPurchaseSupplyVM> findArrivalStatusByContractId(@Param("contractId") long contractId);
}
