package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.dao.SysProTypeMapper;
import com.xzx.xzxms.inquiry.service.ISysProTypeService;
import com.xzx.xzxms.inquiry.bean.SysProType;
import com.xzx.xzxms.inquiry.bean.SysProTypeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysProTypeServiceImpl implements ISysProTypeService {

    @Resource
    private SysProTypeMapper sysProTypeMapper;

    @Override
    public List<SysProType> findAll() {
        SysProTypeExample example = new SysProTypeExample();

        example.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        example.setOrderByClause("time desc");
        return sysProTypeMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(SysProType proType) {

        if(proType.getId() != null){
            proType.setUpdateTime(new Date().getTime());
            sysProTypeMapper.updateByPrimaryKeySelective(proType);
        }else {
            SysProTypeExample example=new SysProTypeExample();
            example.createCriteria().andNameEqualTo(proType.getName()).andIsActiveEqualTo(1);
            List<SysProType> list=sysProTypeMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该项目分类已存在，请勿重复插入!");
            }

            proType.setId(IDUtils.getId());
            proType.setTime(new Date().getTime());
            proType.setIsActive(1);
            sysProTypeMapper.insert(proType);
        }
    }

    @Override
    public void logicDeleteById(long proTypeId) {
        SysProType proType = new SysProType();
        proType.setId(proTypeId);
        proType.setIsActive(0);
        sysProTypeMapper.updateByPrimaryKeySelective(proType);
    }
}
