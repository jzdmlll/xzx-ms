package com.xzx.xzxms.purchase.service;


import com.xzx.xzxms.purchase.bean.PurchaseProType;

import java.util.List;

/**
 * @author：tjz
 * @title：
 * @date：2021/2/24 14:03
 * @修改人：
 * @修改时间：2021/2/24 14:03
 * @修改描述：默认描述
 */
public interface IPurchaseProTypeService {

    /***
     * 查询所有采购项目分类
     * @return
     */
    List<PurchaseProType> findAll();

    /**
     * 插入或更新采购项目分类
     * @param purchaseProType
     */
    void saveOrUpdate(PurchaseProType purchaseProType);

    /**
     * 逻辑删除采购项目分类
     * @param purchaseProTypeId
     */
    void logicDeleteById(long purchaseProTypeId);

}
