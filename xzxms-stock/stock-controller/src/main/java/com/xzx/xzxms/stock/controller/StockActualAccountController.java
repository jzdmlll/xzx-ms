package com.xzx.xzxms.stock.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.bean.StockActualAccount;
import com.xzx.xzxms.stock.service.StockActualAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收发存模块 合同实付款表 控制器
 * @Author Lzc
 * @Date 2021/2/7 16:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/stock/actualAccount")
public class StockActualAccountController {

    @Resource
    private StockActualAccountService stockActualAccountService;

    @ApiOperation(value = "根据合同ID查询合同实付款项")
    @GetMapping("findByContractId")
    public Message findByContractId(Long contractId) {

        List<StockActualAccount> stockActualAccountList = stockActualAccountService.findByContractId(contractId);

        return MessageUtil.success("success", stockActualAccountList);
    }

    @ApiOperation(value = "添加实际付款情况")
    @PostMapping(value = "addActualAccount")
    public Message addActualAccount(StockActualAccount equipmentActualAccount){

        stockActualAccountService.addActualAccount(equipmentActualAccount);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "实际付款记录置为无效")
    @PostMapping(value = "setInvalidActualAccount")
    public Message setInvalidActualAccount(StockActualAccount equipmentActualAccount){

        stockActualAccountService.setInvalidActualAccount(equipmentActualAccount);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "根据合同ID查询已付款总金额")
    @GetMapping(value = "setInvalidActualAccount")
    public Message statisticsActualAccountByContractId(Long contractId){

        Double money = stockActualAccountService.statisticsActualAccountByContractId(contractId);
        return MessageUtil.success("success", money);
    }
}
