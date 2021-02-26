package com.xzx.xzxms.stock.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.stock.bean.StockActualAccount;
import com.xzx.xzxms.stock.bean.StockActualAccountExample;
import com.xzx.xzxms.stock.bean.StockContractAttribute;
import com.xzx.xzxms.stock.bean.StockContractAttributeExample;
import com.xzx.xzxms.stock.dao.StockActualAccountMapper;
import com.xzx.xzxms.stock.dao.StockContractAttributeMapper;
import com.xzx.xzxms.stock.dao.extend.StockActualAccountExtendMapper;
import com.xzx.xzxms.stock.service.StockActualAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    @Resource
    private StockActualAccountExtendMapper stockActualAccountExtendMapper;
    @Resource
    private StockContractAttributeMapper stockContractAttributeMapper;

    @Override
    public List<StockActualAccount> findByContractId(Long ContractId) {

        StockActualAccountExample example = new StockActualAccountExample();
        example.createCriteria().andContractIdEqualTo(ContractId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);

        return stockActualAccountMapper.selectByExample(example);
    }

    @Override
    public void addActualAccount(StockActualAccount stockActualAccount) {

        Double moneys = statisticsActualAccountByContractId(stockActualAccount.getContractId());
        if (moneys!=null && moneys > 0){
            StockContractAttributeExample attributeExample = new StockContractAttributeExample();
            attributeExample.createCriteria().andContractIdEqualTo(stockActualAccount.getContractId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            List<StockContractAttribute> stockContractAttributes = stockContractAttributeMapper.selectByExample(attributeExample);
            if (stockContractAttributes != null){

                Double needPay = stockContractAttributes.get(0).getPayable();
                Double temp = needPay - moneys - Double.parseDouble(stockActualAccount.getMoney());
                if (temp < 0){
                    throw new CustomerException("信息提交错误,付款金额大于未付款金额!");
                }
            }
        }
        stockActualAccount.setId(IDUtils.getId());
        stockActualAccount.setTime(new Date().getTime());
        stockActualAccount.setIsActive(CommonConstant.EFFECTIVE);
        stockActualAccountMapper.insert(stockActualAccount);
    }

    @Override
    public void setInvalidActualAccount(StockActualAccount equipmentActualAccount) {

        equipmentActualAccount.setUpdateTime(new Date().getTime()+"");
        equipmentActualAccount.setIsActive(CommonConstant.INVALID);
        stockActualAccountMapper.updateByPrimaryKeySelective(equipmentActualAccount);
    }

    @Override
    public Double statisticsActualAccountByContractId(Long contractId) {

        Double moneys = stockActualAccountExtendMapper.statisticsActualAccountByContractId(contractId);
        return moneys;
    }
}
