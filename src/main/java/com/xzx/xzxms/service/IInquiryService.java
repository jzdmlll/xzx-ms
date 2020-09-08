package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;

import java.util.List;

public interface IInquiryService {

    /**
     * 根据项目详情的ID查询相对应的询价全部内容
     * @param proId
     * @return
     */
    List<Inquiry> findByProDetailId(long proId);
}
