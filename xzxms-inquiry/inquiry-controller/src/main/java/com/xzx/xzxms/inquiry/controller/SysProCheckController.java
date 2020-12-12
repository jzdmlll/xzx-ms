package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.ISysProCheckService;
import com.xzx.xzxms.inquiry.bean.SysProCheck;
import com.xzx.xzxms.inquiry.bean.extend.SysCheckExtend;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/proCheck")
public class SysProCheckController {

    @Resource
    private ISysProCheckService sysProCheckServiceImpl;

//    @ApiOperation("级联查询审核")
//    @GetMapping("cascadeFindAllByCheckName")
//    public Message cascadeFindAllByCheckName(String checkName) {
//        List<SysProCheckExtend> sysProCheckExtends = sysProCheckServiceImpl.cascadeFindAllByCheckName( checkName, null, -1);
//        return MessageUtil.success("success", sysProCheckExtends);
//    }
//    @ApiOperation("级联查询审核")
//    @PostMapping("cascadeFindAllByCheckName")
//    public Message cascadeFindAllByCheckName(String checkName, int[] status, @RequestParam(value="proDetailId", required=false, defaultValue="-1")long proDetailId) {
//        List<SysProCheckExtend> sysProCheckExtends = sysProCheckServiceImpl.cascadeFindAllByCheckName( checkName, status, proDetailId);
//        return MessageUtil.success("success", sysProCheckExtends);
//    }
//
//    @ApiOperation("审核提交")
//    @PostMapping("batchCheck")
//    public Message updateCheckStatus(int status, long[] ids, long operator){
//        sysProCheckServiceImpl.UpdateCheckStatus(status, ids, operator);
//        return MessageUtil.success("操作成功");
//    }


    @ApiOperation("技术审核更改状态")
    @PostMapping("updateTechnicalStatus")
    public Message updateTechnicalStatus(@RequestBody List<SysProCheck> sysProChecks) {

        sysProCheckServiceImpl.updateTechnicalStatus(sysProChecks);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("查询技术审核")
    @GetMapping("findTechnicalCheck")
    public Message findTechnicalCheck(@RequestParam(defaultValue = "-1")Integer status,@RequestParam(defaultValue = "-1") long proDetailId) {

        List<SysCheckExtend> technicalCheck = sysProCheckServiceImpl.findTechnicalCheck(status, proDetailId);
        return MessageUtil.success("success", technicalCheck);
    }

    @ApiOperation("查询商务审核")
    @GetMapping("findBusinessCheck")
    public Message findBusinessCheck(@RequestParam(defaultValue = "-1") Integer status,@RequestParam(defaultValue = "-1") long proDetailId) {

        List<SysCheckExtend> businessCheck = sysProCheckServiceImpl.findBusinessCheck(status, proDetailId);
        return MessageUtil.success("success", businessCheck);
    }



}
