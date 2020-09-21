package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.service.ISysProCheckService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/proCheck")
public class SysProCheckController {
    @Resource
    private ISysProCheckService sysProCheckServiceImpl;
    @GetMapping("cascadeRoleFindAll")
    public Message cascadeRoleFindAll() {
        List<SysProCheckExtend> sysProCheckExtends = sysProCheckServiceImpl.cascadeRoleFindAll();
        return MessageUtil.success("success", sysProCheckExtends);
    }
    @GetMapping("cascadeFindAllByCheckName")
    public Message cascadeFindAllByCheckName(String checkName, int type) {
        List<SysProCheckExtend> sysProCheckExtends = sysProCheckServiceImpl.cascadeFindAllByCheckName( type ,checkName, -1, -1);
        return MessageUtil.success("success", sysProCheckExtends);
    }
}
