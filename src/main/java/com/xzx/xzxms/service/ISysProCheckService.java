package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProDetail;

public interface ISysProCheckService {

    /**
     * 前端项目详情保存后新增一条相应的审核内容
     * @param sysProDetail
     */
    void proDetailInsert(SysProDetail sysProDetail);

    /**
     * 前端询价内容保存后新增一条相应的审核内容
     * @param sysProCheck
     */
    void inquiryInsert(SysProCheck sysProCheck);



    /**
     * 审核通过
     * @param ids
     */
    void approved(long[] ids);

    /**
     * 审核撤销
     * @param ids
     */
    void revoke(long[] ids);



}
