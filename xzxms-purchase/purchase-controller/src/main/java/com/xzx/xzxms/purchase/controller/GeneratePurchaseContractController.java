package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndSupplyVM;
import com.xzx.xzxms.purchase.service.IGeneratePurchaseContractService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/purchase/generatePurchaseContract")
public class GeneratePurchaseContractController {
    @Resource
    private IGeneratePurchaseContractService iGeneratePurchaseContractServiceImpl;

    @ApiOperation(value = "通过项目id查询采购项及供货")
    @GetMapping(value = "findItemsAndSupplyByProjectId")
    public Message findItemsAndSupplyByProjectId(long projectId){
        List<PurchaseItemsAndSupplyVM> purchaseItemsAndSupplyVMS = iGeneratePurchaseContractServiceImpl.findItemsAndSupplyByProjectId(projectId);
        return MessageUtil.success("success",purchaseItemsAndSupplyVMS);
    }


}
