package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.dao.SysProDetailMapper;
import com.xzx.xzxms.dao.extend.SysIndexExtendMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.service.ISysIndexService;
import com.xzx.xzxms.vm.ProIsFinallyVM;
import com.xzx.xzxms.vm.ProjectSchedule;
import com.xzx.xzxms.vm.ToDoList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysIndexServiceImpl implements ISysIndexService {

    @Resource
    private SysIndexExtendMapper sysIndexExtendMapper;
    @Resource
    private SysProDetailMapper sysProDetailMapper;
    @Resource
    private SysProCheckExtendMapper sysProCheckExtendMapper;

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
    public Map<String, Integer> findProAndSupplier() {

        Map<String,Integer> map = new HashMap<>();
        int proTotal = sysIndexExtendMapper.findPro();
        int supTotal = sysIndexExtendMapper.findSupplier();
        map.put("proTotal",proTotal);
        map.put("supTotal",supTotal);
        return map;
    }

    @Override
    public List<ProIsFinallyVM> findProIsFinally(String proName) {

        List<ProIsFinallyVM> proIsFinallyVMList = new ArrayList<>();
        List<SysCheckAndScheduleExtend> list = sysIndexExtendMapper.findProIsFinally(proName);
        for (SysCheckAndScheduleExtend s : list){


        }
        return proIsFinallyVMList;

    }

    @Override
    public List<ProjectSchedule> findAllProjectSchedule(String proName, int pageNum) {



        return null;
    }

    @Override
    public List<SysCheckAndScheduleExtend> findProDetailSchedule(long proId) {

        List<SysCheckAndScheduleExtend> list = sysIndexExtendMapper.findProDetailSchedule(proId);
        return list;
    }

    @Override
    public int[] findYearPro(String year) {

        List<Map<String,String>> list = sysIndexExtendMapper.findYearPro(year);
        return deal(list,year);
    }

    @Override
    public int[] findYearSupplier(String year) {

        List<Map<String,String>> list = sysIndexExtendMapper.findYearSupplier(year);
        return deal(list,year);
    }

    @Override
    public List<ToDoList> findTechnicalAuditDeal() {
        List<ToDoList> ToDoLists = sysProCheckExtendMapper.findTechnicalAuditDeal();
        return ToDoLists;
    }

    @Override
    public List<ToDoList> findBusinessAuditDeal() {
        List<ToDoList> ToDoLists = sysProCheckExtendMapper.findBusinessAuditDeal();
        return ToDoLists;
    }

    @Override
    public List<ToDoList> findCompareAuditDeal() {
        List<ToDoList> ToDoLists = sysProCheckExtendMapper.findCompareAuditDeal();
        return ToDoLists;
    }

    @Override
    public List<ToDoList> findFinallyAuditDeal() {
        List<ToDoList> ToDoLists = sysProCheckExtendMapper.findFinallyAuditDeal();
        return ToDoLists;
    }


    public int[] deal(List<Map<String,String>> list,String year){

        int[] temp;

        if(list.size() == 0){
            temp = new int[0];
        }else{
            Integer time = Integer.parseInt(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
            Integer _year = Integer.parseInt(year);

            if (_year < time){

                temp = new int[12];
                for (Map map : list){

                    int t =Integer.parseInt(map.get("t").toString());
                    temp[t-1] = Integer.parseInt(map.get("total").toString());
                }
            }else {

                Integer t1 = Integer.parseInt(list.get(list.size()-1).get("t"));
                temp = new int[t1];
                for (Map map : list){

                    int t =Integer.parseInt(map.get("t").toString());
                    temp[t-1] = Integer.parseInt(map.get("total").toString());
                }
            }
        }

        return temp;
    }
}


