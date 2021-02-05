package com.xzx.xzxms.equipment.controller;/**
 * @Author sunny
 * @Date 2021/2/4 14:40
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.equipment.bean.EquipmentActualAccount;
import com.xzx.xzxms.equipment.service.ActualAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName EquipmentActualAccount
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@RestController
@RequestMapping("/equipment/equipmentActualAccount")
public class EquipmentActualAccountController {

    @Resource
    private ActualAccountService actualAccountServiceImpl;

    @ApiOperation(value = "查询实际付款记录")
    @GetMapping(value = "findActualAccountByContractId")
    public Message findActualAccountByContractId(Long contractId){

        List<EquipmentActualAccount> list = actualAccountServiceImpl.findActualAccountByContractId(contractId);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "添加实际付款情况")
    @PostMapping(value = "addActualAccount")
    public Message addActualAccount(EquipmentActualAccount equipmentActualAccount){

        actualAccountServiceImpl.addActualAccount(equipmentActualAccount);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "实际付款记录置为无效")
    @PostMapping(value = "setInvalidActualAccount")
    public Message setInvalidActualAccount(EquipmentActualAccount equipmentActualAccount){

        actualAccountServiceImpl.setInvalidActualAccount(equipmentActualAccount);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "根据合同ID查询已付款总金额")
    @GetMapping(value = "setInvalidActualAccount")
    public Message statisticsActualAccountByContractId(Long contractId){

        Double money = actualAccountServiceImpl.statisticsActualAccountByContractId(contractId);
        return MessageUtil.success("success", money);
    }
}
