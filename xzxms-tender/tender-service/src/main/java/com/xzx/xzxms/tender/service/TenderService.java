package com.xzx.xzxms.tender.service;

import com.xzx.xzxms.tender.bean.TenderProject;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/24 14:07
 * @修改人：
 * @修改时间：2021/2/24 14:07
 * @修改描述：默认描述
 */
public interface TenderService {
    /**
     * 周嘉玮
     * 0 - 根据投标项目id获取其所有信息（公共）
     */
    TenderProject findTenderProjectByIdService(Long id);

    /**
     * 周嘉玮
     * 1 - 新建投标项目
     */
    String insertTenderProjectService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2 - 修改投标项目信息（公共）
     */
    String updateTenderProjectService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.1 - 修改投标项目的基本信息
     */
    String updateTenderProjectInfoService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.2.1 - 投标信息送审
     */
    String updateBidInfoService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.2.2 - 投标信息审核
     */
    String updateBidInfoAuditService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.3 - 投标报名
     */
    String updateBidApplyService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.4.1 - 技术方案送审
     */
    String updateTechnicalSolutionService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.4.2 - 技术方案审核
     */
    String updateTechnicalSolutionAuditService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.5.1 - 技术文件送审
     */
    String updateTechnicalDocumentationService(TenderProject tenderProject);

    /**
     * 周嘉玮
     * 2.5.2 - 技术文件审核
     */
    String updateTechnicalDocumentationAuditService(TenderProject tenderProject);

    /**
     * 2.6 - 中标
     */
    String updateWinBidService(TenderProject tenderProject);


}
