package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseMapper;
import com.xzx.xzxms.purchase.service.PurchasePlanService;
import com.xzx.xzxms.purchase.service.impl.PurchaseContractManagementServiceImpl;
import com.xzx.xzxms.purchase.service.impl.PurchasePlanServiceImpl;
import com.xzx.xzxms.purchase.vm.PurchaseItemsVM;
import com.xzx.xzxms.purchase.vm.PurchaseProjectVM;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/21 9:42
 * @修改人：
 * @修改时间：2020/12/21 9:42
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/purchase/purchasePlan")
public class PurchasePlanController {

    @Autowired
    PurchasePlanServiceImpl purchasePlanService;

    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;

    @ApiOperation("根据项目id查询该项目下的所有购买项")
    @GetMapping("findItemsByProjectId")
    public Message findItemsByProjectId(@Param("projectId") String projectId){
        List<PurchaseItemsVM> itemsList = purchasePlanService.findItemsByProjectIdService(projectId);
        return MessageUtil.success("success",itemsList);
    }

    @ApiOperation("根据项目id及其详情项id修改其是否需要询价")
    @GetMapping("updateItemsInquiry")
    public Message updateItemsInquiry(@Param("projectId") String projectId, @Param("idList") List<Long> idList){
//        PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
//        purchaseItemsExample.createCriteria().andProjectIdEqualTo(projectId).andIdIn(idList);
//        PurchaseItems purchaseItems = new PurchaseItems();
//        purchaseItems.setIsInquiry(1);
//        purchaseItemsMapper.updateByExample(purchaseItems, purchaseItemsExample);
        String result = purchasePlanService.updateItemsInquiryService(projectId, idList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

}
