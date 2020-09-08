package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;

public interface ISysProDetailService {

    /***
     * 根据项目详情ID查询
     * @param proDetailId
     * @return
     */
    SysProDetailExtend findById(long proDetailId);
    SysProDetailExtend findById();
}
