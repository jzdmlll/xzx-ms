package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.service.ISysProDetailService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/project/detail")
public class SysProDetailController {

    @Resource
    private ISysProDetailService sysProDetailServiceImpl;

    @ApiOperation(value = "获取对应的类型和来源")
    @GetMapping(value = "findById")
    public Message findById(long proDetailId){

        SysProDetailExtend sysProDetailExtend = sysProDetailServiceImpl.findById(proDetailId);
        return MessageUtil.success("success",sysProDetailExtend);
    }

    @ApiOperation(value = "查询所有项目的类型和来源")
    @GetMapping(value = "findByAll")
    public Message findById(){

        List<SysProDetailExtend> sysProDetailExtend = sysProDetailServiceImpl.findById();
        return MessageUtil.success("success",sysProDetailExtend);
    }

}
