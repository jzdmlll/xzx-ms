package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.service.ISysIndexService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sysIndex")
public class SysIndexController {

    @Resource
    private ISysIndexService sysIndexServiceImpl;


    @ApiOperation(value = "查询项目总数和供应商总数")
    @GetMapping(value = "findProAndSupplier")
    public Message findProAndSupplier(){

        Map<String,Integer> map = sysIndexServiceImpl.findProAndSupplier();
        return MessageUtil.success("success",map);
    }

    @ApiOperation(value = "查询当前年份个月项目总数")
    @GetMapping(value = "findYearPro")
    public Message findYearPro(String year){
        int[] temp = sysIndexServiceImpl.findYearPro(year);
        return MessageUtil.success("success",temp);
    }

    @ApiOperation(value = "查询当前年份个月供应商数")
    @GetMapping(value = "findYearSupplier")
    public Message findYearSupplier(String year){
        int[] temp = sysIndexServiceImpl.findYearSupplier(year);
        return MessageUtil.success("success",temp);
    }

    @ApiOperation(value = "查询项目是否已完成")
    @GetMapping(value = "findProIsFinally")
    public Message findProIsFinally(String proName){

        return MessageUtil.success("success");
    }

    @ApiOperation(value = "查询项目详细进度")
    @GetMapping(value = "findProDetailSchedule")
    public Message findProDetailSchedule(long proDetailId){
        List<SysCheckAndScheduleExtend> list = sysIndexServiceImpl.findProDetailSchedule(proDetailId);
        return MessageUtil.success("success",list);
    }
}