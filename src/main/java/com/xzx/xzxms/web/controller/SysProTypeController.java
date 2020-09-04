package com.xzx.xzxms.web.controller;
import com.xzx.xzxms.bean.SysProType;
import com.xzx.xzxms.service.ISysProTypeService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/project/type")
public class SysProTypeController {

    @Resource
    private ISysProTypeService sysProTypeServiceImpl;

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(SysProType sysProType){

        sysProTypeServiceImpl.saveOrUpdate(sysProType);
        System.out.println(sysProType);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "查询")
    @GetMapping(value="findAll")
    public Message findAll(){
        List<SysProType> list= sysProTypeServiceImpl.findAll();
        return MessageUtil.success("查询成功",list);
    }

}
