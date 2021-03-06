package com.xzx.xzxms.inquiry.service;


import com.xzx.xzxms.inquiry.bean.InquiryPool;

import java.util.List;

public interface IInquiryPoolService {

    /**
     * 查询
     * @param name  询价名
     * @param brand 供应商报价品牌
     //* @param choose 选用标识
     * @return
     */
    List<InquiryPool> findByParams(String name, String brand, Long proDetailId, String model);
}
