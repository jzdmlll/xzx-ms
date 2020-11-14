package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.SysCheckExtend;

import java.util.List;

public interface ISysProCheckService {

//    /**
//     * 级联角色、询价（或项目）查询所有信息
//     * @param checkName 审核名称
//     * @param checkStatus  添加审核状态查询条件
//     * @param proDetailId   添加项目详情查询条件
//     * @return
//     */
//    List<SysProCheckExtend> cascadeFindAllByCheckName(String checkName, int[] checkStatus, long proDetailId);
//
//    /**
//     * 改变审核状态
//     * @param status 审核状态
//     * @param ids 审核内容ID集合
//     * @param operator 操作人
//     */
//    void UpdateCheckStatus(Integer status, long[] ids, long operator);



    /**
     * 更改技术审核状态
     * @param sysProChecks 审核对象集合
     * @return
     */
    void updateTechnicalStatus(List<SysProCheck> sysProChecks);

    /**
     * 查询技术审核内容
     * @param status 审核状态
     * @param proDetailId 项目详情ID
     * @return
     */
    List<SysCheckExtend> findTechnicalCheck(Integer status, long proDetailId);

    /**
     * 查询商务审核内容
     * @param status 审核状态
     * @param proDetailId 项目详情ID
     * @return
     */
    List<SysCheckExtend> findBusinessCheck(Integer status, long proDetailId);

    /**
     * 查询比较审核内容
     * @param status 审核状态
     * @param proDetailId 项目详情ID
     * @return
     */
    List<SysCheckExtend> findCompareCheck(Integer status, long proDetailId);

    /**
     * 查询最终审核内容
     * @param status 审核状态
     * @param proDetailId 项目详情ID
     * @return
     */
    List<SysCheckExtend> findFinallyCheck(Integer status, long proDetailId);
}
