package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.*;
import com.xzx.xzxms.bean.extend.QuoteExtendInquiry;
import com.xzx.xzxms.bean.extend.SysCheckExtend;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.dao.ProPoolMapper;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.FinallyCheckExtendMapper;
import com.xzx.xzxms.dao.extend.QuoteAndInquiryExtendMapper;
import com.xzx.xzxms.dao.extend.SysProDetailExtendMapper;
import com.xzx.xzxms.service.IFinallyCheckService;
import com.xzx.xzxms.utils.BeanHelper;
import com.xzx.xzxms.utils.IDUtils;
import com.xzx.xzxms.vm.FinallyCheckCompareVM;
import com.xzx.xzxms.vm.FinallyQuoteInquiryVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.*;

@Service
public class FinallyCheckServiceImpl implements IFinallyCheckService {
    @Resource
    private FinallyCheckExtendMapper finallyCheckExtendMapper;
    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private ProPoolMapper proPoolMapper;
    @Resource
    private QuoteAndInquiryExtendMapper quoteAndInquiryExtendMapper;
    @Resource
    private SysProDetailExtendMapper sysProDetailExtendMapper;
    @Resource
    private InquiryMapper inquiryMapper;

    @Override
    public List<Map> cascadeFindAllByParams(long proDetailId) {

        String sort = "";
        double minPrice = 0;
        double price = 0;
        List<Map> maps = new ArrayList<Map>();
        List<FinallyQuoteInquiryVM> finallyCheckCompareVMS = finallyCheckExtendMapper.cascadeFindAllByParams(proDetailId);

        Map map = new HashMap();

        for (int i = 0; i < finallyCheckCompareVMS.size(); i++) {
            if (finallyCheckCompareVMS.get(i).getSuPrice() != null){
                price = finallyCheckCompareVMS.get(i).getSuPrice();
            }
            if (sort.equals(finallyCheckCompareVMS.get(i).getSort())) {
                if (price < minPrice) {
                    minPrice = price;
                    //将之前的那个询价最低价标志置为0
                    finallyCheckCompareVMS.get(i - 1).setMinPrice(0);
                    finallyCheckCompareVMS.get(i).setMinPrice(1);

                } else if (price == minPrice) {
                    finallyCheckCompareVMS.get(i).setMinPrice(1);
                }
                map.put(finallyCheckCompareVMS.get(i).getSupplier(), finallyCheckCompareVMS.get(i));
            } else {
                if (!map.isEmpty()) {
                    maps.add(map);
                    map = new HashMap();
                }

                minPrice = price;
                finallyCheckCompareVMS.get(i).setMinPrice(1);
                sort = finallyCheckCompareVMS.get(i).getSort();
                map.put("inquiry", finallyCheckCompareVMS.get(i));
                Map _map = new HashMap();
                _map.put("price", finallyCheckCompareVMS.get(i).getPrice());
                _map.put("totalPrice", finallyCheckCompareVMS.get(i).getTotalPrice());
                map.put("draft", _map);
                map.put(finallyCheckCompareVMS.get(i).getSupplier(), finallyCheckCompareVMS.get(i));
            }
            if (i == finallyCheckCompareVMS.size() - 1) {
                maps.add(map);
            }
        }
        return maps;
    }

    @Transactional
    @Override
    public void FinallyCheckCommit(long[] checkIds, long[] unCheckIds, List<Map> remarks, long userId) {

        long time = new Date().getTime();
        SysProCheck sysProCheck = sysProCheckMapper.selectByPrimaryKey(checkIds[0]);
        Long proDetailId = sysProDetailExtendMapper.isExistsProDetailId(sysProCheck.getId());

//        //根据审核ID查询出询价ID 再查询出项目详情ID
//        if (proDetailId != null){
//            //如果项目详情ID存在  则先全部删除内容，重新添加
//            ProPoolExample example =new ProPoolExample();
//            example.createCriteria().andProDetailIdEqualTo(proDetailId);
//            proPoolMapper.deleteByExample(example);
//        }

        SysProCheck proCheck = new SysProCheck();
        // 更新选中比价
        proCheck.setFinallyAudit(SysCheckExtend.PASS_STATUS); //1选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : checkIds) {
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
            //选中信息插入产品池中
            QuoteExtendInquiry quoteExtendInquiry = quoteAndInquiryExtendMapper.findByQuoteId(id);
            ProPool proPool = new ProPool();
            proPool.setId(IDUtils.getId());
            proPool.setName(quoteExtendInquiry.getInquiry().getName());
            proPool.setBrand(quoteExtendInquiry.getInquiry().getBrand());
            proPool.setSupplier(quoteExtendInquiry.getSupplier());
            proPool.setModel(quoteExtendInquiry.getSuModel());
            proPool.setParams(quoteExtendInquiry.getSuParams());
            proPool.setPrice(quoteExtendInquiry.getSuPrice());
            proPool.setDelivery(quoteExtendInquiry.getSuDelivery());
            proPool.setQuote(quoteExtendInquiry.getInquiry().getPrice().toString());
            proPool.setRemark(quoteExtendInquiry.getSuRemark());
            proPool.setProDetailId(proDetailId);
            proPool.setChoose(1);
            proPool.setIsActive(1);
            proPool.setIsUseful(0);
            proPool.setOperator(userId);
            proPool.setTime(time);
            // 防止空指针异常
            BeanHelper.nullToEmpty(proPool);
            ProPoolExample example = new ProPoolExample();
            example.createCriteria().andNameEqualTo(proPool.getName()).andBrandEqualTo(proPool.getBrand()).andSupplierEqualTo(proPool.getSupplier())
                    .andModelEqualTo(proPool.getModel()).andParamsEqualTo(proPool.getParams()).andPriceEqualTo(proPool.getPrice()).andDeliveryEqualTo(proPool.getDelivery())
                    .andQuoteEqualTo(proPool.getQuote()).andRemarkEqualTo(proPool.getRemark()).andProDetailIdEqualTo(proPool.getProDetailId());
            long num = proPoolMapper.countByExample(example);
            if(num == 0){
                proPoolMapper.insert(proPool);
            }
        }
        // 更新备注
        proCheck = new SysProCheck();
        proCheck.setOperator(userId);
        for(Map map :remarks){
            proCheck.setId(Long.parseLong(map.get("id").toString()));
            proCheck.setFinallyRemark(map.get("remark").toString());
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
        // 更新未选中比价
        proCheck = new SysProCheck();
        proCheck.setFinallyAudit(SysCheckExtend.REFUSE_STATUS); //2未选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : unCheckIds) {
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
    }

    @Override
    public void refuseInquiry(Inquiry inquiry) {
        inquiry.setVeto(1);
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }
}
