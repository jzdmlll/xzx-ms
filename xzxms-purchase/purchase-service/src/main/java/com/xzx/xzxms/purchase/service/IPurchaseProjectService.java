package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.PurchaseProject;

import java.util.List;

public interface IPurchaseProjectService {
    /**
     * 模糊查询项目名
     * @param name
     * @return
     */
    List<PurchaseProject> findAllLike(String name);
}
