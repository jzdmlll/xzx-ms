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
        SysProOriginExample example = new SysProOriginExample();
        example.createCriteria().andIsActiveEqualTo(1);
        return sysProOriginMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(SysProOrigin proOrigin) {
        if(proOrigin.getId() != null){
            SysProOriginExample example = new SysProOriginExample();
            example.createCriteria().andCodeEqualTo(proOrigin.getCode()).andIsActiveEqualTo(1);
            List<SysProOrigin> list = sysProOriginMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该项目编码已被使用，请重新输入!");
            }
            sysProOriginMapper.updateByPrimaryKeySelective(proOrigin);
        }else {
            SysProOriginExample example = new SysProOriginExample();
            example.createCriteria().andNameEqualTo(proOrigin.getName()).andIsActiveEqualTo(1);
            List<SysProOrigin> list = sysProOriginMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该项目来源已存在，请勿重复插入!");
            }
            proOrigin.setId(IDUtils.getId());
            proOrigin.setIsActive(1);
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
