package com.xzx.xzxms.inquiry.service;

import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.vm.ProPurchase;

import java.util.List;

public interface IProPurchaseService {

    /**
     * 查询项目采购内容
     * @param proDetailId
     * @return
     */
    List<ProPurchase> findProPurchase(long proDetailId);

    /**
     * 修正价格接口
     * @param inquiry
     */
    void updateCorrectPrice(Inquiry inquiry);

    /**
     * 修改供货价
     * @param quote
     */
    void updateSupplyPrice(Quote quote);
}
