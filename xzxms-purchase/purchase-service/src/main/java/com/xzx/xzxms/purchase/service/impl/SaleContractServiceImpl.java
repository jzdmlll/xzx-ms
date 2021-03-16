package com.xzx.xzxms.purchase.service.impl;/**
 * @Author sunny
 * @Date 2021/3/14 14:42
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.SaleContract;
import com.xzx.xzxms.purchase.bean.SaleContractExample;
import com.xzx.xzxms.purchase.dao.SaleContractMapper;
import com.xzx.xzxms.purchase.dao.extend.SaleContractExtendMapper;
import com.xzx.xzxms.purchase.service.ISaleContractService;
import com.xzx.xzxms.purchase.vo.SaleContractVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName SaleContractServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class SaleContractServiceImpl implements ISaleContractService {

    @Resource
    private SaleContractExtendMapper saleContractExtendMapper;
    @Resource
    private SaleContractMapper saleContractMapper;

    @Override
    public List<SaleContractVO> findSaleContractData(String name) {

        List<SaleContractVO> list = saleContractExtendMapper.findSaleContractData(name);
        return list;
    }

    @Override
    public void saveOrUpdate(SaleContract saleContract, String loginId) {

        String id = saleContract.getId();
        Long time = new Date().getTime();
        if (StringUtils.isNotEmpty(id)){
            //修改
            saleContract.setUpdateOperator(loginId);
            saleContract.setUpdateTime(time);
            saleContractMapper.updateByPrimaryKeySelective(saleContract);
        }else {
            //新增
            id = IDUtils.getId().toString();
            saleContract.setId(id);
            saleContract.setOperator(loginId);
            saleContract.setTime(time);
            saleContract.setIsActive(CommonConstant.EFFECTIVE);
            saleContractMapper.insertSelective(saleContract);
        }
    }

    @Override
    public void setInvalid(List<String> contractId, String loginId) {

        for(String id : contractId){
            SaleContractExample example = new SaleContractExample();
            example.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            Long num = saleContractMapper.countByExample(example);
            if (num == 0){
                throw new CustomerException("删除失败,已有合同被删除,请重新刷新页面");
            }
            SaleContract saleContract = new SaleContract();
            saleContract.setId(id);
            saleContract.setIsActive(CommonConstant.INVALID);
            saleContract.setUpdateOperator(loginId);
            saleContract.setUpdateTime(new Date().getTime());
            saleContractMapper.updateByPrimaryKeySelective(saleContract);
        }
    }
}
