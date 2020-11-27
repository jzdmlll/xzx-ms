package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.dao.extend.ProPurchaseExtendMapper;
import com.xzx.xzxms.service.IProPurchaseService;
import com.xzx.xzxms.vm.ProPurchase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProPurchaseServiceImpl implements IProPurchaseService {

    @Resource
    private ProPurchaseExtendMapper proPurchaseExtendMapper;

    @Override
    public List<ProPurchase> findProPurchase(long proDetailId) {

        List<ProPurchase> proPurchases = proPurchaseExtendMapper.findProPurchase(proDetailId);
        return proPurchases;
    }
}
