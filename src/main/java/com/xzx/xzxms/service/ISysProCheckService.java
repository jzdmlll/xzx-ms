package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;

import java.util.List;

public interface ISysProCheckService {

    /**
     * 前端询价内容保存后新增一条相应的审核内容
     * @param sysProCheck
     */
    void inquiryInsert(SysProCheck sysProCheck);
    /**
     * 审核
     * @param ids
     */
    void check(long[] ids,int state);
    /**
     * 审核撤销
     * @param ids
     */
    void revoke(long[] ids);

    /**
     * 级联角色查询所有审核信息
     * @return
     */
    List<SysProCheckExtend> cascadeRoleFindAll();

    /**
     * 级联角色、询价（或项目）查询所有信息
     * @param type 审核类型 0：询价 1：项目
     * @param checkName 审核名称（从role表里查）
     * @param checkStatus  添加审核状态查询条件
     * @param proDetailId   添加项目详情查询条件
     * @return
     */
    List<SysProCheckExtend> cascadeFindAllByCheckName(int type, String checkName, int[] checkStatus, long proDetailId);
}
