package com.xzx.xzxms.equipment.service.Impl;

import com.xzx.xzxms.equipment.dao.EquipmentStorageMapper;
import com.xzx.xzxms.equipment.dao.extend.EquipmentStorageManagementExtendMapper;
import com.xzx.xzxms.equipment.service.EquipmentStorageManagementService;
import com.xzx.xzxms.equipment.vo.EquipmentStorageVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/4 15:58
 * @修改人：
 * @修改时间：2021/2/4 15:58
 * @修改描述：默认描述
 */
@Service
public class EquipmentStorageManagementServiceImpl implements EquipmentStorageManagementService {

    @Resource
    EquipmentStorageManagementExtendMapper equipmentStorageManagementExtendMapper;

    /**
     * 周嘉玮
     * new 4、根据所传条件查询库存信息
     */
    @Override
    public List<EquipmentStorageVO> findStorageInfosService(EquipmentStorageVO equipmentStorageVO) {
        List<EquipmentStorageVO> storageInfos = equipmentStorageManagementExtendMapper.findStorageInfos(equipmentStorageVO);
        return storageInfos;
    }

    @Override
    public String insertOutStorageSingleService() {
        return null;
    }
}
