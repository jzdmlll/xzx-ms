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

    /**
     *通过项目id查询生成采购合同的内容
     * @param projectIds
     * @param name
     * @return
     */
    @Override
    public List<PurchaseItemsAndSupplyVM> findItemsAndSupplyByProjectId(Long[] projectIds, String name) {

        List<PurchaseItemsAndSupplyVM> purchaseItemsAndSupplyVMS = generatePurchaseContractExtendMapper.findByProjectId(projectIds, name);
        return purchaseItemsAndSupplyVMS;
    }
}
