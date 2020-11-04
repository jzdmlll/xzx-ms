package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.extend.InquiryCompareExtend;
import com.xzx.xzxms.bean.extend.InquiryExtend;

import java.sql.SQLException;
import java.util.List;

public interface IInquiryService {
    /**
     * 根据项目id查询所有询价
     * @return
     */
    List<InquiryExtend> findByProDetailId(long proDetailId);

    /**
     * 查询所有询价
     * @return
     */
    List<InquiryExtend> findAll();

    /**
     * 批量导入
     * @param inquiryList
     */

    void batchAddInquiry(List<Inquiry> inquiryList ) throws SQLException;

    /**
     * 行内编辑保存
     * @param inquiry
     */
    void rowSave(Inquiry inquiry);

    /**
     * 批量置为无效（假删）
     * @param ids
     */
    void batchSetInvalid(long[] ids);

    /**
     * 根据项目id/比价状态查询
     * @return
     */
    List<InquiryCompareExtend> findByProIdOrCompareStatus(long proDetailId, Integer compareStatus);
}
