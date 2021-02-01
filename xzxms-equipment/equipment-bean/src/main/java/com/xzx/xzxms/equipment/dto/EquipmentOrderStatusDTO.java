package com.xzx.xzxms.equipment.dto;

import com.xzx.xzxms.equipment.bean.EquipmentOrderStatus;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/26 21:25
 * @修改人：
 * @修改时间：2021/1/26 21:25
 * @修改描述：默认描述
 */
public class EquipmentOrderStatusDTO {
    private EquipmentOrderStatus equipmentOrderStatus;
    private List<Long> orderId;

    public EquipmentOrderStatus getEquipmentOrderStatus() {
        return equipmentOrderStatus;
    }

    public void setEquipmentOrderStatus(EquipmentOrderStatus equipmentOrderStatus) {
        this.equipmentOrderStatus = equipmentOrderStatus;
    }

    public List<Long> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<Long> orderId) {
        this.orderId = orderId;
    }

}
