package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.service.PurchaseContractAuditService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：ZJW
 * @title：合同审核界面
 * @date：2021/1/14 22:33
 * @修改人：
 * @修改时间：2021/1/14 22:33
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/purchase/contractAudit")
public class PurchaseContractAuditController {

    @Autowired
    PurchaseContractAuditService purchaseContractAuditService;

    @ApiOperation("根据合同id修改该合同当前审核级别的信息")
    @PostMapping("updateContractAuditInfoById")
    public Message updateContractAuditInfoById(PurchaseContract purchaseContract){
        String result = purchaseContractAuditService.updateContractAuditInfoByIdService(purchaseContract);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }
}
