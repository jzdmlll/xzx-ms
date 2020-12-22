package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.service.impl.PurchaseContractManagementServiceImpl;
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
@RequestMapping("/ContractManagement")
public class PurchaseContractManagementController {

    @Autowired
    PurchaseContractManagementServiceImpl purchaseContractManagementService;

    @ApiOperation("根据输入项目名模糊查询")
    @GetMapping("findAllProjects")
    public Message FindAllProjects(@Param("projectName") String projectName){
        List<String> allProjects = purchaseContractManagementService.FindAllProjectsService(projectName);
        return MessageUtil.success("success",allProjects);
    }

}
