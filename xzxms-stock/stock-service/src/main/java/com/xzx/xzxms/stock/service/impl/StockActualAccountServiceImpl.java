package com.xzx.xzxms.stock.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.stock.bean.StockActualAccount;
import com.xzx.xzxms.stock.bean.StockActualAccountExample;
import com.xzx.xzxms.stock.dao.StockActualAccountMapper;
import com.xzx.xzxms.stock.service.StockActualAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/2/7 16:31
 * @Version 1.0
 */
@Service
public class StockActualAccountServiceImpl implements StockActualAccountService {

    @Resource
    private StockActualAccountMapper stockActualAccountMapper;

    @Override
    public List<StockActualAccount> findByContractId(Long ContractId) {

        StockActualAccountExample example = new StockActualAccountExample();
        example.createCriteria().andContractIdEqualTo(ContractId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);

        return stockActualAccountMapper.selectByExample(example);
    }
}
