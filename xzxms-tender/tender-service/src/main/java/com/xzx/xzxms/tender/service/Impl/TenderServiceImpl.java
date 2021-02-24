package com.xzx.xzxms.tender.service.Impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.tender.bean.TenderProject;
import com.xzx.xzxms.tender.bean.TenderProjectExample;
import com.xzx.xzxms.tender.dao.TenderProjectMapper;
import com.xzx.xzxms.tender.service.TenderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/24 14:08
 * @修改人：
 * @修改时间：2021/2/24 14:08
 * @修改描述：默认描述
 */
@Service
public class TenderServiceImpl implements TenderService {

    @Resource
    TenderProjectMapper tenderProjectMapper;

    /**
     * 周嘉玮
     * 0 - 根据投标项目id获取其所有信息（公共）
     */
    @Override
    public TenderProject findTenderProjectByIdService(Long id) {
        TenderProjectExample tenderProjectExample = new TenderProjectExample();
        tenderProjectExample.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<TenderProject> tenderProjects = tenderProjectMapper.selectByExample(tenderProjectExample);
        if (tenderProjects.size() == 1){
            TenderProject tenderProject = tenderProjects.get(0);
            return tenderProject;
        }else {
            return null;
        }
    }

    /**
     * 周嘉玮
     *  1 - 新建投标项目
     */
    @Override
    public String insertTenderProjectService(TenderProject tenderProject) {
        tenderProject.setId(IDUtils.getId());
        tenderProject.setIsActive(CommonConstant.EFFECTIVE);
        tenderProject.setTime(new Date().getTime());
        tenderProjectMapper.insert(tenderProject);
        return "success";
    }

    /**
     * 周嘉玮
     * 2 - 修改投标项目信息（公共）
     */
    @Transactional
    @Override
    public String updateTenderProjectService(TenderProject tenderProject) {
        TenderProjectExample tenderProjectExample = new TenderProjectExample();
        tenderProjectExample.createCriteria().andIdEqualTo(tenderProject.getId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<TenderProject> tenderProjects = tenderProjectMapper.selectByExample(tenderProjectExample);
        if (tenderProjects.size() == 1){
            tenderProjectMapper.updateByExampleSelective(tenderProject, tenderProjectExample);
            return "success";
        }else if (tenderProjects.size() == 0){
            return "查无此项";
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.1 - 修改投标项目的基本信息
     */
    @Override
    public String updateTenderProjectInfoService(TenderProject tenderProject) {
        tenderProject.setUpdateTime(new Date().getTime());
        String result = updateTenderProjectService(tenderProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.2.1 - 投标信息送审
     */
    @Override
    public String updateBidInfoService(TenderProject tenderProject) {
        tenderProject.setBidInfoAudit(0);
        String result = updateTenderProjectService(tenderProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.2.2 - 投标信息审核
     */
    @Override
    public String updateBidInfoAuditService(TenderProject tenderProject) {
        tenderProject.setBidInfoTime(new Date().getTime());
        String result = updateTenderProjectService(tenderProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.3 - 投标报名
     */
    @Override
    public String updateBidApplyService(TenderProject tenderProject) {
        TenderProject tenderProjectInfo = findTenderProjectByIdService(tenderProject.getId());
        if (tenderProjectInfo != null){
            // 投标信息审核是否通过
            if (tenderProjectInfo.getBidInfoAudit() == 1){
                String result = updateTenderProjectService(tenderProject);
                return result;
            }else {
                return "请先完成投标信息审核";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.4.1 - 技术方案送审
     */
    @Override
    public String updateTechnicalSolutionService(TenderProject tenderProject) {
        TenderProject tenderProjectInfo = findTenderProjectByIdService(tenderProject.getId());
        if (tenderProjectInfo != null){
            // 投标是否报名
            if (tenderProjectInfo.getBidApply() == 1){
                tenderProject.setTechnicalSolutionAudit(0);
                String result = updateTenderProjectService(tenderProject);
                return result;
            }else {
                return "请先完成投标报名";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.4.2 - 技术方案审核
     */
    @Override
    public String updateTechnicalSolutionAuditService(TenderProject tenderProject) {
        tenderProject.setTechnicalSolutionTime(new Date().getTime());
        String result = updateTenderProjectService(tenderProject);
        return result;
    }

    /**
     * 周嘉玮
     * 2.5.1 - 技术文件送审
     */
    @Override
    public String updateTechnicalDocumentationService(TenderProject tenderProject) {
        TenderProject tenderProjectInfo = findTenderProjectByIdService(tenderProject.getId());
        if (tenderProjectInfo != null){
            // 技术方案审核是否通过
            if (tenderProjectInfo.getTechnicalSolutionAudit() == 1){
                tenderProject.setTechnicalDocumentationAudit(0);
                String result = updateTenderProjectService(tenderProject);
                return result;
            }else {
                return "请先完成技术方案审核";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 2.5.2 - 技术文件审核
     */
    @Override
    public String updateTechnicalDocumentationAuditService(TenderProject tenderProject) {
        tenderProject.setTechnicalDocumentationTime(new Date().getTime());
        String result = updateTenderProjectService(tenderProject);
        return result;
    }

    /**
     * 2.6 - 中标
     */
    @Override
    public String updateWinBidService(TenderProject tenderProject) {
        String result = updateTenderProjectService(tenderProject);
        return result;
    }


}
