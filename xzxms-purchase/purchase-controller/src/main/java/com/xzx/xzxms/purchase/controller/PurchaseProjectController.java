package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.bean.vm.PurchaseProjectExtend;
import com.xzx.xzxms.purchase.service.IPurchaseProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/purchase/project")
public class PurchaseProjectController {
    @Resource
    private IPurchaseProjectService iPurchaseProjectServiceImpl;

    /**
     * tjz
     * @param name
     * @return
     */
    @ApiOperation(value = "模糊查询")
    @GetMapping(value = "findAllLike")
    public Message findAllLike(String name){
        List<PurchaseProject> purchaseProjects = iPurchaseProjectServiceImpl.findAllLike(name);
        return MessageUtil.success("success", purchaseProjects);
    }

    /**
     * tjz
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有采购项目的类型")
    @GetMapping(value = "findByAll")
    public Message findByAll(){
        List<PurchaseProjectExtend> purchaseProjectExtends = iPurchaseProjectServiceImpl.findByAll();
        return MessageUtil.success("success",purchaseProjectExtends);
    }

    /**
     * tjz
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "通过id进行假删")
    @PostMapping(value = "deleteById")
    public Message deleteById(Long id, Long user){
        iPurchaseProjectServiceImpl.deleteById(id, user);
        return MessageUtil.success("success");
    }

    /**
     * tjz
     * @param purchaseProject
     * @return
     */
    @ApiOperation(value = "新增或者修改")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(PurchaseProject purchaseProject){
        iPurchaseProjectServiceImpl.saveOrUpdate(purchaseProject);
        return MessageUtil.success("success");
    }

}
