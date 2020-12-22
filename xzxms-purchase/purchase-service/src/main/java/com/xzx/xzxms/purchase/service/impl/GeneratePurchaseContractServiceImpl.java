package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndSupplyVM;
import com.xzx.xzxms.purchase.dao.extend.GeneratePurchaseContractExtendMapper;
import com.xzx.xzxms.purchase.service.IGeneratePurchaseContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GeneratePurchaseContractServiceImpl implements IGeneratePurchaseContractService {
    @Resource
    private GeneratePurchaseContractExtendMapper generatePurchaseContractExtendMapper;
    @Override
    public List<PurchaseItemsAndSupplyVM> findItemsAndSupplyByProjectId(long projectId) {
        List<PurchaseItemsAndSupplyVM> purchaseItemsAndSupplyVMS = generatePurchaseContractExtendMapper.findByProjectId(projectId);
        return purchaseItemsAndSupplyVMS;
    }
}
