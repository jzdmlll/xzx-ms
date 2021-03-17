package com.xzx.xzxms.inquiry.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.inquiry.dao.extend.SysIndexExtendMapper;
import com.xzx.xzxms.inquiry.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.inquiry.service.ISysIndexService;
import com.xzx.xzxms.inquiry.bean.extend.SysCheckAndScheduleExtend;
import com.xzx.xzxms.inquiry.vm.ProIsFinallyVM;
import com.xzx.xzxms.inquiry.vm.ProjectSchedule;
import com.xzx.xzxms.inquiry.vm.ToDoList;
import com.xzx.xzxms.inquiry.vo.ProjectCompletionVO;
import com.xzx.xzxms.inquiry.vo.ContractAuditDealVO;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractAuditExtendMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysIndexServiceImpl implements ISysIndexService {

    @Resource
    private SysIndexExtendMapper sysIndexExtendMapper;
    @Resource
    private PurchaseContractAuditExtendMapper purchaseContractAuditExtendMapper;
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
    public IPage<ToDoList> findTechnicalAuditDeal(Page<ToDoList> page) {
        return sysProCheckExtendMapper.findTechnicalAuditDeal(page);
    }

    @Override
    public IPage<ToDoList> findBusinessAuditDeal(Page<ToDoList> page) {
        return sysProCheckExtendMapper.findBusinessAuditDeal(page);
    }

    @Override
    public IPage<ToDoList> findCompareAuditDeal(Page<ToDoList> page) {
        return sysProCheckExtendMapper.findCompareAuditDeal(page);
    }

    @Override
    public IPage<ToDoList> findFinallyAuditDeal(Page<ToDoList> page) {
        return sysProCheckExtendMapper.findFinallyAuditDeal(page);
    }

    @Override
    public IPage<ProjectCompletionVO> findProAndCompletion(Page<?> page, String orderBy) {
        return sysIndexExtendMapper.findProAndCompletion(page, orderBy);
    }

    @Override
    public IPage<ContractAuditDealVO> dataSourceFirst(Page<?> page) {
        return purchaseContractAuditExtendMapper.dataSourceFirst(page);
    }

    @Override
    public IPage<ContractAuditDealVO> dataSourceSecond(Page<?> page) {
        return purchaseContractAuditExtendMapper.dataSourceSecond(page);
    }

    @Override
    public IPage<ContractAuditDealVO> dataSourceThree(Page<?> page) {
        return purchaseContractAuditExtendMapper.dataSourceThree(page);
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


