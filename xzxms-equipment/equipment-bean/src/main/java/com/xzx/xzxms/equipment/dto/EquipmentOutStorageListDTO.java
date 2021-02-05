package com.xzx.xzxms.equipment.dto;

import com.xzx.xzxms.equipment.bean.EquipmentOutStorage;

import java.util.List;

/**
 * @author：ZJW
 * @title：批量出库
 * @date：2021/2/5 9:45
 * @修改人：
 * @修改时间：2021/2/5 9:45
 * @修改描述：默认描述
 */
public class EquipmentOutStorageListDTO {
    private EquipmentOutStorage equipmentOutStorage;
    private List<Long> storageId;

    public EquipmentOutStorage getEquipmentOutStorage() {
        return equipmentOutStorage;
    }

    public void setEquipmentOutStorage(EquipmentOutStorage equipmentOutStorage) {
        this.equipmentOutStorage = equipmentOutStorage;
    }

    public List<Long> getStorageId() {
        return storageId;
    }

    public void setStorageId(List<Long> storageId) {
        this.storageId = storageId;
    }
}
