package com.xzx.xzxms.inquiry.service;

import com.xzx.xzxms.inquiry.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.inquiry.vm.ProIsFinallyVM;
import com.xzx.xzxms.inquiry.vm.ProjectSchedule;
import com.xzx.xzxms.inquiry.vm.ToDoList;
import com.xzx.xzxms.inquiry.vo.ContractAuditDealVO;

import java.util.List;
import java.util.Map;

public interface ISysIndexService {


    /**
     * 查询项目总数和供应商总数
     * @return
     */
    Map<String,Integer> findProAndSupplier();

    /**
     * 查询项目完成状态
     * @param proName 项目名
     * @return
     */
    List<ProIsFinallyVM> findProIsFinally(String proName);


    /**
     * 查询所有项目简要进度
     * proName 项目名
     * pageNum 分页
     * @return
     */
    List<ProjectSchedule> findAllProjectSchedule(String proName, int pageNum);


    /**
     * 查看项目详细的进度
     * @param proId
     * @return
     */
    List<SysCheckAndScheduleExtend> findProDetailSchedule(long proId);

    /**
     * 查询当前年份下所有月份的项目总数
     * @param year
     * @return
     */
    int[] findYearPro(String year);

    /**
     * 查询当前年份下个月的供应商数
     * @param year
     * @return
     */
    int[] findYearSupplier(String year);

    /**
     * 查询技术审核待办事项
     * @return
     */
    List<ToDoList> findTechnicalAuditDeal();

    /**
     * 查询商务审核待办事项
     * @return
     */
    List<ToDoList> findBusinessAuditDeal();

    /**
     * 查询比价待办事项
     * @return
     */
    List<ToDoList> findCompareAuditDeal();

    /**
     * 查询终审待办事项
     * @return
     */
    List<ToDoList> findFinallyAuditDeal();

    /**
     * 查询一审待办事项
     * @return
     */
    List<ContractAuditDealVO> dataSourceFirst();

    /**
     * 查询二审待办事项
     * @return
     */
    List<ContractAuditDealVO> dataSourceSecond();

    /**
     * 查询三审待办事项
     * @return
     */
    List<ContractAuditDealVO> dataSourceThree();

}
