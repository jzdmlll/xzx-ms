package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProCheck;

import java.util.List;

public interface ISysProCheckService {

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
