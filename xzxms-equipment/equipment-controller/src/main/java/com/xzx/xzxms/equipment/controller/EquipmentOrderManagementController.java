package com.xzx.xzxms.equipment.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.equipment.bean.EquipmentContractOrder;
import com.xzx.xzxms.equipment.dto.EquipmentContractOrderDTO;
import com.xzx.xzxms.equipment.dto.EquipmentOrderDTO;
import com.xzx.xzxms.equipment.service.EquipmentOrderManagementService;
import com.xzx.xzxms.equipment.vo.EquipmentContractVO;
import com.xzx.xzxms.equipment.vo.EquipmentItemVO;
import com.xzx.xzxms.equipment.vo.EquipmentOrderVO;
import com.xzx.xzxms.equipment.vo.EquipmentProjectVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：ZJW
 * @title：订单跟踪界面
 * @date：2021/1/24 14:48
 * @修改人：
 * @修改时间：2021/1/24 14:48
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/equipment/equipmentOrderManagement")
public class EquipmentOrderManagementController {

    @Autowired
    private EquipmentOrderManagementService equipmentOrderManagementService;

    // 周嘉玮
    @ApiOperation("1、获取所有的采购项目名，及其id")
    @GetMapping("findAllPurchaseProject")
    public Message findAllPurchaseProject(){
        List<EquipmentProjectVO> allPurchaseProjects = equipmentOrderManagementService.findAllPurchaseProjectService();
        return MessageUtil.success("success", allPurchaseProjects);
    }

    // 周嘉玮
    @ApiOperation("2、根据项目id查询该项目下所有已生效合同")
    @GetMapping("findAllEffectContractsByProjectId")
    public Message findAllEffectContractsByProjectId(Long projectId){
        List<EquipmentContractVO> allEffectContracts = equipmentOrderManagementService.findAllEffectContractsByProjectIdService(projectId);
        return MessageUtil.success("success", allEffectContracts);
    }

    // 周嘉玮
    @ApiOperation("3、根据合同id查询该合同下所有购买项信息")
    @GetMapping("findAllItemInfosByContractId")
    public Message findAllItemInfosByContractId(Long contractId){
        List<EquipmentItemVO> allItemInfos = equipmentOrderManagementService.findAllItemInfosByContractIdService(contractId);
        return MessageUtil.success("success", allItemInfos);
    }

    // 周嘉玮
    @ApiOperation("4.1、新添合同订单跟踪信息")
    @PostMapping("insertEquipmentContractOrder")
    public Message insertEquipmentContractOrder(EquipmentContractOrderDTO equipmentContractOrderDTO){
        String result = equipmentOrderManagementService.insertEquipmentContractOrderService(equipmentContractOrderDTO);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    // 周嘉玮
    @ApiOperation("4.2、根据合同id获取该合同的订单跟踪信息")
    @GetMapping("findEquipmentContractOrderInfoByContractId")
    public Message findEquipmentContractOrderInfoByContractId(Long contractId){
        List<EquipmentContractOrder> equipmentContractOrderInfo = equipmentOrderManagementService.findEquipmentContractOrderInfoByContractIdService(contractId);
        return MessageUtil.success("success", equipmentContractOrderInfo);
    }

    // 周嘉玮
    @ApiOperation("4.3、新添购买项订单跟踪")
    @PostMapping("insertEquipmentOrder")
    public Message insertEquipmentOrder(EquipmentOrderDTO equipmentOrderDTO){
        String result = equipmentOrderManagementService.insertEquipmentOrderService(equipmentOrderDTO);
        if (result.equals("success")){
            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("error");
        }
    }

    // 周嘉玮
    @ApiOperation("4.4、获取购买项订单跟踪详情")
    @GetMapping("findEquipmentOrderInfoByItemId")
    public Message findEquipmentOrderInfoByItemId(Long itemId){
        EquipmentOrderVO equipmentOrderInfo = equipmentOrderManagementService.findEquipmentOrderInfoByItemIdService(itemId);
        return MessageUtil.success("success", equipmentOrderInfo);
    }

    // 周嘉玮
//    @ApiOperation("5.1、单个签收  Single（单个）")
//    @PostMapping("insertEquipmentOrderStatusSingle")
//    public Message insertEquipmentOrderStatusSingle(EquipmentOrderStatus equipmentOrderStatus){
//        String result = equipmentOrderManagementService.insertEquipmentOrderStatusSingleService(equipmentOrderStatus);
//        if (result.equals("success")){
//            return MessageUtil.success("success");
//        }else {
//            return MessageUtil.error("error");
//        }
//    }

    // 周嘉玮
//    @ApiOperation("5.2、订单签收（批量）选择批量操作默认认为所选择的购买项：全部到货，并且全部合格，并且为同一个人签收，同一时刻到货")
//    @PostMapping("insertEquipmentOrderStatus")
//    public Message insertEquipmentOrderStatus(EquipmentOrderStatusDTO equipmentOrderStatusDTOS){
//        String result = equipmentOrderManagementService.insertEquipmentOrderStatusService(equipmentOrderStatusDTOS);
//        if (result.equals("success")){
//            return MessageUtil.success("success");
//        }else {
//            return MessageUtil.error("error");
//        }
//    }
}
