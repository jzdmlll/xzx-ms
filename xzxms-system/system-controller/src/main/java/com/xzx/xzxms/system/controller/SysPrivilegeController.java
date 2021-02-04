package com.xzx.xzxms.system.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.bean.SysPrivilege;
import com.xzx.xzxms.system.service.ISysPrivilegeService;
import com.xzx.xzxms.system.vm.PrivilegeTree;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/privilege")
public class SysPrivilegeController {

    @Autowired
    private ISysPrivilegeService sysPrivilegeService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<SysPrivilege> list = sysPrivilegeService.findAll();
        return MessageUtil.success("success",list);
    }



    @ApiOperation(value = "通过parentId查询")
    @GetMapping(value = "findByParentId")
    public Message findByParentId(Long id){
        List<SysPrivilege> list = sysPrivilegeService.findByParentId(id);
        return MessageUtil.success("success",list);
    }

    @ApiOperation(value ="保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(SysPrivilege privilege){
        sysPrivilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "查询权限树")
    @GetMapping(value = "findPrivilegeTree")
    public Message findPrivilegeTree(){
        List<PrivilegeTree> list = sysPrivilegeService.findPrivilegeTree();
        return MessageUtil.success("success",list);
    }

    @ApiOperation(value = "删除指定id的权限")
    @GetMapping(value = "deleteById")
    public Message deleteById(int id){
        sysPrivilegeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

}
