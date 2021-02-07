package com.xzx.xzxms.stock.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.stock.bean.StockContractAttribute;
import com.xzx.xzxms.stock.bean.StockContractAttributeExample;
import com.xzx.xzxms.stock.dao.StockContractAttributeMapper;
import com.xzx.xzxms.stock.service.StockContractAttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public StockContractAttribute findByContractId(Long ContractId) {

        StockContractAttributeExample example = new StockContractAttributeExample();
        example.createCriteria().andContractIdEqualTo(ContractId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);

        List<StockContractAttribute> stockContractAttributes = stockContractAttributeMapper.selectByExample(example);

        if (stockContractAttributes.size() > 0) {
            return stockContractAttributes.get(0);
        }
        return null;
    }
}
