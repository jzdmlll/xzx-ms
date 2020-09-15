package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.InquiryWithBLOBs;

import java.util.List;

public interface IInquiryService {

    /**
     * 根据项目详情的ID查询相对应的询价全部内容
     * @param proId
     * @return
     */
    List<InquiryWithBLOBs> findByProDetailId(long proId);

    /**
     * 保存或更改询价内容
     * @param inquiry
     */
    void saveOrUpdate(InquiryWithBLOBs inquiry);

    /**
     * 批量置为无效
     * @param ids
     */
    void setInvalid(long[] ids);

    /**
     * 批量删除
     * @param ids
     */
    void delete(long[] ids);
}
