package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.purchase.dao.extend.PurchaseContractManagementExtendMapper;
import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import com.xzx.xzxms.purchase.vo.PurchaseContractVO;
import com.xzx.xzxms.purchase.vo.PurchaseProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/15 20:03
 * @修改人：
 * @修改时间：2020/12/15 20:03
 * @修改描述：默认描述
 */
@Service
@Repository
public class PurchaseContractManagementServiceImpl implements PurchaseContractManagementService {

    @Autowired
    PurchaseContractManagementExtendMapper purchaseContractManagementExtendMapper;

    /**
     * 查找所有符合条件的项目
     * @param projectName
     * @return
     */
    @Override
    public List<PurchaseProjectVO> findAllProjectsService(String projectName) {
        List<PurchaseProjectVO> allProjects = purchaseContractManagementExtendMapper.findAllProjects(projectName);
        return allProjects;
    }

    /**
     * 根据项目id去查找其所有相关的合同信息
     * @param project_id
     * @return
     */
    @Override
    public List<PurchaseContractVO> findContractByProjectId(Long project_id) {
        List<PurchaseContractVO> contractList = purchaseContractManagementExtendMapper.findContractByProjectId(project_id);
        return contractList;
    }

    /**
     * 根据合同id修改合同审核级别
     * @param firstAudit
     * @param secondAudit
     * @param threeAudit
     * @param id
     * @return
     */
    @Override
    public String updateContractAuditByIdService(Integer firstAudit, Integer secondAudit, Integer threeAudit, Long id) {
        purchaseContractManagementExtendMapper.updateContractAuditById(firstAudit, secondAudit, threeAudit, id);
        return "success";
    }
}
