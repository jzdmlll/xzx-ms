package com.xzx.xzxms.equipment.service.Impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.equipment.bean.EquipmentOutStorage;
import com.xzx.xzxms.equipment.bean.EquipmentStorage;
import com.xzx.xzxms.equipment.bean.EquipmentStorageExample;
import com.xzx.xzxms.equipment.dao.EquipmentOutStorageMapper;
import com.xzx.xzxms.equipment.dao.EquipmentStorageMapper;
import com.xzx.xzxms.equipment.dao.extend.EquipmentStorageManagementExtendMapper;
import com.xzx.xzxms.equipment.dto.EquipmentOutStorageListDTO;
import com.xzx.xzxms.equipment.service.EquipmentStorageManagementService;
import com.xzx.xzxms.equipment.vo.EquipmentStorageVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
    private EquipmentStorageManagementExtendMapper equipmentStorageManagementExtendMapper;

    @Resource
    private EquipmentStorageMapper equipmentStorageMapper;

    @Resource
    private EquipmentOutStorageMapper equipmentOutStorageMapper;

    /**
     * 周嘉玮
     * new 4、根据所传条件查询库存信息
     */
    @Override
    public List<EquipmentStorageVO> findStorageInfosService(EquipmentStorageVO equipmentStorageVO) {
        List<EquipmentStorageVO> storageInfos = equipmentStorageManagementExtendMapper.findStorageInfos(equipmentStorageVO);
        return storageInfos;
    }

    /**
     * new 5.1、单个出库
     */
    @Transactional
    @Override
    public String insertOutStorageSingleService(EquipmentOutStorage equipmentOutStorage) {
        if (equipmentOutStorage != null){
            if (equipmentOutStorage.getOutNumber() > 0){
                // 获取库存id
                Long storageId = equipmentOutStorage.getStorageId();

                // 根据storageId获取该库存信息
                EquipmentStorageExample equipmentStorageExample = new EquipmentStorageExample();
                equipmentStorageExample.createCriteria().andIdEqualTo(storageId).andIsActiveEqualTo(1);
                List<EquipmentStorage> equipmentStorages = equipmentStorageMapper.selectByExample(equipmentStorageExample);

                if (equipmentStorages.size() > 0){
                    // 由于storageId是唯一的
                    EquipmentStorage equipmentStorage = equipmentStorages.get(0);
                    // 判断该设备是否还有库存
                    if (equipmentStorage.getNumber() > 0){
                        // 判断库存是否足够
                        if (equipmentStorage.getNumber() >= equipmentOutStorage.getOutNumber()){
                            // 库存剩余
                            Double storageNum = equipmentStorage.getNumber() - equipmentOutStorage.getOutNumber();
                            equipmentStorage.setNumber(storageNum);
                            // 更新库存
                            equipmentStorageMapper.updateByExample(equipmentStorage, equipmentStorageExample);

                            // 新增出库记录
                            equipmentOutStorage.setId(IDUtils.getId());
                            equipmentOutStorage.setStorageId(equipmentStorage.getId());
                            equipmentOutStorage.setTime(new Date().getTime());
                            equipmentOutStorage.setIsActive(CommonConstant.EFFECTIVE);
                            equipmentOutStorageMapper.insert(equipmentOutStorage);
                        }else {
                            return "库存量不足，请重新选择出库量！";
                        }
                    }else {
                        return "该设备库存已为0，请刷新页面！";
                    }
                }else {
                    return "该设备无库存信息，请刷新页面！";
                }
                return "success";
            }else {
                return "出库数量不能为0！";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * new 5.2、批量出库
     */
    @Transactional
    @Override
    public String insertOutStorageService(EquipmentOutStorageListDTO equipmentOutStorageListDTO) {
        if (equipmentOutStorageListDTO != null){
            // 获取存库id
            List<Long> storageIds = equipmentOutStorageListDTO.getStorageId();
            if (storageIds.size() > 0){

                // 获取出库信息
                EquipmentOutStorage equipmentOutStorage = equipmentOutStorageListDTO.getEquipmentOutStorage();

                for (Long storageId : storageIds) {
                    // 根据storageId获取该库存信息
                    EquipmentStorageExample equipmentStorageExample = new EquipmentStorageExample();
                    equipmentStorageExample.createCriteria().andIdEqualTo(storageId).andIsActiveEqualTo(1);
                    List<EquipmentStorage> equipmentStorages = equipmentStorageMapper.selectByExample(equipmentStorageExample);
                    if (equipmentStorages.size() > 0){
                        // 由于storageId是唯一的
                        EquipmentStorage equipmentStorage = equipmentStorages.get(0);
                        // 判断该设备是否还有库存
                        if (equipmentStorage.getNumber() > 0){
                            // 将库存全部出库 则 库存剩余量为0
                            Double outStorageNum = equipmentStorage.getNumber();
                            Double storageNum = 0.0;
                            equipmentStorage.setNumber(storageNum);
                            // 更新库存
                            equipmentStorageMapper.updateByExample(equipmentStorage, equipmentStorageExample);

                            // 新增出库记录
                            equipmentOutStorage.setId(IDUtils.getId());
                            equipmentOutStorage.setStorageId(equipmentStorage.getId());
                            equipmentOutStorage.setOutNumber(outStorageNum);
                            equipmentOutStorage.setTime(new Date().getTime());
                            equipmentOutStorage.setIsActive(CommonConstant.EFFECTIVE);
                            equipmentOutStorageMapper.insert(equipmentOutStorage);

                        }else {
                            return "该设备库存已为0，请刷新页面！";
                        }
                    }else {
                        return "该设备无库存信息，请刷新页面！";
                    }
                }
                return "success";
            }else {
                return "请选择出库设备！";
            }
        }else {
            return "error";
        }
    }
}
