package com.xzx.xzxms.service;
import com.xzx.xzxms.bean.InquiryPool;
import com.xzx.xzxms.bean.extend.ProPoolExtend;

import java.util.List;

public interface IInquiryPoolService {

    /**
     * 查询
     * @param name  询价名
     * @param brand 供应商报价品牌
     //* @param choose 选用标识
     * @return
     */
    List<InquiryPool> findByParams(String name, String brand);
}
