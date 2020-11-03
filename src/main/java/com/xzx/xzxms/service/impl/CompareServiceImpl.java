package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProCheckExample;
import com.xzx.xzxms.bean.SysUser;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.CompareExtendMapper;
import com.xzx.xzxms.service.ICompareService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.vm.CompareReqVM;
import com.xzx.xzxms.vm.QuoteRespVM;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompareServiceImpl implements ICompareService {
    @Resource
    private CompareExtendMapper compareExtendMapper;
    @Resource
    private SysProCheckMapper sysProCheckMapper;

    @Override
    public List<QuoteRespVM> cascadeFindAllByParams(long inquiryId) {

        List<QuoteRespVM> quoteRespVM = compareExtendMapper.cascadeFindAllByParams(inquiryId);
        List<QuoteRespVM> newQuote = new ArrayList<>();

        for (QuoteRespVM q : quoteRespVM){
            if (!q.getCheckType().equals("比价审核")){
                if (q.getCompareStatus() == 2){
                    quoteRespVM = quoteRespVM.stream().filter(x->x.getId() == q.getId()).collect(Collectors.toList());
                }
            }
        }

        for(QuoteRespVM q : quoteRespVM){
            if(q.getCheckType().equals("比价审核")){
                newQuote.add(q);
            }
        }
        //quoteRespVM = quoteRespVM.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()-> new TreeSet<>(Comparator.comparing(QuoteRespVM::getId))),ArrayList::new));

        return newQuote;
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
        proCheck.setCheckStatus(SysProCheckExtend.PASS_STATUS); //1选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : checkCompareIds) {
            SysProCheckExample example = new SysProCheckExample();
            example.createCriteria().andTypeEqualTo("最终审核").andCheckStatusNotEqualTo(0);
            List<SysProCheck> sysProCheck = sysProCheckMapper.selectByExample(example);
            if(sysProCheck.size() > 0){
                throw new CustomerException("该报价已终审，请勿再修改拟比价!");
            }

            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
        // 更新备注
        proCheck = new SysProCheck();
        proCheck.setOperator(userId);
        for(Map map :remarks){
            proCheck.setId(Long.parseLong(map.get("id").toString()));
            proCheck.setRemark(map.get("remark").toString());
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
        // 更新未选中比价
        proCheck = new SysProCheck();
        proCheck.setCheckStatus(SysProCheckExtend.REFUSE_STATUS); //2未选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : otherCompareIds) {
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
    }
    

}
