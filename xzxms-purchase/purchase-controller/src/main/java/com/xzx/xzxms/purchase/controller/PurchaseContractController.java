package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/purchase/contract")
public class PurchaseContractController {

    @Resource
    private IPurchaseContractService iPurchaseContractServiceImpl;


    @ApiOperation(value = "通过项目id进行查询")
    @GetMapping(value ="findByProjectId")
    public Message findByProjectId(Long projectId){
        List<PurchaseContract> list = iPurchaseContractServiceImpl.findByProjectId(projectId);
        return MessageUtil.success("success",list);
    }

    @ApiOperation(value = "通过id进行假删")
    @PostMapping(value = "deleteById")
    public Message deleteById(long id){
        iPurchaseContractServiceImpl.deleteById(id);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "新增或者修改")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(PurchaseContract purchaseContract){
        iPurchaseContractServiceImpl.saveOrUpdate(purchaseContract);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "根据合同编码进行模糊查询")
    @GetMapping(value = "findAllLikeByContractNo")
    public Message findAllLikeByContractNo(String contractNo){
        List<PurchaseContract> purchaseContracts = iPurchaseContractServiceImpl.findAllLikeByContractNo(contractNo);
        return MessageUtil.success("success",purchaseContracts);
    }

    @ApiOperation("修改供货价")
    @PostMapping("updateSupplyPrice")
    public Message updateSupplyPrice(@RequestBody PurchaseSupply purchaseSupply){
        iPurchaseContractServiceImpl.updateSupplyPrice(purchaseSupply);
        return MessageUtil.success("success");
    }
}
