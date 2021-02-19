package com.xzx.xzxms.supply.service.impl;/**
 * @Author sunny
 * @Date 2021/2/18 14:51
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.supply.bean.SupplySupplier;
import com.xzx.xzxms.supply.bean.SupplySupplierExample;
import com.xzx.xzxms.supply.dao.SupplySupplierMapper;
import com.xzx.xzxms.supply.service.SupplySupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName SupplySupplierServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class SupplySupplierServiceImpl implements SupplySupplierService {

    @Resource
    private SupplySupplierMapper supplySupplierMapper;


    @Override
    public List<SupplySupplier> findSupplierByParams() {

        SupplySupplierExample example = new SupplySupplierExample();
        example.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<SupplySupplier> list = supplySupplierMapper.selectByExample(example);
        return list;
    }

    @Override
    public void saveOrUpdate(SupplySupplier supplySupplier) {

        long time = new Date().getTime();

        if (supplySupplier.getId() == null){

            SupplySupplierExample example = new SupplySupplierExample();
            example.createCriteria().andSupplierEqualTo(supplySupplier.getSupplier()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            List<SupplySupplier> list = supplySupplierMapper.selectByExample(example);
            if (list.size() > 0){
                throw new CustomerException("该供应商已存在,请勿重复添加!");
            }

            long id = IDUtils.getId();
            supplySupplier.setId(id);
            supplySupplier.setAddTime(time);
            supplySupplier.setIsActive(CommonConstant.EFFECTIVE);
            supplySupplierMapper.insert(supplySupplier);
        }else {

            supplySupplier.setUpdateTime(time);
            supplySupplierMapper.updateByPrimaryKeySelective(supplySupplier);
        }
    }
}
