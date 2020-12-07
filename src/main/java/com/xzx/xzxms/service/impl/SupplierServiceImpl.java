package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Supplier;
import com.xzx.xzxms.bean.SupplierExample;
import com.xzx.xzxms.dao.SupplierMapper;
import com.xzx.xzxms.dao.extend.SupplierExtendMapper;
import com.xzx.xzxms.service.ISupplierService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private SupplierExtendMapper supplierExtendMapper;
    @Override
    public List<Supplier> findById(Long id) {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(1);
        List<Supplier> list = supplierMapper.selectByExample(example);
        return list;
    }

    @Override
    public void saveOrUpdate(Supplier supplier) {
        long time = new Date().getTime();
        if (supplier.getId() != null){
            supplier.setTime(time);
            supplierMapper.updateByPrimaryKeySelective(supplier);
        }else {
            supplier.setId(IDUtils.getId());
            supplier.setIsActive(1);
            supplier.setTime(time);
            supplierMapper.insert(supplier);
        }
    }

    @Override
    public void deleteById(long id) {
        long time = new Date().getTime();
        Supplier supplier = supplierMapper.selectByPrimaryKey(id);
        if (supplier != null ||supplier.getIsActive().equals(1)){
            supplier.setIsActive(0);
            supplier.setTime(time);
            supplierMapper.updateByPrimaryKeySelective(supplier);
        }else{
            throw new CustomerException("该数据已不存在");
        }
    }

    @Override
    public List<Supplier> findAllLike(String name) {
        List<Supplier> suppliers = supplierExtendMapper.findAllLike(name);
        return suppliers;
    }
}
