package com.xzx.xzxms.equipment.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.equipment.service.EquipmentStorageManagementService;
import com.xzx.xzxms.equipment.vo.EquipmentProjectVO;
import com.xzx.xzxms.equipment.vo.EquipmentStorageVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/4 16:36
 * @修改人：
 * @修改时间：2021/2/4 16:36
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/equipment/equipmentStorageManagement")
public class EquipmentStorageManagementController {

    @Autowired
    EquipmentStorageManagementService equipmentStorageManagementService;

    // 周嘉玮
    @ApiOperation("new 4、根据所传条件查询库存信息")
    @GetMapping("findStorageInfos")
    public Message findStorageInfos(EquipmentStorageVO equipmentStorageVO){
        List<EquipmentStorageVO> storageInfosService = equipmentStorageManagementService.findStorageInfosService(equipmentStorageVO);
        return MessageUtil.success("success", storageInfosService);
    }

}
