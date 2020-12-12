package com.xzx.xzxms.inquiry.controller;


import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.ISysDeviceTypeService;
import com.xzx.xzxms.inquiry.bean.SysDeviceType;
import com.xzx.xzxms.inquiry.vm.SysDeviceTypeTree;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/deviceType")
public class SysDeviceTypeController {

    @Resource
    private ISysDeviceTypeService sysDeviceTypeServiceImpl;

    @ApiOperation(value = "根据ID查询内容")
    @GetMapping(value = "findById")
    private Message findById(long id){

        SysDeviceType sysDeviceType = sysDeviceTypeServiceImpl.findById(id);
        return MessageUtil.success("success",sysDeviceType);
    }

    @ApiOperation(value = "根据parentId模糊查询内容")
    @GetMapping(value = "findByParentId")
    private Message findByParentId(Long parentId,
                                   @RequestParam(defaultValue = "", required = false, name = "name") String name,
                                   @RequestParam(defaultValue = "", required = false, name = "code") String code){

        List<SysDeviceType> deviceTypeList = sysDeviceTypeServiceImpl.findByParentId(parentId, name, code);
        return MessageUtil.success("success", deviceTypeList);
    }

    @ApiOperation(value = "查询设备类型树")
    @GetMapping(value = "findDeviceTypeTree")
    public Message findDeviceTypeTree(){
        List<SysDeviceTypeTree> list = sysDeviceTypeServiceImpl.findDeviceTypeTree();
        return MessageUtil.success("success", list);
    }
    @ApiOperation(value="更新或新增")
    @PostMapping(value = "saveOrUpdate")
    private Message saveOrUpdate(SysDeviceType sysDeviceType){

        sysDeviceTypeServiceImpl.saveOrUpdate(sysDeviceType);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "批量置为无效")
    @PostMapping(value="setInvalid")
    private Message setInvalid(long[] ids){
        sysDeviceTypeServiceImpl.setInvalid(ids);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "批量删除")
    @PostMapping(value = "delete")
    private Message delete(long[] ids){
        sysDeviceTypeServiceImpl.delete(ids);
        return MessageUtil.success("success");
    }
}
