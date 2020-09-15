package com.xzx.xzxms.web.controller;


import com.xzx.xzxms.bean.SysDeviceType;
import com.xzx.xzxms.service.ISysDeviceTypeService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/deviceType")
public class SysDeviceTypeController {

    @Resource
    private ISysDeviceTypeService sysDeviceTypeServiceImpl;

    @ApiOperation(value = "模糊查询")
    @GetMapping(value = "findAllLike")
    public Message findAllLike(String name,String code){

        List<SysDeviceType> deviceTypeList = sysDeviceTypeServiceImpl.findAllLike(name, code);
        return MessageUtil.success("success",deviceTypeList);
    }

    @ApiOperation(value = "根据ID查询内容")
    @GetMapping(value = "findById")
    private Message findById(long id){

        SysDeviceType sysDeviceType=sysDeviceTypeServiceImpl.findById(id);
        return MessageUtil.success("success",sysDeviceType);
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
