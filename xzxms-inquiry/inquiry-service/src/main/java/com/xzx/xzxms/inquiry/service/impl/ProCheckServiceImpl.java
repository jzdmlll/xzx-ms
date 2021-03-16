package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.dao.QuoteMapper;
import com.xzx.xzxms.inquiry.dao.SysProCheckMapper;
import com.xzx.xzxms.inquiry.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.inquiry.service.ISysProCheckService;
import com.xzx.xzxms.inquiry.bean.SysProCheck;
import com.xzx.xzxms.inquiry.bean.extend.SysCheckExtend;
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
            if (sysProCheck.getCompareAudit() != null && 0 != sysProCheck.getCompareAudit()){
                throw new CustomerException("已有比价结果，请勿再修改审核状态!");
            }
            sysProCheck.setTechnicalTime(new Date().getTime());
            sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
        }
    }

    @Override
    public void updateBusinessStatus(List<SysProCheck> sysProChecks) {

        for (SysProCheck sysProCheck : sysProChecks){
            if (sysProCheck.getCompareAudit() !=null && 0 != sysProCheck.getBusinessAudit()){
                throw new CustomerException("已有比价结果，请勿再修改审核状态!");
            }
            sysProCheck.setBusinessTime(new Date().getTime());
            sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
        }
    }

    @Override
    public List<SysCheckExtend> findTechnicalCheck(Integer status, long proDetailId) {
        List<SysCheckExtend> list = sysProCheckExtendMapper.cascadeFindTechnical(status, proDetailId);
        return list;
    }

    @Override
    public List<SysCheckExtend> findBusinessCheck(Integer status, long proDetailId, String supplier) {
        List<SysCheckExtend> list = sysProCheckExtendMapper.cascadeFindBusiness(status, proDetailId, supplier);
        return list;
    }
}
