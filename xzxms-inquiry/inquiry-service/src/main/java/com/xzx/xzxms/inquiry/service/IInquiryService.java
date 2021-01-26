package com.xzx.xzxms.inquiry.service;


import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.inquiry.bean.extend.InquiryExtend;
import com.xzx.xzxms.inquiry.dto.InquiryTreeDTO;

import java.sql.SQLException;
import java.util.List;

public interface IInquiryService {
    /**
     * 根据项目id查询所有询价
     * @return
     */
    List<InquiryExtend> findByProDetailId(Long proDetailId, String name, String model);

    /**
     * 查询所有询价
     * @return
     */
    List<InquiryExtend> findAll();

    /**
     * 批量导入
     * @param inquiryList
     */

    void batchAddInquiry(List<Inquiry> inquiryList) throws SQLException;

    /**
     * sunny
     *询价excel树结构导入
     * @param inquiryTreeDTO
     */
    void batchAddInquiryTree(InquiryTreeDTO inquiryTreeDTO);

    /**
     * 行内编辑保存
     * @param inquiry
     */
    void rowSave(Inquiry inquiry);

    /**
     * 批量置为无效（假删）
     * @param ids
     */
    void batchSetInvalid(Long[] ids);

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
    void insertInquiry(Inquiry inquiry);

    /**
     * 终审修改拟定报价
     * @param inquiry
     */
    void finallyUpdateDraft(Inquiry inquiry);

    /**
     * 修改询价设备类型
     * @param inquiryIds 询价ids
     * @param codeId  设备编码ID
     */
    void modifyDeviceType(long[] inquiryIds, long codeId);
}
