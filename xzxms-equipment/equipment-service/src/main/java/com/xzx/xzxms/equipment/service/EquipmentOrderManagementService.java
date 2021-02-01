package com.xzx.xzxms.equipment.service;

import com.xzx.xzxms.equipment.bean.EquipmentContractOrder;
import com.xzx.xzxms.equipment.bean.EquipmentOrder;
import com.xzx.xzxms.equipment.bean.EquipmentOrderStatus;
import com.xzx.xzxms.equipment.dto.EquipmentOrderStatusDTO;
import com.xzx.xzxms.equipment.vo.EquipmentContractVO;
import com.xzx.xzxms.equipment.vo.EquipmentItemVO;
import com.xzx.xzxms.equipment.vo.EquipmentOrderVO;
import com.xzx.xzxms.equipment.vo.EquipmentProjectVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/24 12:05
 * @修改人：
 * @修改时间：2021/1/24 12:05
 * @修改描述：默认描述
 */
@Repository
public interface EquipmentOrderManagementService {
    /**
     * 周嘉玮
     * 1、获取所有的采购项目名，及其id
     */
    List<EquipmentProjectVO> findAllPurchaseProjectService();

    /**
     * 周嘉玮
     * 2、根据项目id查询该项目下所有已生效合同
     */
    List<EquipmentContractVO> findAllEffectContractsByProjectIdService(Long projectId);

    /**
     * 周嘉玮
     * 3、根据合同id查询该合同下所有购买项信息
     */
    List<EquipmentItemVO> findAllItemInfosByContractIdService(Long contractId);

    /**
     * 周嘉玮
     * 4.1、新添合同订单跟踪信息
     */
    String insertEquipmentContractOrderService(EquipmentContractOrder equipmentContractOrder);

    /**
     * 周嘉玮
     * 4.2、根据合同id获取该合同的订单跟踪信息
     */
    List<EquipmentContractOrder> findEquipmentContractOrderInfoByContractIdService(Long contractId);

    /**
     * 周嘉玮
     * 4.3、新添购买项订单跟踪
     */
    String insertEquipmentOrderService(List<EquipmentOrder> equipmentOrders);

    /**
     * 周嘉玮
     * 4.4、获取购买项订单跟踪详情
     */
    EquipmentOrderVO findEquipmentOrderInfoByItemIdService(Long itemId);


//    /**
//     * 周嘉玮
//     * 5.1、单个签收  Single（单个）
//     */
//    String insertEquipmentOrderStatusSingleService(EquipmentOrderStatus equipmentOrderStatus);
//
//    /**
//     * 周嘉玮
//     * 5.2、订单签收（批量）
//     * 选择批量操作默认认为所选择的购买项：全部到货，并且全部合格，并且为同一个人签收，同一时刻到货
//     */
//    String insertEquipmentOrderStatusService(EquipmentOrderStatusDTO equipmentOrderStatusDTOS);
}
