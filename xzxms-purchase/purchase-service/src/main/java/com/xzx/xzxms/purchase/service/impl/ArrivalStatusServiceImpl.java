package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.purchase.bean.vm.PurchaseContractAndContractAttributeVM;
import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndPurchaseSupplyVM;
import com.xzx.xzxms.purchase.dao.extend.ArrivalStatusExtendMapper;
import com.xzx.xzxms.purchase.service.IArrivalStatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArrivalStatusServiceImpl implements IArrivalStatusService {
    @Resource
    private ArrivalStatusExtendMapper arrivalStatusExtendMapper;
    @Override
    public List<PurchaseContractAndContractAttributeVM> findContractNoAndFormOfPaymentByProjectName(String projectName) {
        return arrivalStatusExtendMapper.findContractNoAndFormOfPaymentByProjectName(projectName);
    }

    @Override
    public List<PurchaseItemsAndPurchaseSupplyVM> findArrivalStatusByContractId(long contractId) {
        return arrivalStatusExtendMapper.findArrivalStatusByContractId(contractId);
    }
}
