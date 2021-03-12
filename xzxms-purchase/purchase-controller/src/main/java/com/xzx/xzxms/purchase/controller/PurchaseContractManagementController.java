package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.dto.PurchaseContractFIleDTO;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import com.xzx.xzxms.purchase.vo.PurchaseContractGenerateNewVO;
import com.xzx.xzxms.purchase.vo.PurchaseContractVO;
import com.xzx.xzxms.purchase.vo.PurchaseProjectVO;
import com.xzx.xzxms.purchase.vo.SupplyByContractIdVO;
import com.xzx.xzxms.system.bean.SysFile;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：ZJW
 * @title：合同管理
 * @date：2020/12/15 19:04
 * @修改人：
 * @修改时间：2020/12/15 19:04
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/purchase/contractManagement")
public class PurchaseContractManagementController {

    @Resource
    private PurchaseContractManagementService purchaseContractManagementServiceImpl;
    @Resource
    private IPurchaseContractService purchaseContractServiceImpl;

    /**
     * 周嘉玮
     * @param projectName
     * @return
     */
    @ApiOperation("根据输入项目名模糊查询")
    @GetMapping("findAllProjects")
    public Message findAllProjects(@Param("projectName") String projectName){
        List<PurchaseProjectVO> allProjects = purchaseContractManagementServiceImpl.findAllProjectsService(projectName);
        return MessageUtil.success("success",allProjects);
    }

    /**
     * 周嘉玮
     * @param projectId
     * @return
     */
    @ApiOperation("根据项目id查询所有与其相关的合同信息")
    @GetMapping("findContractByProjectId")
    public Message findContractByProjectId(@Param("projectId") Long projectId){
        List<PurchaseContractVO> contractList = purchaseContractManagementServiceImpl.findContractByProjectId(projectId);
        return MessageUtil.success("success",contractList);
    }

    /**
     * 周嘉玮
     * @param purchaseContract
     * @return
     */
    @ApiOperation("根据合同id修改合同审核级别(送审)(作废)")
    @PostMapping("updateContractAuditById")
    public Message updateContractAuditById(PurchaseContract purchaseContract){

        purchaseContractManagementServiceImpl.updateContractAuditByIdService(purchaseContract);
        return MessageUtil.success("success");
    }

    /**
     * sunny
     * NEW
     * @param contractId
     * @return
     */
    @ApiOperation("根据合同id查询所有与其相关的购买项信息,一、二、三审核页面")
    @GetMapping("findPurchaseMessageByContractId")
    public Message findPurchaseMessageByContractId(Long contractId, Long startTime, Long overTime, Integer auditStatus, Integer auditLevel){
        List<PurchaseContractGenerateNewVO> itemsInfos = purchaseContractManagementServiceImpl.findPurchaseMessageByContractId(contractId, startTime, overTime, auditStatus, auditLevel);
        return MessageUtil.success("success",itemsInfos);
    }

    @ApiOperation("根据合同ID查询出合同的所有采购项,采购合同管理页面")
    @GetMapping("findSupplyByContractId")
    public Message findSupplyByContractId(Long contractId){
        List<SupplyByContractIdVO> list = purchaseContractServiceImpl.findSupplyByContractId(contractId);
        return MessageUtil.success("success", list);
    }

    @ApiOperation("根据合同ID查询出合同下所有的文件")
    @GetMapping("findContractFileByContractId")
    public Message findContractFileByContractId(Long contractId){
        List<SysFile> list = purchaseContractServiceImpl.findContractFileByContractId(contractId);
        return MessageUtil.success("success", list);
    }

    /**
     * Lzc 合同文件上传
     * @param purchaseContractFIleDTO
     * @return
     */
    @ApiOperation("合同文件上传")
    @PostMapping("uploadContractFile")
    public Message uploadContractFile(@RequestBody PurchaseContractFIleDTO purchaseContractFIleDTO){
        purchaseContractManagementServiceImpl.uploadContractFile(purchaseContractFIleDTO.getPurchaseContract(), purchaseContractFIleDTO.getFileList());
        return MessageUtil.success("success");
    }

    /**
     * sunny
     * 合同生效并上传正式合同等文件
     * @param purchaseContractFIleDTO
     * @return
     */
    @ApiOperation("合同生效并上传正式合同等文件")
    @PostMapping("purchaseContractEffective")
    public Message purchaseContractEffective(@RequestBody PurchaseContractFIleDTO purchaseContractFIleDTO){
        purchaseContractManagementServiceImpl.purchaseContractEffective(purchaseContractFIleDTO.getPurchaseContract(), purchaseContractFIleDTO.getFileList());
        return MessageUtil.success("success");
    }
}
