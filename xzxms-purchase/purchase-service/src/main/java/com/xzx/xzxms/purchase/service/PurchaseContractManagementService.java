package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.vo.PurchaseContractVO;
import com.xzx.xzxms.purchase.vo.PurchaseProjectVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/15 20:01
 * @修改人：
 * @修改时间：2020/12/15 20:01
 * @修改描述：默认描述
 */
@Repository
public interface PurchaseContractManagementService {

    /**
     * 查找所有符合条件的项目
     * @param projectName
     * @return
     */
    List<PurchaseProjectVO> findAllProjectsService(String projectName);

    /**
     * 根据项目id去查找其所有相关的合同信息
     * @param projectId
     * @return
     */
    List<PurchaseContractVO> findContractByProjectId(Long projectId);

    /**
     * 根据合同id修改合同审核级别
     * @param firstAudit
     * @param secondAudit
     * @param threeAudit
     * @param id
     * @return
     */
    String updateContractAuditByIdService(Integer firstAudit, Integer secondAudit, Integer threeAudit, Long id);
}
