package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.vm.PurchaseContractAndContractAttributeVM;
import com.xzx.xzxms.purchase.bean.vm.PurchaseItemsAndPurchaseSupplyVM;
import com.xzx.xzxms.purchase.service.IArrivalStatusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/purchase/arrivalStatus")
public class ArrivalStatusController {
    @Resource
    private IArrivalStatusService iArrivalStatusServiceImpl;

    @ApiOperation(value = "通过项目名查询合同号和付款形式")
    @GetMapping(value = "findContractNoAndFormOfPaymentByProjectName")
    public Message findContractNoAndFormOfPaymentByProjectName(String projectName){
        List<PurchaseContractAndContractAttributeVM> list =iArrivalStatusServiceImpl.findContractNoAndFormOfPaymentByProjectName(projectName);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "通过合同id查询合同下所有设备的到货情况")
    @GetMapping(value = "findArrivalStatusByContractId")
    public Message findArrivalStatusByContractId(long contractId){
        List<PurchaseItemsAndPurchaseSupplyVM> list = iArrivalStatusServiceImpl.findArrivalStatusByContractId(contractId);
        return MessageUtil.success("success", list);
    }
}
