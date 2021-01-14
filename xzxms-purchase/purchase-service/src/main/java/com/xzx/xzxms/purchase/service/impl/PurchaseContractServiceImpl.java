package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.*;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseSupplyMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractExtendMapper;
import com.xzx.xzxms.purchase.dto.PurchaseItemsExcelImportDTO;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseContractServiceImpl implements IPurchaseContractService {

    @Resource
    private PurchaseContractMapper purchaseContractMapper;
    @Resource
    private PurchaseContractExtendMapper purchaseContractExtendMapper;
    @Resource
    private PurchaseSupplyMapper purchaseSupplyMapper;
    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;


    /**
     * 通过项目id进行查询
     * @param projectId
     * @return
     */
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

    /**
     * 逻辑假删
     * @param id
     */
    @Transactional
    @Override
    public void deleteById(Long id) {
        PurchaseContract purchaseContract = purchaseContractMapper.selectByPrimaryKey(id);
        if(purchaseContract == null || purchaseContract.getIsActive().equals(CommonConstant.INVALID)){
            throw new CustomerException("该数据已不存在");
        }else {
            long time = new Date().getTime();

            PurchaseItemsExample example = new PurchaseItemsExample();
            example.createCriteria().andContractIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            List<PurchaseItems> list = purchaseItemsMapper.selectByExample(example);
            if (list.size() > 0){
                for(PurchaseItems p : list){
                    p.setContractId(null);
                    purchaseItemsMapper.updateByPrimaryKey(p);
                }
            }

            purchaseContract.setIsActive(CommonConstant.INVALID);
            purchaseContract.setUpdateTime(time);
            purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        }
    }

    /**
     * 新增或者修改合同
     * @param purchaseContract
     */
    @Override
    public void saveOrUpdate(PurchaseContract purchaseContract) {
        long time = new Date().getTime();
        if(purchaseContract.getId()!= null){
            purchaseContract.setTime(time);
            purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        }else {
            purchaseContract.setId(IDUtils.getId());
            purchaseContract.setIsActive(1);
            purchaseContract.setTime(time);
            purchaseContractMapper.insert(purchaseContract);
        }
    }

    /**
     * 根据合同编码进行模糊查询
     * @param contractNo
     * @return
     */
    @Override
    public List<PurchaseContract> findAllLikeByContractNo(String contractNo) {
        List<PurchaseContract> purchaseContracts = purchaseContractExtendMapper.findAllLikeByContractNo(contractNo);
        return purchaseContracts;
    }


    @Override
    public void updateSupplyPrice(PurchaseSupply purchaseSupply) {

        if(purchaseSupply.getPrice() != null && purchaseSupply.getNumber() != null){

            purchaseSupply.setTotalPrice(purchaseSupply.getPrice()*purchaseSupply.getNumber());
            purchaseSupply.setUpdateTime(new Date().getTime());
            purchaseSupplyMapper.updateByPrimaryKeySelective(purchaseSupply);
        }else {
            throw new CustomerException("供货单价或供货数量不能为空!");
        }
    }
}
