package com.xzx.xzxms.equipment.dto;

import com.xzx.xzxms.equipment.bean.EquipmentInStorage;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/3 21:05
 * @修改人：
 * @修改时间：2021/2/3 21:05
 * @修改描述：默认描述
 */
public class EquipmentInStorageListDTO {
    private EquipmentInStorage equipmentInStorage;
    private List<Long> orderId;

    public EquipmentInStorage getEquipmentInStorage() {
        return equipmentInStorage;
    }

    public void setEquipmentInStorage(EquipmentInStorage equipmentInStorage) {
        this.equipmentInStorage = equipmentInStorage;
    }

    public List<Long> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<Long> orderId) {
        this.orderId = orderId;
    }
}
