package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.service.ISysProCheckService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysProCheckServiceImpl implements ISysProCheckService {
    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private SysProCheckExtendMapper sysProCheckExtendMapper;
    @Resource
    private InquiryMapper inquiryMapper;
    @Override
    public void inquiryInsert(SysProCheck sysProCheck) {
        sysProCheckMapper.insert(sysProCheck);
    }
    @Transactional
    @Override
    public void check(long[] ids,int state,long[] inquiryIds) {
        for (int i = 0; i < ids.length; i ++){
            InquiryWithBLOBs inquiry = new InquiryWithBLOBs();
            inquiry.setId(inquiryIds[i]);
            inquiry.setIsUseful(1);
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
            SysProCheck sysProCheck=new SysProCheck();
            sysProCheck.setId(ids[i]);
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
    public List<SysProCheckExtend> cascadeFindAllByCheckName(int type, String checkName, int[] checkStatus, long proDetailId) {
        return sysProCheckExtendMapper.cascadeFindAllByCheckName(type, checkName, checkStatus, proDetailId);
    }


}
