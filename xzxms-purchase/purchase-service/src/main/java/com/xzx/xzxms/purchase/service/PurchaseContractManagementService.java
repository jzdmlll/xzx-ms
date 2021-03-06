package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.vo.PurchaseContractGenerateNewVO;
import com.xzx.xzxms.purchase.vo.PurchaseContractVO;
import com.xzx.xzxms.purchase.vo.PurchaseProjectVO;
import com.xzx.xzxms.system.bean.SysFile;
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
     * 周嘉玮
     * 查找所有符合条件的项目
     * @param projectName
     * @return
     */
    List<PurchaseProjectVO> findAllProjectsService(String projectName);

    /**
     * 周嘉玮
     * 根据项目id去查找其所有相关的合同信息
     * @param projectId
     * @return
     */
    List<PurchaseContractVO> findContractByProjectId(Long projectId);

    /**
     * 周嘉玮
     * 根据合同id修改合同审核级别
     * @param purchaseContract
     * @return
     */
    String updateContractAuditByIdService(PurchaseContract purchaseContract);

    /**
     * Lzc 采购合同文件上传
     * @param purchaseContract
     * @param fileList
     */
    void uploadContractFile(PurchaseContract purchaseContract, List<SysFile> fileList);

    /**
     * sunny
     * 采购合同正式生效
     * @param purchaseContract
     * @param fileList
     */
    void purchaseContractEffective(PurchaseContract purchaseContract, List<SysFile> fileList);

    /**
     * 一、二、三级合同审核页面（根据采购合同查询采购信息）
     * @param contractId
     * @return
     */
    List<PurchaseContractGenerateNewVO> findPurchaseMessageByContractId(Long contractId);

}
