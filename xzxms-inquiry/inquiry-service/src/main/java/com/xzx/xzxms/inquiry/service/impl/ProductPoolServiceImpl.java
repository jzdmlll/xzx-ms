package com.xzx.xzxms.inquiry.service.impl;import com.xzx.xzxms.commons.utils.CustomerException;import com.xzx.xzxms.commons.utils.IDUtils;import com.xzx.xzxms.inquiry.dao.ProPoolMapper;import com.xzx.xzxms.inquiry.dao.extend.ProPoolExtendMapper;import com.xzx.xzxms.inquiry.service.IProductPoolService;import com.xzx.xzxms.inquiry.bean.ProPool;import com.xzx.xzxms.inquiry.bean.ProPoolExample;import com.xzx.xzxms.inquiry.bean.extend.ProPoolExtend;import org.apache.commons.lang.StringUtils;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import javax.annotation.Resource;import java.util.Date;import java.util.List;@Servicepublic class ProductPoolServiceImpl implements IProductPoolService {    @Resource    private ProPoolMapper proPoolMapper;    @Resource    private ProPoolExtendMapper proPoolExtendMapper;    @Override    public void addProductPool(ProPool proPool) {        proPool.setId(IDUtils.getId());        proPool.setTime(new Date().getTime());        proPool.setIsActive(1);        proPoolMapper.insert(proPool);    }    @Override    public void updateMessage(ProPool proPool) {        proPoolMapper.updateByPrimaryKeySelective(proPool);    }    @Override    public List<ProPoolExtend> findByParams(String name, String brand, String proName, String model) {        List<ProPoolExtend> proPoolExtends = proPoolExtendMapper.findByParams(name, brand, proName, model);        return proPoolExtends;    }    @Transactional    @Override    public void batchSetInvalid(long[] ids) {        for (long id : ids){            ProPool pool = proPoolMapper.selectByPrimaryKey(id);            if (pool != null || !pool.getIsActive().equals(0)){                pool.setIsActive(0);                proPoolMapper.updateByPrimaryKeySelective(pool);            }else {                throw new CustomerException("该数据已不存在");            }        }    }    @Override    public List<ProPool> findHistoryPrices(String name, String model) {        ProPoolExample proPoolExample=new ProPoolExample();        proPoolExample.setOrderByClause("time desc");        ProPoolExample.Criteria criteria = proPoolExample.createCriteria();        if (StringUtils.isNotEmpty(model)){            criteria.andModelEqualTo(model);        }else {            criteria.andNameLike("%" + name + "%");        }        //2021/03/16改回        List<ProPool> proPools = proPoolMapper.selectByExample(proPoolExample);        return proPools;    }    @Override    public List<ProPool> fuzzyQueryByNameOrModel(String name, String model) {        List<ProPool> proPools = proPoolExtendMapper.fuzzyQueryByNameOrModel(name, model);        return proPools;    }}