package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.service.impl.PurchaseContractManagementServiceImpl;
import com.xzx.xzxms.purchase.vm.PurchaseContractVM;
import com.xzx.xzxms.purchase.vm.PurchaseProjectVM;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/15 19:04
 * @修改人：
 * @修改时间：2020/12/15 19:04
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/purchase/contractManagement")
public class PurchaseContractManagementController {

    @Autowired
    PurchaseContractManagementServiceImpl purchaseContractManagementService;

    @ApiOperation("根据输入项目名模糊查询")
    @GetMapping("findAllProjects")
    public Message findAllProjects(@Param("projectName") String projectName){
        List<PurchaseProjectVM> allProjects = purchaseContractManagementService.findAllProjectsService(projectName);
        return MessageUtil.success("success",allProjects);
    }

    @ApiOperation("根据项目id查询所有与其相关的合同信息")
    @GetMapping("findContractByProjectId")
    public Message findContractByProjectId(@Param("projectId") Long projectId){
        List<PurchaseContractVM> contractList = purchaseContractManagementService.findContractByProjectId(projectId);
        return MessageUtil.success("success",contractList);
    }

    @ApiOperation("根据合同id修改合同审核级别")
    @GetMapping("updateContractAuditById")
    public Message updateContractAuditById(@Param("firstAudit") Integer firstAudit, @Param("secondAudit") Integer secondAudit, @Param("threeAudit") Integer threeAudit, @Param("id") Long id){
        String result = purchaseContractManagementService.updateContractAuditByIdService(firstAudit, secondAudit, threeAudit, id);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

}
