package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.dao.SysDeviceTypeMapper;
import com.xzx.xzxms.inquiry.dao.extend.SysDeviceTypeExtendMapper;
import com.xzx.xzxms.inquiry.service.ISysDeviceTypeService;
import com.xzx.xzxms.inquiry.bean.SysDeviceType;
import com.xzx.xzxms.inquiry.bean.SysDeviceTypeExample;
import com.xzx.xzxms.inquiry.vm.SysDeviceTypeTree;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

            if (parentId == null) {
                example.createCriteria().andParentIdIsNull().andNameLike("%" + name + "%").andCodeLike("%" + code + "%").andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            } else {
                example.createCriteria().andParentIdEqualTo(parentId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            }

        return sysDeviceTypeMapper.selectByExample(example);
    }

    @Override
    public SysDeviceType findById(long deviceTypeId) {
        SysDeviceTypeExample example = new SysDeviceTypeExample();
        example.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<SysDeviceType> sysDeviceTypes = sysDeviceTypeMapper.selectByExample(example);
        if (sysDeviceTypes.size() > 0){
            return sysDeviceTypes.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void saveOrUpdate(SysDeviceType sysDeviceType) {

        sysDeviceType.setTime(new Date().getTime());

        if (sysDeviceType.getId() != null){
            sysDeviceTypeMapper.updateByPrimaryKeySelective(sysDeviceType);
        }else {
            sysDeviceType.setId(IDUtils.getId());
            sysDeviceType.setIsActive(CommonConstant.EFFECTIVE);
            sysDeviceType.setIsUseful(CommonConstant.IS_NOT_USEFUL);
            sysDeviceTypeMapper.insertSelective(sysDeviceType);
        }
    }

    @Transactional
    @Override
    public void setInvalid(SysDeviceType sysDeviceType) {

        if(sysDeviceType == null && sysDeviceType.getId() == null) {
            throw new CustomerException("失败");
        }
        sysDeviceType.setIsActive(CommonConstant.INVALID);
        sysDeviceType.setTime(new Date().getTime());
        sysDeviceTypeMapper.updateByPrimaryKeySelective(sysDeviceType);
    }
}
