package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.vm.ProIsFinallyVM;
import com.xzx.xzxms.vm.ProjectSchedule;

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
    List<ProjectSchedule> findAllProjectSchedule(String proName,int pageNum);


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


}
