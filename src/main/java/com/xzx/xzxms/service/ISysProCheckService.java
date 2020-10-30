package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;

import java.util.List;

public interface ISysProCheckService {

    /**
     * 级联角色、询价（或项目）查询所有信息
     * @param checkName 审核名称
     * @param checkStatus  添加审核状态查询条件
     * @param proDetailId   添加项目详情查询条件
     * @return
     */
    List<SysProCheckExtend> cascadeFindAllByCheckName( String checkName, int[] checkStatus, long proDetailId);

    /**
     * 改变审核状态
     * @param status 审核状态
     * @param ids 审核内容ID集合
     * @param operator 操作人
     */
    void UpdateCheckStatus(Integer status, long[] ids, long operator);


}
