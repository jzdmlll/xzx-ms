package com.xzx.xzxms.equipment.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.equipment.bean.EquipmentOrderStatus;
import com.xzx.xzxms.equipment.dto.EquipmentInStorageDTO;
import com.xzx.xzxms.equipment.dto.EquipmentInStorageListDTO;
import com.xzx.xzxms.equipment.dto.EquipmentOrderStatusDTO;
import com.xzx.xzxms.equipment.dto.EquipmentSignDTO;
import com.xzx.xzxms.equipment.service.EquipmentSignManagementService;
import com.xzx.xzxms.equipment.vo.EquipmentSignVO;
import com.xzx.xzxms.equipment.vo.EquipmentStorageVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：ZJW
 * @title：签收入库界面
 * @date：2021/2/5 10:32
 * @修改人：
 * @修改时间：2021/2/5 10:32
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/equipment/equipmentSignManagement")
public class EquipmentSignManagementController {

    @Autowired
    private EquipmentSignManagementService equipmentSignManagementService;

    // 周嘉玮
    @ApiOperation("new 1、根据前端所传条件查询需签收、入库的购买项信息")
    @GetMapping("findSignInfos")
    public Message findSignInfos(EquipmentSignDTO equipmentSignDTO){
        List<EquipmentSignVO> signInfos = equipmentSignManagementService.findSignInfosService(equipmentSignDTO);
        return MessageUtil.success("success", signInfos);
    }

    // 周嘉玮
    @ApiOperation("new 2.1、单个签收  Single（单个）")
    @PostMapping("insertEquipmentOrderStatusSingle")
    public Message insertEquipmentOrderStatusSingle(EquipmentOrderStatus equipmentOrderStatus){
        String result = equipmentSignManagementService.insertEquipmentOrderStatusSingleService(equipmentOrderStatus);
        return MessageUtil.success(result);
    }

    // 周嘉玮
    @ApiOperation("new 2.2、订单签收（批量）")
    @PostMapping("insertEquipmentOrderStatus")
    public Message insertEquipmentOrderStatus(EquipmentOrderStatusDTO equipmentOrderStatusDTOS){
        String result = equipmentSignManagementService.insertEquipmentOrderStatusService(equipmentOrderStatusDTOS);
        return MessageUtil.success(result);
    }

    // 周嘉玮
    @ApiOperation("new 3.1、入库（单个）")
    @PostMapping("insertEquipmentStorageSingle")
    public Message insertEquipmentStorageSingle(EquipmentInStorageDTO equipmentInStorageDTO){
        String result = equipmentSignManagementService.insertEquipmentStorageSingleService(equipmentInStorageDTO);
        return MessageUtil.success(result);
    }

    // 周嘉玮
    @ApiOperation("new 3.2、入库（批量）")
    @PostMapping("insertEquipmentStorageSingle")
    public Message insertEquipmentStorage(EquipmentInStorageListDTO equipmentInStorageListDTO){
        String result = equipmentSignManagementService.insertEquipmentStorageService(equipmentInStorageListDTO);
        return MessageUtil.success(result);
    }
}
