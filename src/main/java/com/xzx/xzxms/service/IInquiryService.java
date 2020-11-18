package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.extend.InquiryAndProDetailExtend;
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
     * @param proDetailId 项目详情ID
     * @param compare_audit 比价审核状态
     * @return
     */
    List<InquiryAndProDetailExtend> findByProIdOrCompareStatus(long proDetailId, Integer compare_audit);

    /**
     * 批量置为不询价
     * @param ids 询价ID
     * @param status 是否询价状态
     */
    void batchSetIsNotInquiry(long[] ids, Integer status);

    /**
     * 否决询价
     * @param id 询价ID
     */
    void setVeto(long id);

    /**
     * 此条询价选用此条产品池数据
     * @param inquiryId 询价ID
     * @param proPoolId 产品池ID
     * @param operator 操作人
     */
    void inquiryChoosePool(long inquiryId, long proPoolId, long operator);

    /**
     * 新增或修改询价
     * @param inquiry 询价对象
     */
    void insertOrUpdateInquiry(Inquiry inquiry);
}
