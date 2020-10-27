package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.service.IProCheckService;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProCheckServiceImpl implements IProCheckService {

    @Resource
    private SysProCheckMapper sysProCheckMapper;
    SysProCheck sysProCheck;

    @Transactional
    @Override
    public void InsertQuoteToCheck(String type, List<Long> contentIds, long operator) {
        for (int i =0;i<contentIds.size();i++){
            sysProCheck=new SysProCheck();
            sysProCheck.setId(IDUtils.getId());
            sysProCheck.setCheckStatus(0);
            sysProCheck.setType(type);
            sysProCheck.setRemark("");
            sysProCheck.setContentId(contentIds.get(i));
            sysProCheck.setOperator(operator);
            sysProCheck.setTime(new Date().getTime());
            sysProCheckMapper.insert(sysProCheck);
        }
    }

    @Transactional
    @Override
    public void UpdateCheckStatus(Integer status, List<Long> ids, long operator) {

        for (long id : ids){
            sysProCheck.setId(id);
            sysProCheck.setOperator(operator);
            sysProCheck.setTime(new Date().getTime());
            sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
        }
    }

}
