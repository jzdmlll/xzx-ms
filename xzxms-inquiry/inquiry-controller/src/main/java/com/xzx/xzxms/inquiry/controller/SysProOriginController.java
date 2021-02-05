package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.ISysProOriginService;
import com.xzx.xzxms.inquiry.bean.SysProOrigin;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public Message findAll() {
        List<SysProOrigin> proOriginList = sysProOriginServiceImpl.findAll();
        return MessageUtil.success("操作成功", proOriginList);
    }
    @ApiOperation("新增或修改")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(SysProOrigin proOrigin) {
        sysProOriginServiceImpl.saveOrUpdate(proOrigin);
        return MessageUtil.success("操作成功");
    }
    @ApiOperation("逻辑删除")
    @PostMapping("/logicDeleteById")
    public Message logicDeleteById(int proOriginId) {
        sysProOriginServiceImpl.logicDeleteById(proOriginId);
        return MessageUtil.success("操作成功");
    }
}
