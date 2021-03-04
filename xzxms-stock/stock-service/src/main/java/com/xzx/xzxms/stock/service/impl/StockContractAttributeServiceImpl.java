package com.xzx.xzxms.stock.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.stock.bean.StockContractAttribute;
import com.xzx.xzxms.stock.bean.StockContractAttributeExample;
import com.xzx.xzxms.stock.dao.StockContractAttributeMapper;
import com.xzx.xzxms.stock.dao.extend.StockContractAttributeExtendMapper;
import com.xzx.xzxms.stock.service.StockContractAttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/2/7 14:53
 * @Version 1.0
 */
@Service
public class StockContractAttributeServiceImpl implements StockContractAttributeService {

    @Resource
    private StockContractAttributeMapper stockContractAttributeMapper;
    @Resource
    private StockContractAttributeExtendMapper stockContractAttributeExtendMapper;
    @Override
    public StockContractAttribute findByContractId(Long contractId) {

        StockContractAttributeExample example = new StockContractAttributeExample();
        example.createCriteria().andContractIdEqualTo(contractId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);

        List<StockContractAttribute> stockContractAttributes = stockContractAttributeMapper.selectByExample(example);

        if (stockContractAttributes.size() > 0) {
            return stockContractAttributes.get(0);
        }
        return null;
    }

    @Override
    public void saveOrUpdateStockContractAttribute(StockContractAttribute stockContractAttribute) {

        long time = new Date().getTime();
        if (stockContractAttribute.getId() == null){
            //新增
            long id = IDUtils.getId();
            //验证是否已存在合同属性
            StockContractAttributeExample example = new StockContractAttributeExample();
            example.createCriteria().andContractIdEqualTo(stockContractAttribute.getContractId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            List<StockContractAttribute> list = stockContractAttributeMapper.selectByExample(example);
            if (list.size() > 0){
                throw new CustomerException("合同属性已存在，请勿重复提交!");
            }
            stockContractAttribute.setId(id);
            stockContractAttribute.setIsActive(CommonConstant.EFFECTIVE);
            stockContractAttribute.setTime(time);
            stockContractAttributeMapper.insert(stockContractAttribute);
        }else {
            //修改
            stockContractAttribute.setUpdateTime(time);
            stockContractAttributeMapper.updateByPrimaryKeySelective(stockContractAttribute);
        }
    }

    @Override
    public List<PurchaseContract> findContractHasContractAttributeByProId(Long projectId) {
        return stockContractAttributeExtendMapper.findContractHasContractAttributeByProId(projectId);
    }
}
