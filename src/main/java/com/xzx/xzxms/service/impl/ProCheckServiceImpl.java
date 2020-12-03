package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.SysCheckExtend;
import com.xzx.xzxms.dao.QuoteMapper;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.service.ISysProCheckService;
import com.xzx.xzxms.utils.CustomerException;
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

    @Transactional
    @Override
    public void updateTechnicalStatus(List<SysProCheck> sysProChecks) {

        for (SysProCheck sysProCheck : sysProChecks){
            if (0 != sysProCheck.getCompareAudit()){
                throw new CustomerException("已有比价结果，请勿再修改审核状态!");
            }
            sysProCheck.setTime(new Date().getTime());
            sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
        }
    }

    @Override
    public List<SysCheckExtend> findTechnicalCheck(Integer status, long proDetailId) {
        List<SysCheckExtend> list = sysProCheckExtendMapper.cascadeFindTechnical(status, proDetailId);
        return list;
    }

    @Override
    public List<SysCheckExtend> findBusinessCheck(Integer status, long proDetailId) {
        List<SysCheckExtend> list = sysProCheckExtendMapper.cascadeFindBusiness(status, proDetailId);
        return list;
    }
}
