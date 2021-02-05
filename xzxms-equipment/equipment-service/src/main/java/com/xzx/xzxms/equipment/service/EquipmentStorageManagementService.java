package com.xzx.xzxms.equipment.service;

import com.xzx.xzxms.equipment.vo.EquipmentStorageVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：库存界面
 * @date：2021/2/4 15:26
 * @修改人：
 * @修改时间：2021/2/4 15:26
 * @修改描述：默认描述
 */
@Repository
public interface EquipmentStorageManagementService {
    /**
     * 周嘉玮
     * new 4、根据所传条件查询库存信息
     */
    List<EquipmentStorageVO> findStorageInfosService(EquipmentStorageVO equipmentStorageVO);

    /**
     * new 5.1、单个出库
     * @return
     */
    String insertOutStorageSingleService();
}
