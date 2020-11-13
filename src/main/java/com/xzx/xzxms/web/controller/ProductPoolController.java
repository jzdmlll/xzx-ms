package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.ProPool;
import com.xzx.xzxms.service.IProductPoolService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pool")
public class ProductPoolController {

    @Resource
    private IProductPoolService productPoolServiceImpl;

    @ApiOperation(value="批量删除")
    @PostMapping(value="batchSetInvalid")
    public Message batchSetInvalid(long[] ids){

        productPoolServiceImpl.batchSetInvalid(ids);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "修改")
    @PostMapping(value = "updateMessage")
    public Message updateMessage(ProPool proPool){
        productPoolServiceImpl.updateMessage(proPool);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "查询")
    @GetMapping(value = "findByParams")
    public Message findByParams(@RequestParam(value="name", required=false, defaultValue = "")String name, @RequestParam(value="brand", required=false, defaultValue = "")String brand){
        List<ProPool> list = productPoolServiceImpl.findByParams(name, brand);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "查询历史报价和成本")
    @GetMapping(value = "findHistoryPrices")
    public Message findHistoryPrices(@RequestParam(value="name", required=false, defaultValue = "") String name,@RequestParam(value="model", required=false, defaultValue = "") String model){
        List<ProPool> list = productPoolServiceImpl.findHistoryPrices(name, model);
        return MessageUtil.success("success", list);
    }
}
