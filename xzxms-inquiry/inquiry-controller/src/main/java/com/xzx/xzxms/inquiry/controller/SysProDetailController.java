package com.xzx.xzxms.inquiry.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.ISysProDetailService;
import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.inquiry.vm.ProDetailReqVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
        return MessageUtil.success("success",sysProDetailExtend);
    }

    @ApiOperation(value = "查询所有项目的类型和来源")
    @GetMapping(value = "findByAll")
    public Message findByAll(){
        List<SysProDetailExtend> sysProDetailExtend = sysProDetailServiceImpl.findById();
        return MessageUtil.success("success",sysProDetailExtend);
    }

    @ApiOperation(value = "新增或修改项目")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(@RequestBody ProDetailReqVM proDetailReqVM) throws Exception {
        sysProDetailServiceImpl.saveOrUpdate(proDetailReqVM.getProDetails(), proDetailReqVM.getFiles());
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "验证项目名称是否存在")
    @GetMapping(value = "verifyExistence")
    public Message verifyExistence(String proName){
        Boolean bool = sysProDetailServiceImpl.verifyExistence(proName);
        return MessageUtil.success("success", bool);
    }

    @ApiOperation(value = "根据项目详情id查利率")
    @GetMapping(value = "findProRate")
    public Message findProRate(long proDetailId){
        SysProDetail sysProDetail = sysProDetailServiceImpl.findProRate(proDetailId);
        return MessageUtil.success("success",sysProDetail.getProRate());
    }

    @ApiOperation(value = "修改利率")
    @PostMapping(value = "updateProRate")
    public Message updateProRate(long proDetailId,int proRate){
        sysProDetailServiceImpl.updateProRate(proDetailId,proRate);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation(value = "逻辑删除项目")
    @PostMapping(value = "setInvalid")
    public Message setInvalid(long proDetailId) {
        sysProDetailServiceImpl.setInvalid(proDetailId);
        return MessageUtil.success("操作成功");
    }
}
