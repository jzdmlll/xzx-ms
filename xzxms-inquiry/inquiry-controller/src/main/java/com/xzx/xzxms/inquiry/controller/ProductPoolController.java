package com.xzx.xzxms.inquiry.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.IProductPoolService;
import com.xzx.xzxms.inquiry.bean.ProPool;
import com.xzx.xzxms.inquiry.bean.extend.ProPoolExtend;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pool")
public class ProductPoolController {

    @Resource
    private IProductPoolService productPoolServiceImpl;

    @ApiOperation(value = "产品池数据新增")
    @PostMapping(value = "addProductPool")
    public Message addProductPool(ProPool proPool){
        productPoolServiceImpl.addProductPool(proPool);
        return MessageUtil.success("success");
    }

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
    public Message findByParams(@RequestParam(value="name", required=false, defaultValue = "")String name,
                                @RequestParam(value="brand", required=false, defaultValue = "")String brand,
                                @RequestParam(value="proName", required=false, defaultValue = "")String proName,
                                @RequestParam(value="model", required=false, defaultValue = "")String model,
                                @RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize",required = false,defaultValue = "50")int pageSize){
        PageHelper.startPage(pageNum, pageSize, "time desc");
        List<ProPoolExtend> list = productPoolServiceImpl.findByParams(name, brand, proName, model);
        PageInfo<ProPoolExtend> pageInfo = new PageInfo<>(list);

        return MessageUtil.success("success", pageInfo);
    }

    @ApiOperation(value = "查询历史报价和成本")
    @GetMapping(value = "findHistoryPrices")
    public Message findHistoryPrices(@RequestParam(value="name", required=false, defaultValue = "") String name,
                                     @RequestParam(value="model", required=false, defaultValue = "") String model){
        List<ProPool> list = productPoolServiceImpl.findHistoryPrices(name, model);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "询价界面模糊查询产品池存在数据")
    @GetMapping(value = "fuzzyQueryByNameOrModel")
    public Message fuzzyQueryByNameOrModel(@RequestParam(value="name", required=false, defaultValue = "") String name,@RequestParam(value="model", required=false, defaultValue = "") String model){

        List<ProPool> proPools = productPoolServiceImpl.fuzzyQueryByNameOrModel(name, model);
        return MessageUtil.success("success",proPools);
    }
}
