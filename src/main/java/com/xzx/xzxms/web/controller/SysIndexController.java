package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.service.ISysIndexService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysIndex")
public class SysIndexController {

    @Resource
    private ISysIndexService sysIndexServiceImpl;

    @ApiOperation(value = "查询项目详细进度")
    @GetMapping(value = "findProDetailSchedule")
    public Message findProDetailSchedule(long proDetailId){
        List<SysCheckAndScheduleExtend> list = sysIndexServiceImpl.findProDetailSchedule(proDetailId);
        return MessageUtil.success("success",list);
    }
}
