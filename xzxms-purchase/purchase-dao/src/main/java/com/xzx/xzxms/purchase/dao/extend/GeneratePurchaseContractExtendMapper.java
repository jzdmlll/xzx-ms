package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndSupplyVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GeneratePurchaseContractExtendMapper {
    List<PurchaseItemsAndSupplyVM> findByProjectId(@Param("projectId") long projectId);
}
