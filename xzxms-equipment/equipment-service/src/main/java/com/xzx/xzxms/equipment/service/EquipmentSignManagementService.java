package com.xzx.xzxms.equipment.service;

import com.xzx.xzxms.equipment.bean.EquipmentOrderStatus;
import com.xzx.xzxms.equipment.bean.EquipmentStorage;
import com.xzx.xzxms.equipment.dto.EquipmentInStorageDTO;
import com.xzx.xzxms.equipment.dto.EquipmentInStorageListDTO;
import com.xzx.xzxms.equipment.dto.EquipmentOrderStatusDTO;
import com.xzx.xzxms.equipment.dto.EquipmentSignDTO;
import com.xzx.xzxms.equipment.vo.EquipmentSignVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/1 10:56
 * @修改人：
 * @修改时间：2021/2/1 10:56
 * @修改描述：默认描述
 */
@Repository
public interface EquipmentSignManagementService {
    /**
     * 周嘉玮
     * new 1、根据前端所传条件查询需签收、入库的购买项信息
     */
    List<EquipmentSignVO> findSignInfosService(EquipmentSignDTO equipmentSignDTO);

    /**
     * 周嘉玮
     * new 2.1、单个签收  Single（单个）
     */
    String insertEquipmentOrderStatusSingleService(EquipmentOrderStatus equipmentOrderStatus);

    /**
     * 周嘉玮
     * new 2.2、订单签收（批量）
     * 选择批量操作默认认为所选择的购买项：全部到货，并且全部合格，并且为同一个人签收，同一时刻到货
     */
    String insertEquipmentOrderStatusService(EquipmentOrderStatusDTO equipmentOrderStatusDTOS);

    /**
     * 周嘉玮
     * new 3.1、入库（单个）
     */
    String insertEquipmentStorageSingleService(EquipmentInStorageDTO equipmentInStorageDTO);

    /**
     * 周嘉玮
     * new 3.2、入库（批量）
     */
    String insertEquipmentStorageService(EquipmentInStorageListDTO equipmentInStorageListDTO);
}
