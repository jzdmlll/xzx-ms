package com.xzx.xzxms.inquiry.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.ISysIndexService;
import com.xzx.xzxms.inquiry.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.inquiry.vm.ToDoList;
import com.xzx.xzxms.inquiry.vo.ProjectCompletionVO;
import com.xzx.xzxms.inquiry.vo.ContractAuditDealVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sysIndex")
public class SysIndexController {

    @Resource
    private ISysIndexService sysIndexServiceImpl;


    @ApiOperation(value = "查询项目总数和供应商总数")
    @GetMapping(value = "findProAndSupplier")
    public Message findProAndSupplier(){

        Map<String,Integer> map = sysIndexServiceImpl.findProAndSupplier();
        return MessageUtil.success("success",map);
    }

    @ApiOperation(value = "查询当前年份个月项目总数")
    @GetMapping(value = "findYearPro")
    public Message findYearPro(String year){
        int[] temp = sysIndexServiceImpl.findYearPro(year);
        return MessageUtil.success("success",temp);
    }

    @ApiOperation(value = "查询当前年份个月供应商数")
    @GetMapping(value = "findYearSupplier")
    public Message findYearSupplier(String year){
        int[] temp = sysIndexServiceImpl.findYearSupplier(year);
        return MessageUtil.success("success",temp);
    }

    @ApiOperation(value = "查询项目是否已完成")
    @GetMapping(value = "findProIsFinally")
    public Message findProIsFinally(String proName){

        return MessageUtil.success("success");
    }

    @ApiOperation(value = "查询项目详细进度")
    @GetMapping(value = "findProDetailSchedule")
    public Message findProDetailSchedule(long proDetailId){
        List<SysCheckAndScheduleExtend> list = sysIndexServiceImpl.findProDetailSchedule(proDetailId);
        return MessageUtil.success("success",list);
    }

    @ApiOperation(value = "查询技术审核待办事项")
    @GetMapping(value = "findTechnicalAuditDeal")
    public Message findTechnicalAuditDeal(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize){
        Page<ToDoList> page = new Page<>(pageNum, pageSize);
        IPage<ToDoList> ToDoLists = sysIndexServiceImpl.findTechnicalAuditDeal(page);

        return MessageUtil.success("success", ToDoLists);
    }

    @ApiOperation(value = "查询商务审核待办事项")
    @GetMapping(value = "findBusinessAuditDeal")
    public Message findBusinessAuditDeal(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize){
        Page<ToDoList> page = new Page<>(pageNum, pageSize);
        IPage<ToDoList> ToDoLists = sysIndexServiceImpl.findBusinessAuditDeal(page);

        return MessageUtil.success("success", ToDoLists);
    }

    @ApiOperation(value = "查询比价待办事项")
    @GetMapping(value = "findCompareAuditDeal")
    public Message findCompareAuditDeal(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize){
        Page<ToDoList> page = new Page<>(pageNum, pageSize);
        IPage<ToDoList> ToDoLists = sysIndexServiceImpl.findCompareAuditDeal(page);

        return MessageUtil.success("success", ToDoLists);
    }

    @ApiOperation(value = "查询终审待办事项")
    @GetMapping(value = "findFinallyAuditDeal")
    public Message findFinallyAuditDeal(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize){
        Page<ToDoList> page = new Page<>(pageNum, pageSize);
        IPage<ToDoList> ToDoLists = sysIndexServiceImpl.findFinallyAuditDeal(page);

        return MessageUtil.success("success", ToDoLists);
    }

    @ApiOperation("查询项目完成进度")
    @GetMapping("findProAndCompletion")
    public Message findProAndCompletion(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize,
                                        @RequestParam(value = "orderBy",required = false,defaultValue = "`completion` asc")String orderBy){
        Page<ProjectCompletionVO> page = new Page<>(pageNum, pageSize);
        IPage<ProjectCompletionVO> ToDoLists = sysIndexServiceImpl.findProAndCompletion(page, orderBy);

        return MessageUtil.success("success", ToDoLists);
    }

    @ApiOperation(value = "查询一审待办事项")
    @GetMapping(value = "dataSourceFirst")
    public Message dataSourceFirst(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize){
        Page<ContractAuditDealVO> page = new Page<>(pageNum, pageSize);
        IPage<ContractAuditDealVO> ToDoLists = sysIndexServiceImpl.dataSourceFirst(page);
        return MessageUtil.success("success", ToDoLists);
    }

    @ApiOperation(value = "查询二审待办事项")
    @GetMapping(value = "dataSourceSecond")
    public Message dataSourceSecond(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize){
        Page<ContractAuditDealVO> page = new Page<>(pageNum, pageSize);
        IPage<ContractAuditDealVO> ToDoLists = sysIndexServiceImpl.dataSourceSecond(page);
        return MessageUtil.success("success", ToDoLists);
    }

    @ApiOperation(value = "查询三审待办事项")
    @GetMapping(value = "dataSourceThree")
    public Message dataSourceThree(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "15")int pageSize){
        Page<ContractAuditDealVO> page = new Page<>(pageNum, pageSize);
        IPage<ContractAuditDealVO> ToDoLists = sysIndexServiceImpl.dataSourceThree(page);
        return MessageUtil.success("success", ToDoLists);
    }
}
