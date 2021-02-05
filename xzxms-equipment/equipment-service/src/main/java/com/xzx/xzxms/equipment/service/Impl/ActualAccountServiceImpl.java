package com.xzx.xzxms.equipment.service.Impl;/**
 * @Author sunny
 * @Date 2021/2/4 14:48
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.equipment.bean.EquipmentActualAccount;
import com.xzx.xzxms.equipment.bean.EquipmentActualAccountExample;
import com.xzx.xzxms.equipment.bean.EquipmentContractOrder;
import com.xzx.xzxms.equipment.dao.EquipmentActualAccountMapper;
import com.xzx.xzxms.equipment.dao.EquipmentContractOrderMapper;
import com.xzx.xzxms.equipment.dao.extend.ActualAccountExtendMapper;
import com.xzx.xzxms.equipment.service.ActualAccountService;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName ActualAccountServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class ActualAccountServiceImpl implements ActualAccountService {

    @Resource
    private EquipmentActualAccountMapper equipmentActualAccountMapper;
    @Resource
    private ActualAccountExtendMapper actualAccountExtendMapper;
    @Resource
    private EquipmentContractOrderMapper equipmentContractOrderMapper;
    @Resource
    private PurchaseContractMapper purchaseContractMapper;

    @Override
    public List<EquipmentActualAccount> findActualAccountByContractId(Long contractId) {

        EquipmentActualAccountExample example = new EquipmentActualAccountExample();
        example.createCriteria().andContractIdEqualTo(contractId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<EquipmentActualAccount> list = equipmentActualAccountMapper.selectByExample(example);
        return list;
    }

    @Override
    public void addActualAccount(EquipmentActualAccount equipmentActualAccount) {

        Double moneys = statisticsActualAccountByContractId(equipmentActualAccount.getContractId());
        if (moneys > 0){
            PurchaseContract purchaseContract = purchaseContractMapper.selectByPrimaryKey(equipmentActualAccount.getContractId());
            if (purchaseContract != null){
                EquipmentContractOrder equipmentContractOrder = equipmentContractOrderMapper.selectByPrimaryKey(purchaseContract.getContactOrderId());
                Double needPay = equipmentContractOrder.getNeedPay();
                Double temp = needPay - moneys - Double.parseDouble(equipmentActualAccount.getMoney());
                if (temp < 0){
                    throw new CustomerException("信息提交错误,付款金额大于未付款金额!");
                }
            }
        }
        equipmentActualAccount.setId(IDUtils.getId());
        equipmentActualAccount.setIsActive(CommonConstant.EFFECTIVE);
        equipmentActualAccountMapper.insert(equipmentActualAccount);
    }

    @Override
    public void setInvalidActualAccount(EquipmentActualAccount equipmentActualAccount) {

        equipmentActualAccount.setUpdateTime(new Date().getTime()+"");
        equipmentActualAccount.setIsActive(CommonConstant.INVALID);
        equipmentActualAccountMapper.updateByPrimaryKeySelective(equipmentActualAccount);
    }

    @Override
    public Double statisticsActualAccountByContractId(Long contractId) {

        Double moneys = actualAccountExtendMapper.statisticsActualAccountByContractId(contractId);
        return moneys;
    }
}
