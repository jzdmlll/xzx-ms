package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.service.IProCheckService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ProCheck")
public class ProCheckController {

    @Resource
    private IProCheckService proCheckServiceImpl;

    @ApiOperation("审核提交")
    @PostMapping("UpdateCheckStatus")
    public Message UpdateCheckStatus(Integer status, List<Long> ids, long operator){
        proCheckServiceImpl.UpdateCheckStatus(status,ids,operator);
        proCheckServiceImpl.UpdateCheckStatus(status,ids,operator);
        return MessageUtil.success("success");
    }



}
