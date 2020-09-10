package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.dao.extend.SysProDetailExtendMapper;
import com.xzx.xzxms.service.ISysProDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysProDetailServiceImpl implements ISysProDetailService {

    @Resource
    private SysProDetailExtendMapper sysProDetailExtendMapper;

    @Override
    public List<SysProDetailExtend> findById() { return sysProDetailExtendMapper.findById(); }

    @Override
    public SysProDetailExtend findById(long proDetailId) {
        return sysProDetailExtendMapper.findById(proDetailId);
    }
}
