package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.QuoteMapper;
import com.xzx.xzxms.inquiry.dao.extend.ProPurchaseExtendMapper;
import com.xzx.xzxms.inquiry.service.IProPurchaseService;
import com.xzx.xzxms.inquiry.vm.ProPurchase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProPurchaseServiceImpl implements IProPurchaseService {

    @Resource
    private ProPurchaseExtendMapper proPurchaseExtendMapper;
    @Resource
    private InquiryMapper inquiryMapper;
    @Resource
    private QuoteMapper quoteMapper;

    @Override
    public List<ProPurchase> findProPurchase(long proDetailId) {

        List<ProPurchase> proPurchases = proPurchaseExtendMapper.findProPurchase(proDetailId);
        return proPurchases;
    }

    @Override
    public void updateCorrectPrice(Inquiry inquiry) {

        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Override
    public void updateSupplyPrice(Quote quote) {

        quoteMapper.updateByPrimaryKeySelective(quote);
    }
}
