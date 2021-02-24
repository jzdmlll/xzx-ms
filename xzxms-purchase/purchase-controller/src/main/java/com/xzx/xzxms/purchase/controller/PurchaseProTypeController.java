package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseProType;
import com.xzx.xzxms.purchase.service.IPurchaseProTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：tjz
 * @title：
 * @date：2021/2/24 14:02
 * @修改人：
 * @修改时间：2021/2/24 14:02
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/purchase/project/type")
public class PurchaseProTypeController {
    @Resource
    private IPurchaseProTypeService iPurchaseProTypeServiceImpl;

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(PurchaseProType purchaseProType){

        iPurchaseProTypeServiceImpl.saveOrUpdate(purchaseProType);
        System.out.println(purchaseProType);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "查询")
    @GetMapping(value="findAll")
    public Message findAll(){
        List<PurchaseProType> list= iPurchaseProTypeServiceImpl.findAll();
        return MessageUtil.success("查询成功",list);
    }

    @ApiOperation(value = "逻辑删除项目分类")
    @PostMapping(value="logicDeleteById")
    public Message logicDeleteById(long purchaseProTypeId){
        iPurchaseProTypeServiceImpl.logicDeleteById(purchaseProTypeId);
        return MessageUtil.success("操作成功");
    }
}
