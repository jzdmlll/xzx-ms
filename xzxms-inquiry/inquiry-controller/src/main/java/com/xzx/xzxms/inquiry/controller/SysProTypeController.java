package com.xzx.xzxms.inquiry.controller;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.ISysProTypeService;
import com.xzx.xzxms.inquiry.bean.SysProType;
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
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "查询")
    @GetMapping(value="findAll")
    public Message findAll(){
        List<SysProType> list= sysProTypeServiceImpl.findAll();
        return MessageUtil.success("查询成功",list);
    }

    @ApiOperation(value = "逻辑删除项目分类")
    @PostMapping(value="logicDeleteById")
    public Message logicDeleteById(long proTypeId){
        sysProTypeServiceImpl.logicDeleteById(proTypeId);
        return MessageUtil.success("操作成功");
    }
}
