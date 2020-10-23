package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.SysFile;
import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.service.ISysProDetailService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import com.xzx.xzxms.utils.ObjectMapUtils;
import com.xzx.xzxms.vm.ProDetailReqVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value = "新增或修改项目")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(@RequestBody ProDetailReqVM proDetailReqVM) throws Exception {
        sysProDetailServiceImpl.saveOrUpdate(proDetailReqVM.getProDetails(), proDetailReqVM.getFiles(),proDetailReqVM.getProChecks());
        return MessageUtil.success("操作成功");
    }

}
