package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.service.ISysProOriginService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/project/origin")
public class SysProOriginController {
    @Resource
    private ISysProOriginService sysProOriginServiceImpl;

    @GetMapping("/findAll")
    public Message findAll() {
        List<SysProOrigin> proOriginList = sysProOriginServiceImpl.findAll();
        return MessageUtil.success("success", proOriginList);
    }
}
