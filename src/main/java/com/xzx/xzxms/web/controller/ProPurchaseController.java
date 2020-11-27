package com.xzx.xzxms.web.controller;


import com.xzx.xzxms.service.IProPurchaseService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.vm.ProPurchase;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/proPurchase")
public class ProPurchaseController {

    @Resource
    private IProPurchaseService proPurchaseServiceImpl;

    @ApiOperation("查询项目采购内容")
    @GetMapping("findProPurchase")
    public Message findProPurchase(@RequestParam(value = "proDetailId",required = false,defaultValue = "-1") long proDetailId){
        List<ProPurchase> proPurchases = proPurchaseServiceImpl.findProPurchase(proDetailId);
        return MessageUtil.success("success", proPurchases);
    }
}