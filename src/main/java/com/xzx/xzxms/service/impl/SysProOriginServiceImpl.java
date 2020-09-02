package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.bean.SysProOriginExample;
import com.xzx.xzxms.dao.SysProOriginMapper;
import com.xzx.xzxms.service.ISysProOriginService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysProOriginServiceImpl  implements ISysProOriginService {
    @Resource
    private SysProOriginMapper sysProOriginMapper;

    @Override
    public List<SysProOrigin> findAll() {
        return sysProOriginMapper.selectByExample(new SysProOriginExample());
    }

    @Override
    public void saveOrUpdate(SysProOrigin proOrigin) {
        if(proOrigin.getId() != null){
            sysProOriginMapper.updateByPrimaryKey(proOrigin);
        }else {
            SysProOriginExample example = new SysProOriginExample();
            example.createCriteria().andNameEqualTo(proOrigin.getName());
            List<SysProOrigin> list = sysProOriginMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该项目来源已存在，请勿重复插入!");
            }
            proOrigin.setId(IDUtils.getId());
            sysProOriginMapper.insert(proOrigin);
        }
    }

    @Override
    public void logicDeleteById(long proOriginId) {
        SysProOrigin proOrigin = new SysProOrigin();
        proOrigin.setId(proOriginId);
        proOrigin.setIsActive(0);
        sysProOriginMapper.updateByPrimaryKeySelective(proOrigin);
    }
}
