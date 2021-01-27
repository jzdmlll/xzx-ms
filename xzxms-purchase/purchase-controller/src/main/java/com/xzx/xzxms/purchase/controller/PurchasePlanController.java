package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import com.xzx.xzxms.purchase.dto.PurchaseItemsDTO;
import com.xzx.xzxms.purchase.dto.PurchaseItemsExcelImportDTO;
import com.xzx.xzxms.purchase.dto.PurchaseItemsListDTO;
import com.xzx.xzxms.purchase.service.PurchasePlanService;
import com.xzx.xzxms.purchase.vo.PurchaseItemsVO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private PurchasePlanService purchasePlanServiceImpl;

    /**
     * 周嘉玮
     * @param projectId
     * @return
     */
    @ApiOperation("根据项目id查询该项目下的所有购买项")
    @GetMapping("findItemsByProjectId")
    public Message findItemsByProjectId(@Param("projectId") Long projectId){
        
        List<PurchaseItemsVO> itemsList = purchasePlanServiceImpl.findItemsByProjectIdService(projectId);
        return MessageUtil.success("success",itemsList);
    }

    /**
     * 周嘉玮
     * @param purchaseItemsDTO
     * @return
     */
    @ApiOperation("根据项目id及其详情项id修改其是否需要询价")
    @PostMapping("updateItemsInquiry")
    public Message updateItemsInquiry(@RequestBody PurchaseItemsDTO purchaseItemsDTO){
        String result = purchasePlanServiceImpl.updateItemsInquiryService(purchaseItemsDTO);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 周嘉玮
     * @param purchaseItems
     * @param itemNum
     * @return
     */
    @ApiOperation("当购买项需要拆分时")
    @PostMapping("insertItem")
    public Message insertItem(PurchaseItems purchaseItems, @Param("itemNum") Double itemNum){
        String result = purchasePlanServiceImpl.insertItemService(purchaseItems, itemNum);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 周嘉玮
     * @param id
     * @return
     */
    @ApiOperation("根据购买项id查找其供应商")
    @GetMapping("findPurchasingSupplierByItemId")
    public Message findPurchasingSupplierByItemId(@Param("id") Long id){
        List<PurchaseSupply> supplierInfo = purchasePlanServiceImpl.findPurchasingSupplierByItemIdService(id);
        return MessageUtil.success("success",supplierInfo);
    }

    /**
     * 周嘉玮
     * @param purchaseItemsList
     * @return
     */
    @ApiOperation("添加询价信息")
    @PostMapping("insertInquiryInfo")
    public Message insertInquiryInfo(@RequestBody PurchaseItemsListDTO purchaseItemsList){
        String result = purchasePlanServiceImpl.insertSysProDetailService(purchaseItemsList);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 孙乃裕
     * @param purchaseItems
     * @return
     */
    @ApiOperation("新增单个采购计划项")
    @PostMapping("addPurchaseItem")
    public Message addPurchaseItem(PurchaseItems purchaseItems){

        purchasePlanServiceImpl.addPurchaseItem(purchaseItems);
        return MessageUtil.success("success");
    }

    /**
     * 孙乃裕
     * @param purchaseItems
     * @return
     */
    @ApiOperation("EXCEL导入采购计划项")
    @PostMapping("excelPurchaseItems")
    public Message excelPurchaseItems(@RequestBody PurchaseItemsExcelImportDTO purchaseItems){

        purchasePlanServiceImpl.excelPurchaseItems(purchaseItems);
        return MessageUtil.success("success");
    }

    /**
     * Lzc
     * @param projectId
     * @param serialNum
     * @return
     */
    @ApiOperation("检查采购计划项序号是否存在(查询数量)")
    @GetMapping("checkSerialNumberIsExists")
    public Message checkSerialNumberIsExists(Long projectId, Double serialNum) {
        int num = purchasePlanServiceImpl.checkSerialNumberIsExists(projectId, serialNum);
        return MessageUtil.success("success", num);
    }


    /**
     * sunny
     * @param quoteIds
     * @param operator
     * @return
     */
    @ApiOperation("询价结果发往采购需求")
    @PostMapping("inquiryResultSendPurchase")
    public Message inquiryResultSendPurchase(Long[] quoteIds, Long operator){
        purchasePlanServiceImpl.inquiryResultSendPurchase(quoteIds, operator);
        return MessageUtil.success("success");
    }


    /**
     * Lzc
     * 批量逻辑删除采购项
     * 修改人:tjz
     * @param purchaseItemIds 采购项 ID数组
     */
    @ApiOperation("批量逻辑删除采购项")
    @PostMapping("logicDeletePurchaseItems")
    public Message logicDeletePurchaseItems(Long[] purchaseItemIds,String operator) {
        purchasePlanServiceImpl.logicDeletePurchaseItems(purchaseItemIds,operator);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("从产品池选择完以后，将信息插入purchase_supply")
    @PostMapping("insertSupplyByItem")
    public Message insertSupplyByItem(PurchaseSupply purchaseSupply){
        String result = purchasePlanServiceImpl.insertSupplyByItemService(purchaseSupply);
        if (result.equals("success")){
            return MessageUtil.success("操作成功");
        }else {
            return MessageUtil.error("error");
        }
    }

    @ApiOperation("删除供货商")
    @PostMapping("deletePurchaseSupply")
    public Message deletePurchaseSupply(PurchaseSupply purchaseSupply) {
        purchasePlanServiceImpl.deletePurchaseSupply(purchaseSupply);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("修改供货商")
    @PostMapping("updatePurchaseSupply")
    public Message updatePurchaseSupply(PurchaseSupply purchaseSupply) {
        purchasePlanServiceImpl.updatePurchaseSupply(purchaseSupply);
        return MessageUtil.success("操作成功");
    }
    @ApiOperation("修改采购项")
    @PostMapping("updatePurchaseItems")
    public Message updatePurchaseItems(PurchaseItems purchaseItems) {
        purchasePlanServiceImpl.updatePurchaseItems(purchaseItems);
        return MessageUtil.success("操作成功");
    }

}
