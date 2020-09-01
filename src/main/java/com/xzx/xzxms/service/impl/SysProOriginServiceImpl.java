package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProOrigin;
import com.xzx.xzxms.bean.SysProOriginExample;
import com.xzx.xzxms.dao.SysProOriginMapper;
import com.xzx.xzxms.service.ISysProOriginService;
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
}
