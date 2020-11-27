package com.xzx.xzxms.service;

import com.xzx.xzxms.vm.ProPurchase;

import java.util.List;

public interface IProPurchaseService {

    /**
     * 查询项目采购内容
     * @param proDetailId
     * @return
     */
    List<ProPurchase> findProPurchase(long proDetailId);

}
