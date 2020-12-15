package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.service.IPurchaseProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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


}
