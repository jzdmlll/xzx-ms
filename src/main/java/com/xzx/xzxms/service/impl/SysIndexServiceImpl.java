package com.xzx.xzxms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.bean.SysProDetail;
import com.xzx.xzxms.bean.SysProDetailExample;
import com.xzx.xzxms.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.dao.SysProDetailMapper;
import com.xzx.xzxms.dao.extend.SysIndexExtendMapper;
import com.xzx.xzxms.service.ISysIndexService;
import com.xzx.xzxms.utils.BeanHelper;
import com.xzx.xzxms.vm.ProjectSchedule;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysIndexServiceImpl implements ISysIndexService {

    @Resource
    private SysIndexExtendMapper sysIndexExtendMapper;
    @Resource
    private SysProDetailMapper sysProDetailMapper;

//    @Override
//    public List<ProjectSchedule> findAllProjectSchedule(int pageNum) {
//
//        List<ProjectSchedule> projectSchedules = null;
//        ProjectSchedule p = null;
//        List<SysCheckAndScheduleExtend> temp = null;
//        List<SysCheckAndScheduleExtend> temp1 = null;
//
//
//        List<SysCheckAndScheduleExtend> list = sysIndexExtendMapper.findAllProjectSchedule();
//
//        SysProDetailExample example = new SysProDetailExample();
//        List<SysProDetailWithBLOBs> sysProDetails = sysProDetailMapper.selectByExampleWithBLOBs(example);
//        for (SysProDetailWithBLOBs bloBs : sysProDetails){
//            temp = list.stream().filter(x -> bloBs.getId().equals(x.getSysDetailId())).collect(Collectors.toList());
//            for (SysCheckAndScheduleExtend extend : temp){
//                if (String.valueOf(extend.getInquiryId()) == null){
//                    p.setProId(extend.getSysDetailId());
//                    p.setProName(extend.getName());
//                    p.setInquiryStatus(0);
//                    p.setQuoteStatus(0);
//                    p.setBussStatus(0);
//                    p.setTechStatus(0);
//                    p.setComStatus(0);
//                    p.setFinStatus(0);
//                    projectSchedules.add(p);
//                }else{
//                    if (String.valueOf(extend.getQuoteId()) == null){
//                        p.setProId(extend.getSysDetailId());
//                        p.setProName(extend.getName());
//                        p.setInquiryStatus(1);
//                        p.setQuoteStatus(0);
//                        p.setBussStatus(0);
//                        p.setTechStatus(0);
//                        p.setComStatus(0);
//                        p.setFinStatus(0);
//                        projectSchedules.add(p);
//                    }else {
//                        temp1 = temp.stream().filter(x ->"0".equals(x.getFinallyRemark())).collect(Collectors.toList());
//
//                    }
//                }
//            }
//        }
//
//
//
//
//        return null;
//    }

    @Override
    public List<ProjectSchedule> findAllProjectSchedule(String proName, int pageNum) {



        return null;
    }

    @Override
    public List<SysCheckAndScheduleExtend> findProDetailSchedule(long proId) {

        List<SysCheckAndScheduleExtend> list = sysIndexExtendMapper.findProDetailSchedule(proId);
        return list;
    }
}


