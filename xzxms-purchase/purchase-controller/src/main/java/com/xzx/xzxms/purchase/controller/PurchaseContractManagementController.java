package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractManagementExtendMapper;
import com.xzx.xzxms.purchase.dto.PurchaseContractDTO;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import com.xzx.xzxms.purchase.vo.PurchaseContractGenerateVO;
import com.xzx.xzxms.purchase.vo.PurchaseContractVO;
import com.xzx.xzxms.purchase.vo.PurchaseProjectVO;
import com.xzx.xzxms.system.bean.SysFile;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    PurchaseContractManagementService purchaseContractManagementService;

    @Resource
    PurchaseContractManagementExtendMapper purchaseContractManagementExtendMapper;

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
        List<PurchaseProjectVO> allProjects = purchaseContractManagementService.findAllProjectsService(projectName);
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
        List<PurchaseContractVO> contractList = purchaseContractManagementService.findContractByProjectId(projectId);
        return MessageUtil.success("success",contractList);
    }

    /**
     * 周嘉玮
     * @param purchaseContract
     * @return
     */
    @ApiOperation("根据合同id修改合同审核级别(送审)")
    @PostMapping("updateContractAuditById")
    public Message updateContractAuditById(PurchaseContract purchaseContract){
        String result = purchaseContractManagementService.updateContractAuditByIdService(purchaseContract);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 周嘉玮
     * @param contractId
     * @return
     */
    @ApiOperation("根据合同id查询所有与其相关的购买项信息")
    @GetMapping("findItemsInfoByContractId")
    public Message findItemsInfoByContractId(@Param("contractId") Long contractId){
        List<PurchaseContractGenerateVO> itemsInfos = purchaseContractManagementExtendMapper.findItemsInfoByContractId(contractId);
        return MessageUtil.success("success",itemsInfos);
    }


    @ApiOperation("根据合同ID查询出合同下所有的文件")
    @GetMapping("findContractFileByContractId")
    public Message findContractFileByContractId(Long contractId){
        List<SysFile> list = purchaseContractServiceImpl.findContractFileByContractId(contractId);
        return MessageUtil.success("success", list);
    }

}
