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

    @GetMapping("FindDraftComparePrice")
    public Message FindDraftComparePrice(@RequestParam(defaultValue = "-1") long proDetailId, @RequestParam(defaultValue = "-1") Integer compareStatus) {
        List<Map> maps = finallyCheckCompareServiceImpl.FindDraftComparePrice(proDetailId, compareStatus);
        // 数据格式：[{name: "", inquiryCompareVMS: List<inquiryCompareVMS>},{...}]
        // inquiryCompareVMS：[{...},{...}]
        //Map map = new HashMap();
  /*      map.put("inquiryCompareVMS", maps);
        List<Map> result = new ArrayList<>();
        result.add(map);*/
        return MessageUtil.success("success", maps);
    }

}
