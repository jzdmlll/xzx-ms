package com.xzx.xzxms.supply.controller;/**
 * @Author sunny
 * @Date 2021/2/18 14:53
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.supply.bean.SupplySupplier;
import com.xzx.xzxms.supply.dao.SupplySupplierMapper;
import com.xzx.xzxms.supply.service.SupplySupplierService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName SupplySupplierController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@RestController
@RequestMapping("/supply/supplier")
public class SupplySupplierController {

    @Resource
    private SupplySupplierService supplySupplierServiceImpl;

    @ApiOperation(value = "查询")
    @GetMapping(value = "findSupplierByParams")
    public Message findSupplierByParams() {

        List<SupplySupplier> list = supplySupplierServiceImpl.findSupplierByParams();
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "新增或修改")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(SupplySupplier supplySupplier) {

        supplySupplierServiceImpl.saveOrUpdate(supplySupplier);
        return MessageUtil.success("success");
    }
}
