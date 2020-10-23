package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Inquiry;

import java.util.List;

public interface IInquiryService {
    /**
     * 根据项目id查询所有询价
     * @return
     */
    List<Inquiry> findByProDetailId(long proDetailId);
}
