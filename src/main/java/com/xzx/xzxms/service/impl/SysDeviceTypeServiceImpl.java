package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysDeviceType;
import com.xzx.xzxms.dao.SysDeviceTypeMapper;
import com.xzx.xzxms.dao.extend.SysDeviceTypeExtendMapper;
import com.xzx.xzxms.service.ISysDeviceTypeService;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDeviceTypeServiceImpl implements ISysDeviceTypeService {

    @Resource
    private SysDeviceTypeMapper sysDeviceTypeMapper;
    @Resource
    private SysDeviceTypeExtendMapper sysDeviceTypeExtendMapper;

    @Override
    public List<SysDeviceType> findAllLike(String name, String code) {

        List<SysDeviceType> sysDeviceTypes= sysDeviceTypeExtendMapper.findAllLike(name, code);
        return sysDeviceTypes;
    }

    @Override
    public SysDeviceType findById(long deviceTypeId) {

        SysDeviceType sysDeviceType=sysDeviceTypeMapper.selectByPrimaryKey(deviceTypeId);
        return sysDeviceType;
    }

    @Override
    public void saveOrUpdate(SysDeviceType sysDeviceType) {

        if (sysDeviceType.getId()!=null){
            sysDeviceTypeMapper.updateByPrimaryKey(sysDeviceType);
        }else {
            sysDeviceType.setId(IDUtils.getId());
            sysDeviceTypeMapper.insert(sysDeviceType);
        }
    }

    @Transactional
    @Override
    public void setInvalid(long[] ids) {

        SysDeviceType sysDeviceType=new SysDeviceType();
        for(long id:ids){
            sysDeviceType.setId(id);
            sysDeviceType.setIsActive(0);
            sysDeviceTypeMapper.updateByPrimaryKeySelective(sysDeviceType);
        }
    }

    @Transactional
    @Override
    public void delete(long[] ids) {

        for(long id:ids){
            sysDeviceTypeMapper.deleteByPrimaryKey(id);
        }
    }
}
