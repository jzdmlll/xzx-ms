package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseContractExample;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseContractServiceImpl implements IPurchaseContractService {
    @Resource
    private PurchaseContractMapper purchaseContractMapper;
    @Resource
    private PurchaseContractExtendMapper purchaseContractExtendMapper;
    @Override
    public List<PurchaseContract> findByProjectId(Long projectId) {
        PurchaseContractExample example = new PurchaseContractExample();
        if (projectId == null) {
            example.createCriteria().andIsActiveNotEqualTo(0);
        }else {
            example.createCriteria().andProjectIdEqualTo(projectId).andIsActiveNotEqualTo(0);//查除了状态为0的其他合同
        }
        List<PurchaseContract> list = purchaseContractMapper.selectByExample(example);
        return list;
    }

    @Override
    public void deleteById(long id) {
        long time = new Date().getTime();
        PurchaseContract purchaseContract = purchaseContractMapper.selectByPrimaryKey(id);
        if(purchaseContract==null || purchaseContract.getIsActive().equals(0)){
            throw new CustomerException("该数据已不存在");
        }else {
            purchaseContract.setIsActive(0);
            purchaseContract.setTime(time);
            purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        }
    }

    @Override
    public void saveOrUpdate(PurchaseContract purchaseContract) {
        long time = new Date().getTime();
        if(purchaseContract.getId() != null){
            purchaseContract.setTime(time);
            purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        }else {
            purchaseContract.setId(IDUtils.getId());
            purchaseContract.setIsActive(1);
            purchaseContract.setTime(time);
            purchaseContract.setFirstAudit(0);
            purchaseContract.setSecondAudit(0);
            purchaseContract.setThreeAudit(0);
            purchaseContractMapper.insert(purchaseContract);
        }
    }

    @Override
    public List<PurchaseContract> findAllLikeByContractNo(String contractNo) {
        List<PurchaseContract> purchaseContracts = purchaseContractExtendMapper.findAllLikeByContractNo(contractNo);
        return purchaseContracts;
    }

}
