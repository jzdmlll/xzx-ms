package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.system.bean.SysLog;
import com.xzx.xzxms.system.bean.SysLogExample;
import com.xzx.xzxms.system.dao.SysLogMapper;
import org.springframework.stereotype.Service;
import com.xzx.xzxms.system.service.ISysLogService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public List<SysLog> findAll() {
        List<SysLog> sysLogExamples=sysLogMapper.selectByExampleWithBLOBs(new SysLogExample());
        return sysLogExamples;
    }

    @Override
    public List<SysLog> findById(long logId) {
        return null;
    }

    @Override
    public void record(SysLog sysLog) {

    }

    @Override
    public void setInvalid(long[] ids) {

    }

    @Override
    public void delete(long[] ids) {

    }
}
