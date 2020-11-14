package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.service.ISysProCheckService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
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
    @GetMapping("updateTechnicalStatus")
    public Message updateTechnicalStatus(List<SysProCheck> sysProChecks) {

        sysProCheckServiceImpl.updateTechnicalStatus(sysProChecks);
        return MessageUtil.success("success");
    }

    @ApiOperation("查询技术审核")
    @GetMapping("findTechnicalCheck")
    public Message findTechnicalCheck(Integer status, long proDetailId) {

        sysProCheckServiceImpl.findTechnicalCheck(status, proDetailId);
        return MessageUtil.success("success");
    }

    @ApiOperation("查询商务审核")
    @GetMapping("findBusinessCheck")
    public Message findBusinessCheck(Integer status, long proDetailId) {

        sysProCheckServiceImpl.findBusinessCheck(status, proDetailId);
        return MessageUtil.success("success");
    }



}
