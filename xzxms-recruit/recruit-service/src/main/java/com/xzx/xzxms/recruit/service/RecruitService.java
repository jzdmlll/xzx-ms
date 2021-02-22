package com.xzx.xzxms.recruit.service;

import com.xzx.xzxms.recruit.bean.RecruitProject;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/20 14:21
 * @修改人：
 * @修改时间：2021/2/20 14:21
 * @修改描述：默认描述
 */
public interface RecruitService {
    /**
     * 周嘉玮
     * 0 - 根据招标项目id获取其所有信息（公共）
     */
    RecruitProject findRecruitProjectByIdService(Long id);

    /**
     * 周嘉玮
     * 1 - 新建招标项目
     */
    String insertRecruitProjectService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2 - 修改招标项目信息（公共）
     */
    String updateRecruitProjectService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.1 - 修改招标项目的基本信息
     */
    String updateRecruitProjectInfoService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.2.1 - 发往商务审核
     */
    String updateRecruitBusinessService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.2.2 - 商务审核
     */
    String updateRecruitBusinessAuditService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.3.1 - 发往工程审核
     */
    String updateRecruitEngineeringService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.3.2 - 工程审核
     */
    String updateRecruitEngineeringAuditService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.4.1 - 发往发布审核
     */
    String updateRecruitReleaseService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.4.2 - 发布审核
     */
    String updateRecruitReleaseAuditService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.5.1 - 发往投标公司资质审核
     */
    String updateRecruitQualificationService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.5.2 - 投标公司资质审核
     */
    String updateRecruitQualificationAuditService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.6.1 - 发往评标、开标审核
     */
    String updateRecruitBidEvaluationService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.6.2 - 评标、开标审核
     */
    String updateRecruitBidEvaluationAuditService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.7.1 - 发往汇总评标报告审核
     */
    String updateRecruitReportService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 2.7.2 - 汇总评标报告审核
     */
    String updateRecruitReportAuditService(RecruitProject recruitProject);

    /**
     * 周嘉玮
     * 3 - 更新中标人
     */
    String updateRecruitSuccessfulBidderService(RecruitProject recruitProject);
}
