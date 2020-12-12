package com.xzx.xzxms.system.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.extend.SysRoleExtend;
import com.xzx.xzxms.system.service.ISysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private ISysRoleService roleService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll() {
        List<SysRole> list = roleService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation(value = "查询所有", notes = "级联权限")
    @GetMapping(value = "cascadePrivilegeFindAll")
    public Message cascadePrivilegeFindAll() {
        List<SysRoleExtend> list = roleService.cascadePrivilegeFindAll();
        return MessageUtil.success("success",list);
    }


    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id) {
        roleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(SysRole role) {
        roleService.saveOrUpdate(role);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "为角色授权")
    @PostMapping(value = "authorization")
    public Message authorization(long id, Long[] privileges) {
        List<Long> ids = Arrays.asList(privileges);
        roleService.authorization(id, ids);
        return MessageUtil.success("授权成功");
    }

    @ApiOperation(value = "查询所有审核名")
    @GetMapping(value = "selectAllHasCheckName")
    public Message selectAllHasCheckName() {
        List<SysRole> roles = roleService.selectAllHasCheckName();
        return MessageUtil.success("success", roles);
    }
}
