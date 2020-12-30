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

    /**
     * 通过主键id查询采购项目对象
     * @param id
     * @return
     */
    List<PurchaseProject> findById(Long id);

    /**
     * 通过主键id逻辑假删
     * @param id
     */
    void deleteById(long id);

    /**
     * 新增或者修改采购项目
     * @param purchaseProject
     */
    void saveOrUpdate(PurchaseProject purchaseProject);
}
