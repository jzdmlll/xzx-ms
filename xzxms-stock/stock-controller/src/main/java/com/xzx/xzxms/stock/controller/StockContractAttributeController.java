package com.xzx.xzxms.stock.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.bean.StockContractAttribute;
import com.xzx.xzxms.stock.service.StockContractAttributeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 收发存模块 合同属性表 控制器
 * @Author Lzc
 * @Date 2021/2/7 14:40
 * @Version 1.0
 */
@RestController
@RequestMapping("/stock/contractAttribute")
public class StockContractAttributeController {

    @Resource
    private StockContractAttributeService stockContractAttributeService;

    @ApiOperation(value = "根据合同ID查询合同属性信息")
    @GetMapping("findByContractId")
    public Message findByContractId(Long contractId) {

        StockContractAttribute stockContractAttribute = stockContractAttributeService.findByContractId(contractId);
        return MessageUtil.success("success", stockContractAttribute);
    }

    @ApiOperation(value = "修改或新增合同属性")
    @PostMapping("saveOrUpdateStockContractAttribute")
    public Message saveOrUpdateStockContractAttribute(StockContractAttribute stockContractAttribute) {

        stockContractAttributeService.saveOrUpdateStockContractAttribute(stockContractAttribute);
        return MessageUtil.success("success");
    }
}
