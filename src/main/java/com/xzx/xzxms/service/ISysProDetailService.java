package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.*;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;

import java.util.List;

public interface ISysProDetailService {

    /***
     * 根据项目详情ID查询
     * @param proDetailId
     * @return
     */
    SysProDetailExtend findById(long proDetailId);

    List<SysProDetailExtend> findById();

    /**
     * 新增或修改项目
     * @param proDetail
     * @param files
     * @param checks
     */
    void saveOrUpdate(SysProDetailWithBLOBs proDetail, List<SysFile> files, List<SysProDetailCheck> checks);

    /**
     * 验证项目名称是否存在
     * @param proName
     * @return
     */
    boolean verifyExistence(String proName);
}
