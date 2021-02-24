package com.xzx.xzxms.purchase.service.impl;


import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseProType;
import com.xzx.xzxms.purchase.bean.PurchaseProTypeExample;
import com.xzx.xzxms.purchase.dao.PurchaseProTypeMapper;
import com.xzx.xzxms.purchase.service.IPurchaseProTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：tjz
 * @title：
 * @date：2021/2/24 14:04
 * @修改人：
 * @修改时间：2021/2/24 14:04
 * @修改描述：默认描述
 */
@Service
public class PurchaseProTypeServiceImpl implements IPurchaseProTypeService {
    @Resource
    private PurchaseProTypeMapper purchaseProTypeMapper;

    /***
     * 查询所有采购项目分类
     *
     */
    @Override
    public List<PurchaseProType> findAll() {
        PurchaseProTypeExample example = new PurchaseProTypeExample();
        example.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        return purchaseProTypeMapper.selectByExample(example);
    }

    /**
     * 插入或更新采购项目分类
     *
     */
    @Override
    public void saveOrUpdate(PurchaseProType purchaseProType) {
        long time = new Date().getTime();
        if(purchaseProType.getId() != null){
            purchaseProType.setUpdateTime(time);
            purchaseProTypeMapper.updateByPrimaryKeySelective(purchaseProType);
        }else {
            PurchaseProTypeExample example = new PurchaseProTypeExample();
            example.createCriteria().andTypeEqualTo(purchaseProType.getType()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            List<PurchaseProType> list=purchaseProTypeMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该采购项目分类已存在，请勿重复插入!");
            }
            purchaseProType.setTime(time);
            purchaseProType.setId(IDUtils.getId());
            purchaseProType.setIsActive(CommonConstant.EFFECTIVE);
            purchaseProTypeMapper.insert(purchaseProType);
        }
    }

    /**
     * 逻辑删除采购项目分类
     *
     */
    @Override
    public void logicDeleteById(long purchaseProTypeId) {
        long time = new Date().getTime();
        PurchaseProType purchaseProType = new PurchaseProType();
        purchaseProType.setId(purchaseProTypeId);
        purchaseProType.setTime(time);
        purchaseProType.setIsActive(CommonConstant.INVALID);
        purchaseProTypeMapper.updateByPrimaryKeySelective(purchaseProType);
    }
}
