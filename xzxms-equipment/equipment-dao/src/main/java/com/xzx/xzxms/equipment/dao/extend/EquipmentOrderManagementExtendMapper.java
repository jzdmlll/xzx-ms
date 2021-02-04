package com.xzx.xzxms.equipment.dao.extend;

import com.xzx.xzxms.equipment.vo.EquipmentContractVO;
import com.xzx.xzxms.equipment.vo.EquipmentItemVO;
import com.xzx.xzxms.equipment.vo.EquipmentOrderVO;
import com.xzx.xzxms.equipment.vo.EquipmentProjectVO;

import java.util.List;

/**
 * @author：ZJW
 * @title：设备订单管理界面
 * @date：2021/1/24 11:01
 * @修改人：
 * @修改时间：2021/1/24 11:01
 * @修改描述：默认描述
 */
public interface EquipmentOrderManagementExtendMapper {

    /**
     * 周嘉玮
     * 获取所有的采购项目名，及其id
     */
    List<EquipmentProjectVO> findAllPurchaseProject();

    /**
     * 周嘉玮
     * 根据项目id查询该项目下所有已生效合同
     */
    List<EquipmentContractVO> findAllEffectContractsByProjectId(Long projectId);

    /**
     * 周嘉玮
     * 根据合同id查询该合同下所有购买项信息
     */
    List<EquipmentItemVO> findAllItemInfosByContractId(Long contractId);

    /**
     * 周嘉玮
     * 根据item_id获取其订单跟踪信息
     */
    EquipmentOrderVO findEquipmentOrderInfoByItemId(Long itemId);

    /**
     * 周嘉玮
     * 根据购买项id从purchase_items表中查询该购买项的合同订单跟踪状态
     */
    Integer findContractOrderStatusByItemId(Long id);

//    /**
//     * 周嘉玮
//     * 根据order_id获取其订单跟踪信息
//     */
//    EquipmentOrder findEquipmentOrderInfoByOrderId(Long orderId);
}
