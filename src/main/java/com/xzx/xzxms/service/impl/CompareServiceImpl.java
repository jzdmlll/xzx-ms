package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.SysCheckExtend;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.CompareExtendMapper;
import com.xzx.xzxms.service.ICompareService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.vm.CompareReqVM;
import com.xzx.xzxms.vm.QuoteRespVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CompareServiceImpl implements ICompareService {
    @Resource
    private CompareExtendMapper compareExtendMapper;
    @Resource
    private SysProCheckMapper sysProCheckMapper;

    @Override
    public List<QuoteRespVM> cascadeFindAllByParams(long inquiryId) {

        List<QuoteRespVM> quoteRespVM = compareExtendMapper.cascadeFindAllByParams(inquiryId);
//        List<QuoteRespVM> newQuote = new ArrayList<>();




//        long id = -1L;
//        List<QuoteRespVM> tempList = null;
//        List<List<QuoteRespVM>> resultList = new ArrayList<>();
//        for (QuoteRespVM q : quoteRespVM){
//            if(id != q.getId()) {
//                if(tempList!=null){
//                    resultList.add(tempList);
//                }
//                id = q.getId();
//                tempList = new ArrayList<>();
//                tempList.add(q);
//            }else {
//                tempList.add(q);
//            }
//        }
//        resultList.add(tempList);
//        System.out.println(resultList.size());
//
//        for(List<QuoteRespVM> list: resultList){
//            int key = 0;
//            int index = 0;
//            for(int i=0;i<list.size();i++){
//                QuoteRespVM q = list.get(i);
//                if(q.getCompareStatus() ==  2 && !"比价审核".equals(q.getCheckType())) {
//                    key ++;
//                }
//                if("比价审核".equals(q.getCheckType())) {
//                    index = i;
//                }
//            }
//            if(key == 0) {
//                newQuote.add(list.get(index));
//            }
//        }

        return quoteRespVM;
    }


    @Override
    public List<?> batchGetCompare(CompareReqVM compareReqVM) {
        long[] inquiryIds = compareReqVM.getInquiryIds();
        String[] names = compareReqVM.getNames();

        List<Map> result = new ArrayList<>();

        for(int i=0; i < names.length; i++){
            List<QuoteRespVM> inquiryCompareVMS = cascadeFindAllByParams(inquiryIds[i]);
            Map map = new HashMap();
            map.put("name", names[i]);
            map.put("inquiryId", inquiryIds[i]);
            map.put("inquiryCompareVMS",inquiryCompareVMS);
            result.add(map);
        }
        return result;
    }

    @Transactional
    @Override
    public void completeCompare(long[] checkCompareIds, long[] otherCompareIds, List<Map> remarks, long userId) {

        long time = new Date().getTime();

        SysProCheck proCheck = new SysProCheck();
        // 更新选中比价
        proCheck.setCompareAudit(SysCheckExtend.PASS_STATUS); //1选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : checkCompareIds) {
            SysProCheck sysProCheck = sysProCheckMapper.selectByPrimaryKey(id);
            if (0 != sysProCheck.getFinallyAudit()){
                throw new CustomerException("该报价已终审，请勿再修改拟比价!");
            }
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
        // 更新备注
        proCheck = new SysProCheck();
        for(Map map :remarks){
            proCheck.setId(Long.parseLong(map.get("id").toString()));
            proCheck.setCompareRemark(map.get("remark").toString());
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
        // 更新未选中比价
        proCheck = new SysProCheck();
        proCheck.setCompareAudit(SysCheckExtend.REFUSE_STATUS); //2未选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : otherCompareIds) {
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
    }
}
