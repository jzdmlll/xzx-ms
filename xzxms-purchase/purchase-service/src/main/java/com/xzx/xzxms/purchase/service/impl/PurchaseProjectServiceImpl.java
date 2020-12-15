package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.dao.extend.PurchaseProjectExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PurchaseProjectServiceImpl implements IPurchaseProjectService {
    @Resource
    private PurchaseProjectExtendMapper purchaseProjectExtendMapper;
    //模糊查询项目名
    @Override
    public List<PurchaseProject> findAllLike(String name) {
        List<PurchaseProject> purchaseProjects = purchaseProjectExtendMapper.findAllLike(name);
        return purchaseProjects;
    }
}