package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysLog;
import com.xzx.xzxms.bean.SysLogExample;
import com.xzx.xzxms.dao.SysLogMapper;
import com.xzx.xzxms.service.ISysLogService;
import org.springframework.stereotype.Service;

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
