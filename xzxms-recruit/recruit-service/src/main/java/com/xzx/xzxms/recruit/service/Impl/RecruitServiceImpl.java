package com.xzx.xzxms.recruit.service.Impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.recruit.bean.RecruitProject;
import com.xzx.xzxms.recruit.bean.RecruitProjectExample;
import com.xzx.xzxms.recruit.dao.RecruitProjectMapper;
import com.xzx.xzxms.recruit.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/20 14:25
 * @修改人：
 * @修改时间：2021/2/20 14:25
 * @修改描述：默认描述
 */
@Service
public class RecruitServiceImpl implements RecruitService {

    @Resource
    RecruitProjectMapper recruitProjectMapper;

    /**
     * 周嘉玮
     * 0 - 根据招标项目id获取其所有信息（公共）
     */
    @Override
    public RecruitProject findRecruitProjectByIdService(Long id) {
        RecruitProjectExample recruitProjectExample = new RecruitProjectExample();
        recruitProjectExample.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<RecruitProject> recruitProjects = recruitProjectMapper.selectByExample(recruitProjectExample);
        if (recruitProjects.size() == 1){
            RecruitProject recruitProject = recruitProjects.get(0);
            return recruitProject;
        }else {
            return null;
        }
    }

    /**
     * 周嘉玮
     * 1 - 新建招标项目
     */
    @Override
    public String insertRecruitProjectService(RecruitProject recruitProject) {
        recruitProject.setId(IDUtils.getId());
        recruitProject.setIsActive(CommonConstant.EFFECTIVE);
        recruitProject.setTime(new Date().getTime());
        recruitProjectMapper.insert(recruitProject);
        return "success";
    }

    /**
     * 周嘉玮
     * 2 - 修改招标项目信息（公共）
     */
    @Override
    public String updateRecruitProjectService(RecruitProject recruitProject) {
        RecruitProjectExample recruitProjectExample = new RecruitProjectExample();
        recruitProjectExample.createCriteria().andIdEqualTo(recruitProject.getId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        recruitProjectMapper.updateByExampleSelective(recruitProject, recruitProjectExample);
        return "success";
    }

    /**
     * 周嘉玮
     * 2.1 - 修改招标项目的基本信息
     */
    @Override
    public String updateRecruitProjectInfoService(RecruitProject recruitProject) {
        recruitProject.setUpdateTime(new Date().getTime());
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.2.1 - 发往商务审核
     */
    @Override
    public String updateRecruitBusinessService(RecruitProject recruitProject) {
        recruitProject.setBusinessAudit(0);
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.2.2 - 商务审核
     */
    @Override
    public String updateRecruitBusinessAuditService(RecruitProject recruitProject) {
        recruitProject.setBusinessTime(new Date().getTime());
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.3.1 - 发往工程审核
     */
    @Override
    public String updateRecruitEngineeringService(RecruitProject recruitProject) {
        // 根据id获取该招标信息
        RecruitProject recruitProjectInfo = findRecruitProjectByIdService(recruitProject.getId());
        if (recruitProjectInfo != null){
            // 判断是否通过了商审
            if (recruitProjectInfo.getBusinessAudit() == 1){
                // 通过商审才能发往工程审核
                recruitProject.setEngineeringAudit(0);
                String result = updateRecruitProjectService(recruitProject);
                return result;
            }else {
                return "请先完成商审";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.3.2 - 工程审核
     */
    @Override
    public String updateRecruitEngineeringAuditService(RecruitProject recruitProject) {
        recruitProject.setEngineeringTime(new Date().getTime());
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.4.1 - 发往发布审核
     */
    @Override
    public String updateRecruitReleaseService(RecruitProject recruitProject) {
        // 根据id获取该招标信息
        RecruitProject recruitProjectInfo = findRecruitProjectByIdService(recruitProject.getId());
        if (recruitProjectInfo != null){
            // 判断是否通过了工程审核
            if (recruitProjectInfo.getEngineeringAudit() == 1){
                // 通过工程审核才能发往发布审核
                recruitProject.setReleaseAudit(0);
                String result = updateRecruitProjectService(recruitProject);
                return result;
            }else {
                return "请先完成工程审核";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.4.2 - 发布审核
     */
    @Override
    public String updateRecruitReleaseAuditService(RecruitProject recruitProject) {
        recruitProject.setReleaseTime(new Date().getTime());
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.5.1 - 发往投标公司资质审核
     */
    @Override
    public String updateRecruitQualificationService(RecruitProject recruitProject) {
        // 根据id获取该招标信息
        RecruitProject recruitProjectInfo = findRecruitProjectByIdService(recruitProject.getId());
        if (recruitProjectInfo != null){
            // 判断是否通已发布招标信息
            if (recruitProjectInfo.getReleaseAudit() == 1){
                // 发布了招标信息，才可以发送 对投标公司的资质审查
                recruitProject.setQualificationAudit(0);
                String result = updateRecruitProjectService(recruitProject);
                return result;
            }else {
                return "请先发布招标信息";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.5.2 - 投标公司资质审核
     */
    @Override
    public String updateRecruitQualificationAuditService(RecruitProject recruitProject) {
        recruitProject.setQualificationTime(new Date().getTime());
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.6.1 - 发往评标、开标审核
     */
    @Override
    public String updateRecruitBidEvaluationService(RecruitProject recruitProject) {
        // 根据id获取该招标信息
        RecruitProject recruitProjectInfo = findRecruitProjectByIdService(recruitProject.getId());
        if (recruitProjectInfo != null){
            // 判断投标公司资质审核是否通过
            if (recruitProjectInfo.getQualificationAudit() == 1){
                // 发布了招标信息，才可以发送 对投标公司的资质审查
                recruitProject.setBidEvaluationAudit(0);
                String result = updateRecruitProjectService(recruitProject);
                return result;
            }else {
                return "投标公司资质审核未通过或未审核";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.6.2 - 评标、开标审核
     */
    @Override
    public String updateRecruitBidEvaluationAuditService(RecruitProject recruitProject) {
        recruitProject.setBidEvaluationTime(new Date().getTime());
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.7.1 - 发往汇总评标报告审核
     */
    @Override
    public String updateRecruitReportService(RecruitProject recruitProject) {
        // 根据id获取该招标信息
        RecruitProject recruitProjectInfo = findRecruitProjectByIdService(recruitProject.getId());
        if (recruitProjectInfo != null){
            // 判断评标、开标审核是否通过
            if (recruitProjectInfo.getBidEvaluationAudit() == 1){
                // 评标、开标审核通过了，才可以发送 汇总评标报告审
                recruitProject.setReportAudit(0);
                String result = updateRecruitProjectService(recruitProject);
                return result;
            }else {
                return "评标、开标审核未通过或未审核";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.7.2 - 汇总评标报告审核
     */
    @Override
    public String updateRecruitReportAuditService(RecruitProject recruitProject) {
        recruitProject.setReportTime(new Date().getTime());
        String result = updateRecruitProjectService(recruitProject);
        return result;
    }

    /**
     * 周嘉玮
     * 3 - 更新中标人
     */
    @Override
    public String updateRecruitSuccessfulBidderService(RecruitProject recruitProject) {
        // 根据id获取该招标信息
        RecruitProject recruitProjectInfo = findRecruitProjectByIdService(recruitProject.getId());
        if (recruitProjectInfo != null){
            // 汇总评标报告审核是否通过
            if (recruitProjectInfo.getReportAudit() == 1){
                // 汇总评标报告审核通过了，才可以上传中标人信息
                recruitProject.setBidTime(new Date().getTime());
                String result = updateRecruitProjectService(recruitProject);
                return result;
            }else {
                return "汇总评标报告未通过或未审核";
            }
        }else {
            return "error";
        }
    }


}
