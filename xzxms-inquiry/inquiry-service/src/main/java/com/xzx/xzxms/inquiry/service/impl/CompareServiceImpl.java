package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.inquiry.bean.*;
import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.QuoteMapper;
import com.xzx.xzxms.inquiry.dao.SysProCheckMapper;
import com.xzx.xzxms.inquiry.dao.extend.CompareExtendMapper;
import com.xzx.xzxms.inquiry.dao.extend.InquiryExtendMapper;
import com.xzx.xzxms.inquiry.dao.extend.QuoteAndInquiryExtendMapper;
import com.xzx.xzxms.inquiry.service.ICompareService;
import com.xzx.xzxms.inquiry.bean.extend.SysCheckExtend;
import com.xzx.xzxms.inquiry.vm.*;
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
    @Resource
    private InquiryMapper inquiryMapper;
    @Resource
    private InquiryExtendMapper inquiryExtendMapper;
    @Resource
    private QuoteAndInquiryExtendMapper quoteAndInquiryExtendMapper;
    @Resource
    private QuoteMapper quoteMapper;

    @Override
    public List<QuoteRespVM> cascadeFindAllByParams(long inquiryId) {
        List<QuoteRespVM> quoteRespVM = compareExtendMapper.cascadeFindAllByParams(inquiryId);
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
    public void completeCompare(long[] checkCompareIds, long[] otherCompareIds, List<Map> remarks, long userId, List<Map> inquiries) {

//        long time = new Date().getTime();
//
//        SysProCheck proCheck = new SysProCheck();
//        // 更新选中比价
//        proCheck.setCompareAudit(SysCheckExtend.PASS_STATUS); //1选用
//        proCheck.setOperator(userId);
//        proCheck.setTime(time);
//        for (long id : checkCompareIds) {
//            SysProCheck sysProCheck = sysProCheckMapper.selectByPrimaryKey(id);
//            if (0 != sysProCheck.getFinallyAudit()){
//                throw new CustomerException("该报价已终审，请勿再修改拟比价!");
//            }
//            proCheck.setId(id);
//            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
//        }
//        // 更新备注
//        proCheck = new SysProCheck();
//        for(Map map :remarks){
//            proCheck.setId(Long.parseLong(map.get("id").toString()));
//            proCheck.setCompareRemark(map.get("remark").toString());
//            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
//        }
//        // 更新未选中比价
//        proCheck = new SysProCheck();
//        proCheck.setCompareAudit(SysCheckExtend.REFUSE_STATUS); //2未选用
//        proCheck.setOperator(userId);
//        proCheck.setTime(time);
//        for (long id : otherCompareIds) {
//            SysProCheck sysProCheck = sysProCheckMapper.selectByPrimaryKey(id);
//            if (0 != sysProCheck.getFinallyAudit()){
//                throw new CustomerException("该报价已终审，请勿再修改拟比价!");
//            }
//            proCheck.setId(id);
//            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
//        }
//
//        Inquiry inquiry = new Inquiry();
//        for (Map map : inquiries){
//            inquiry.setId(Long.parseLong(map.get("id").toString()));
//            inquiry.setPrice(Double.parseDouble(map.get("price").toString()));
//            inquiry.setTotalPrice(Double.parseDouble(map.get("totalPrice").toString()));
//            inquiryMapper.updateByPrimaryKeySelective(inquiry);
//        }


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
            SysProCheck sysProCheck = sysProCheckMapper.selectByPrimaryKey(id);
            if (0 != sysProCheck.getFinallyAudit()){
                throw new CustomerException("该报价已终审，请勿再修改拟比价!");
            }
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }

        Inquiry inquiry = new Inquiry();
        for (Map map : inquiries){
            inquiry.setId(Long.parseLong(map.get("id").toString()));
            inquiry.setPrice(Double.parseDouble(map.get("price").toString()));
            inquiry.setTotalPrice(Double.parseDouble(map.get("totalPrice").toString()));
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }
    }

    @Override
    public void setInquiryRate(long proDetailId,Integer rate) {
        InquiryExample example = new InquiryExample();
        Inquiry inquiry = new Inquiry();
        inquiry.setProDetailId(proDetailId);
        inquiry.setInquiryRate(rate);
        example.createCriteria().andProDetailIdEqualTo(proDetailId);
        inquiryMapper.updateByExampleSelective(inquiry,example);
    }

    @Override
    public List<InquiryVM> findInquiryByProDetailId(long proDetailId) {

        List<InquiryVM> inquiryVMS = inquiryExtendMapper.findInquiryByProId(proDetailId);
        return inquiryVMS;
    }

    @Override
    public List<CompareQuoteListVM> findQuoteByInquiryId(long[] inquiryIds) {

        List<CompareQuoteListVM> list = compareExtendMapper.findQuoteListByInquiry(inquiryIds);

        for (CompareQuoteListVM vm : list){
            for (QuoteRespVM quoteRespVM : vm.getQuotes()){
                if (quoteRespVM.getCompareStatus() == 1){
                    vm.setSuPrice(quoteRespVM.getSuPrice());
                }
            }
        }

//        List<FinallyQuoteInquiryVM> list = new ArrayList<>();
//        for (long id : inquiryIds){
//
//            List<FinallyQuoteInquiryVM> finallyCheckCompareVMS = quoteAndInquiry.findQuoteByInquiryId(id);
//            //查询按升序排的，所以第一个报价商价格最低，设置标志为1
//            finallyCheckCompareVMS.get(0).setMinPrice(1);
//            list.addAll(finallyCheckCompareVMS);
//        }
//        list.stream().sorted(Comparator.comparing(FinallyQuoteInquiryVM::getSupplier)).collect(Collectors.toList());
        return list;
    }

    @Override
    public void compareUpdateDraft(Inquiry inquiry) {
        int count = quoteAndInquiryExtendMapper.findIsExistFinally(inquiry.getId());
        if (count > 0){
            throw new CustomerException("该询价内容已被终审，请勿再修改拟定报价!");
        }
        inquiry.setTime(new Date().getTime());
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Transactional
    @Override
    public void compareResultCommit(CompareVM compareVM) {

        List<Long> longs = new ArrayList<>();

        for (QuoteExtend quoteExtend : compareVM.getQuoteList()) {

            QuoteExample quoteExample = new QuoteExample();
            quoteExample.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE).andInquiryIdEqualTo(quoteExtend.getInquiryId());
            List<Quote> quotes = quoteMapper.selectByExample(quoteExample);
            for (Quote quote : quotes){
                longs.add(quote.getId());
            }
            SysProCheckExample sysProCheckExample = new SysProCheckExample();
            sysProCheckExample.createCriteria().andQuoteIdIn(longs);
            List<SysProCheck> sysProChecks = sysProCheckMapper.selectByExample(sysProCheckExample);
            for (SysProCheck check : sysProChecks){
                check.setCompareAudit(2);
                check.setFinallyAudit(0);
                sysProCheckMapper.updateByPrimaryKeySelective(check);
            }

            SysProCheckExample checkExample = new SysProCheckExample();
            checkExample.createCriteria().andQuoteIdEqualTo(quoteExtend.getId());
            List<SysProCheck> proChecks = sysProCheckMapper.selectByExample(checkExample);
            SysProCheck proCheck = proChecks.get(0);
            proCheck.setCompareAudit(1);
            proCheck.setCompareRemark(quoteExtend.getRemark());
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
    }
}
