package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.service.ISysProOriginService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return MessageUtil.success("操作成功", proOriginList);
    }
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(SysProOrigin proOrigin) {
        sysProOriginServiceImpl.saveOrUpdate(proOrigin);
        return MessageUtil.success("操作成功");
    }
    @PostMapping("/logicDeleteById")
    public Message logicDeleteById(int proOriginId) {
        sysProOriginServiceImpl.logicDeleteById(proOriginId);
        return MessageUtil.success("操作成功");
    }
}
