package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.service.IFinallyCheckCompareService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/finallyCheck")
public class FinallyCheckController {
    @Resource
    private IFinallyCheckCompareService finallyCheckCompareServiceImpl;

    @GetMapping("findDraftComparePrice")
    public Message FindDraftComparePrice(@RequestParam(defaultValue = "-1") long proDetailId, @RequestParam(defaultValue = "") String checkName) {
        List<Map> maps = finallyCheckCompareServiceImpl.FindDraftComparePrice(proDetailId, checkName);
        return MessageUtil.success("success", maps);
    }

}
