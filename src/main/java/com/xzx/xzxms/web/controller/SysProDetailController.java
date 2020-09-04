package com.xzx.xzxms.web.controller;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowRelayLogEventsStatement;
import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.service.ISysProDetailService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        if (sysProDetailExtend == null){

            return MessageUtil.error("无数据");
        }
        return MessageUtil.success("success",sysProDetailExtend);
    }
}
