package com.xzx.xzxms.equipment.dto;

import com.xzx.xzxms.equipment.bean.EquipmentOutStorage;

import java.util.List;

/**
 * @author：ZJW
 * @title：单个出库
 * @date：2021/2/4 16:59
 * @修改人：
 * @修改时间：2021/2/4 16:59
 * @修改描述：默认描述
 */
public class EquipmentOutStorageDTO {
    private EquipmentOutStorage equipmentOutStorage;
    private List<Long> storageIds;

    public EquipmentOutStorage getEquipmentOutStorage() {
        return equipmentOutStorage;
    }

    public void setEquipmentOutStorage(EquipmentOutStorage equipmentOutStorage) {
        this.equipmentOutStorage = equipmentOutStorage;
    }

    public List<Long> getStorageIds() {
        return storageIds;
    }

    public void setStorageIds(List<Long> storageIds) {
        this.storageIds = storageIds;
    }
}
