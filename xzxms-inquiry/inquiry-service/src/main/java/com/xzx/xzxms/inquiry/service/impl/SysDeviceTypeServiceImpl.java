package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.dao.SysDeviceTypeMapper;
import com.xzx.xzxms.inquiry.dao.extend.SysDeviceTypeExtendMapper;
import com.xzx.xzxms.inquiry.service.ISysDeviceTypeService;
import com.xzx.xzxms.inquiry.bean.SysDeviceType;
import com.xzx.xzxms.inquiry.bean.SysDeviceTypeExample;
import com.xzx.xzxms.inquiry.vm.SysDeviceTypeTree;
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
    public List<SysDeviceTypeTree> findDeviceTypeTree() {
        return sysDeviceTypeExtendMapper.findPrivilegeTree();
    }

    @Override
    public List<SysDeviceType> findByParentId(Long parentId, String name, String code) {
        SysDeviceTypeExample example = new SysDeviceTypeExample();
        if(parentId == null){
            example.createCriteria().andParentIdIsNull().andNameLike("%"+name+"%").andCodeLike("%"+code+"%");
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }

        return sysDeviceTypeMapper.selectByExample(example);
    }

    @Override
    public SysDeviceType findById(long deviceTypeId) {

        SysDeviceType sysDeviceType = sysDeviceTypeMapper.selectByPrimaryKey(deviceTypeId);
        return sysDeviceType;
    }

    @Override
    public void saveOrUpdate(SysDeviceType sysDeviceType) {

        if (sysDeviceType.getId()!=null){
            sysDeviceTypeMapper.updateByPrimaryKeySelective(sysDeviceType);
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
