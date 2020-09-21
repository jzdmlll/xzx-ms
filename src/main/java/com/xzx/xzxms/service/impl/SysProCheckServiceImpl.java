package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.service.ISysProCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysProCheckServiceImpl implements ISysProCheckService {
    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private SysProCheckExtendMapper sysProCheckExtendMapper;

    @Override
    public void inquiryInsert(SysProCheck sysProCheck) {
        sysProCheckMapper.insert(sysProCheck);
    }

    @Override
    public void check(long[] ids,int state) {

        for (long id : ids){
            SysProCheck sysProCheck=new SysProCheck();
            sysProCheck.setId(id);
            sysProCheck.setCheckStatus(state);
            sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
        }
    }

    @Override
    public void revoke(long[] ids) {

    }

    @Override
    public List<SysProCheckExtend> cascadeRoleFindAll() {
        return sysProCheckExtendMapper.cascadeRoleFindAll();
    }

    @Override
    public List<SysProCheckExtend> cascadeFindAllByCheckName(int type, String checkName, int checkStatus, long proDetailId) {
        return sysProCheckExtendMapper.cascadeFindAllByCheckName(type, checkName, checkStatus, proDetailId);
    }


}
