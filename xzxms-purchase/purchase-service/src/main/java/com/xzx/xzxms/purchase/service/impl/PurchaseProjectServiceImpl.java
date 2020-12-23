package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.bean.PurchaseProjectExample;
import com.xzx.xzxms.purchase.dao.PurchaseProjectMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseProjectExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseProjectService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseProjectServiceImpl implements IPurchaseProjectService {
    @Resource
    private PurchaseProjectExtendMapper purchaseProjectExtendMapper;
    @Resource
    private PurchaseProjectMapper purchaseProjectMapper;
    //模糊查询项目名
    @Override
    public List<PurchaseProject> findAllLike(String name) {
        List<PurchaseProject> purchaseProjects = purchaseProjectExtendMapper.findAllLike(name);
        return purchaseProjects;
    }

    @Override
    public List<PurchaseProject> findById(Long id) {
        PurchaseProjectExample example = new PurchaseProjectExample();
        example.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(1);
        List<PurchaseProject> list = purchaseProjectMapper.selectByExample(example);
        return list;
    }

    @Override
    public void deleteById(long id) {
        long time = new Date().getTime();
        PurchaseProject purchaseProject = purchaseProjectMapper.selectByPrimaryKey(id);
        if(purchaseProject==null || purchaseProject.getIsActive().equals(0)){
            throw new CustomerException("该数据已不存在");
        }else {
            purchaseProject.setIsActive(0);
            purchaseProject.setTime(time);
            purchaseProjectMapper.updateByPrimaryKeySelective(purchaseProject);
        }
    }

    @Override
    public void saveOrUpdate(PurchaseProject purchaseProject) {
        long time = new Date().getTime();
        if(purchaseProject.getId() != null){
            purchaseProject.setTime(time);
           purchaseProjectMapper.updateByPrimaryKeySelective(purchaseProject);
        }else {
            purchaseProject.setId(IDUtils.getId());
            purchaseProject.setIsActive(1);
            purchaseProject.setTime(time);
            purchaseProjectMapper.insert(purchaseProject);
        }
    }
}