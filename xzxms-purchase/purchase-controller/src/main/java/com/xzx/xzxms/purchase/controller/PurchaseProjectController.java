package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.service.IPurchaseProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/purchaseProject")
public class PurchaseProjectController {
    @Resource
    private IPurchaseProjectService iPurchaseProjectServiceImpl;
    @ApiOperation(value = "模糊查询")
    @GetMapping(value = "findAllLike")
    public Message findAllLike(String name){
        List<PurchaseProject> purchaseProjects = iPurchaseProjectServiceImpl.findAllLike(name);
        return MessageUtil.success("success",purchaseProjects);
    }

    @ApiOperation(value = "通过项目id进行查询")
    @GetMapping(value ="findById")
    public Message findById(Long id){
        List<PurchaseProject> list = iPurchaseProjectServiceImpl.findById(id);
        return MessageUtil.success("success",list);
    }

    @ApiOperation(value = "通过id进行假删")
    @PostMapping(value = "deleteById")
    public Message deleteById(long id){
        iPurchaseProjectServiceImpl.deleteById(id);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "新增或者修改")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(PurchaseProject purchaseProject){
        iPurchaseProjectServiceImpl.saveOrUpdate(purchaseProject);
        return MessageUtil.success("success");
    }

}
