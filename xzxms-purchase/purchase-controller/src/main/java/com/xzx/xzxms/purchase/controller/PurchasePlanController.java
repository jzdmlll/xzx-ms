package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dto.PurchaseItemsListDTO;
import com.xzx.xzxms.purchase.service.impl.PurchasePlanServiceImpl;
import com.xzx.xzxms.purchase.vo.PurchaseItemsVO;
import com.xzx.xzxms.purchase.vo.PurchaseSupplierVO;
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
    public Message findItemsByProjectId(@Param("projectId") Long projectId){
        
        List<PurchaseItemsVO> itemsList = purchasePlanService.findItemsByProjectIdService(projectId);
        return MessageUtil.success("success",itemsList);
    }

    @ApiOperation("根据项目id及其详情项id修改其是否需要询价")
    @PostMapping("updateItemsInquiry")
    public Message updateItemsInquiry(@Param("projectId") Long projectId, @Param("idList") List<Long> idList){
        String result = purchasePlanService.updateItemsInquiryService(projectId, idList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    @ApiOperation("当购买项需要拆分时")
    @PostMapping("insertItem")
    public Message insertItem(PurchaseItems purchaseItems, @Param("itemNum") int itemNum){
        String result = purchasePlanService.insertItemService(purchaseItems, itemNum);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    @ApiOperation("根据购买项id查找其供应商")
    @GetMapping("findPurchasingSupplierByItemId")
    public Message findPurchasingSupplierByItemId(@Param("id") Long id){
        List<PurchaseSupplierVO> supplierInfo = purchasePlanService.findPurchasingSupplierByItemIdService(id);
        return MessageUtil.success("success",supplierInfo);
    }

    @ApiOperation("添加询价信息")
    @PostMapping("insertInquiryInfo")
    public Message insertInquiryInfo(PurchaseItemsListDTO purchaseItemsList){
        String result = purchasePlanService.insertSysProDetailService(purchaseItemsList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    @ApiOperation("新增单个采购计划项")
    @PostMapping("addPurchaseItem")
    public Message addPurchaseItem(PurchaseItems purchaseItems){

        purchasePlanService.addPurchaseItem(purchaseItems);
        return MessageUtil.success("success");
    }

    @ApiOperation("EXCEL导入采购计划项")
    @PostMapping("excelPurchaseItems")
    public Message excelPurchaseItems(List<PurchaseItems> purchaseItems){

        purchasePlanService.excelPurchaseItems(purchaseItems);
        return MessageUtil.success("success");
    }

    @ApiOperation("修改采购计划项")
    @PostMapping("updatePurchaseItem")
    public Message updatePurchaseItem(PurchaseItems purchaseItems){

        purchasePlanService.updatePurchaseItem(purchaseItems);
        return MessageUtil.success("success");
    }
}
