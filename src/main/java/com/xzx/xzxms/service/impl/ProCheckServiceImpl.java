package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.service.ISysProCheckService;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProCheckServiceImpl implements ISysProCheckService {

    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private SysProCheckExtendMapper sysProCheckExtendMapper;

    @Override
    public List<SysProCheckExtend> cascadeFindAllByCheckName(String checkName, int[] checkStatus, long proDetailId) {
        return sysProCheckExtendMapper.cascadeFindAllByCheckName(checkName, checkStatus, proDetailId);
    }


    @Transactional
    @Override
    public void UpdateCheckStatus(Integer status, long[] ids, long operator) {
        SysProCheck sysProCheck = new SysProCheck();
        for (long id : ids){
            sysProCheck.setId(id);
            sysProCheck.setCheckStatus(status);
            sysProCheck.setOperator(operator);
            sysProCheck.setTime(new Date().getTime());
            sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
        }
    }

}
