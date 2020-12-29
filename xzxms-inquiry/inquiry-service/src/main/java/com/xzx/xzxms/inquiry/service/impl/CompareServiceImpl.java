package com.xzx.xzxms.inquiry.service.impl;

import com.google.common.math.LongMath;
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
import java.math.BigDecimal;
import java.text.DecimalFormat;
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

    @Transactional
    @Override
    public void setInquiryRate(long proDetailId,Double rate) {
        InquiryExample example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(proDetailId);
        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
        for(Inquiry i : inquiries){
            Quote quote = compareExtendMapper.findCompareResult(i.getId());
            //如果该询价下没有比价选用的报价，则该询价的拟定报价为空，利率为设置值；如果存在选用的报价，则该询价的拟定报价为选用的报价乘以利率存入数据库中
            if(quote != null){
                Double draftPrice = quote.getSuPrice()*(rate/(1000*100))+quote.getSuPrice();
                Double draftTotalPrice = draftPrice*i.getNumber();
                i.setPrice(draftPrice);
                i.setTotalPrice(draftTotalPrice);
                i.setInquiryRate(rate.intValue());
                i.setTime(new Date().getTime());
                inquiryMapper.updateByPrimaryKeySelective(i);
            }else {
                throw new CustomerException("该询价未选用合适的供货商，无法设置利润率，请选取供货商后再设置!");
            }
        }
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
    public void compareUpdateDraft(InquirySuPriceVM inquiry) {
        int count = quoteAndInquiryExtendMapper.findIsExistFinally(inquiry.getId());
        if (count > 0){
            throw new CustomerException("该询价内容已被终审，请勿再修改拟定报价!");
        }
        try {
            if (inquiry.getPrice() != null && inquiry.getSuPrice() != null) {
                Integer rate = new Long(Math.round((inquiry.getPrice() - inquiry.getSuPrice()) / inquiry.getSuPrice() * 1000 * 100)).intValue();

                inquiry.setInquiryRate(rate);
                inquiry.setTime(new Date().getTime());
                inquiryMapper.updateByPrimaryKeySelective(inquiry);
            }else{
                throw new CustomerException("供货商未选择!");
            }
        }catch (ArithmeticException ae) {
            throw new CustomerException("供货商价格不能为0");
        }
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
            //先将所有报价比价状态置为未选用
            for (SysProCheck check : sysProChecks){
                check.setCompareAudit(2);
                check.setFinallyAudit(0);
                sysProCheckMapper.updateByPrimaryKeySelective(check);
            }
            //再将选用的报价比价状态置为选用
            SysProCheckExample checkExample = new SysProCheckExample();
            checkExample.createCriteria().andQuoteIdEqualTo(quoteExtend.getId());
            List<SysProCheck> proChecks = sysProCheckMapper.selectByExample(checkExample);
            if (proChecks.size() > 0){
                SysProCheck proCheck = proChecks.get(0);
                proCheck.setCompareAudit(1);
                proCheck.setCompareRemark(quoteExtend.getRemark());
                sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
                Inquiry inquiry = inquiryMapper.selectByPrimaryKey(quoteExtend.getInquiryId());
                Quote quote = quoteMapper.selectByPrimaryKey(quoteExtend.getId());
                try {
                    if (inquiry.getPrice() != null && quote.getSuPrice() != null) {
                        Integer rate = new Long(Math.round((inquiry.getPrice() - quote.getSuPrice()) / quote.getSuPrice() * 1000 * 100)).intValue();

                        inquiry.setInquiryRate(rate);
                    }
                    inquiryMapper.updateByPrimaryKeySelective(inquiry);
                }catch (ArithmeticException ae) {
                    throw new CustomerException("供货商价格不能为0");
                }
            }else {
                throw new CustomerException("未选用一家供货商，提交失败!");
            }
        }
    }
}
