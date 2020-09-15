package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProType;
import com.xzx.xzxms.bean.SysProTypeExample;
import com.xzx.xzxms.dao.SysProTypeMapper;
import com.xzx.xzxms.service.ISysProTypeService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysProTypeServiceImpl implements ISysProTypeService {

    @Resource
    private SysProTypeMapper sysProTypeMapper;

    @Override
    public List<SysProType> findAll() { return sysProTypeMapper.selectByExample(new SysProTypeExample()); }

    @Override
    public void saveOrUpdate(SysProType proType) {

        if(proType.getId() != null){
            sysProTypeMapper.updateByPrimaryKey(proType);
        }else {
            SysProTypeExample example=new SysProTypeExample();
            example.createCriteria().andNameEqualTo(proType.getName());
            List<SysProType> list=sysProTypeMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该项目分类已存在，请勿重复插入!");
            }

            proType.setId(IDUtils.getId());
            sysProTypeMapper.insert(proType);
        }
    }
}
