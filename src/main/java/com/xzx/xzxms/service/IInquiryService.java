package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Inquiry;

import java.sql.SQLException;
import java.util.List;

public interface IInquiryService {
    /**
     * 根据项目id查询所有询价
     * @return
     */
    List<Inquiry> findByProDetailId(long proDetailId);

    /**
     * 查询所有询价
     * @return
     */
    List<Inquiry> findAll();

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
    List<Inquiry> findByProIdOrCompareStatus(long proDetailId,Integer compareStatus);
}
