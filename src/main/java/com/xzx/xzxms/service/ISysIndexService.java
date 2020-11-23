package com.xzx.xzxms.service;

import com.xzx.xzxms.vm.ProjectSchedule;

import java.util.List;

public interface ISysIndexService {

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
    List<ProjectSchedule> findProDetailSchedule(long proId);


}
