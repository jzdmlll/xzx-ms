package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.*;
import com.xzx.xzxms.purchase.dao.PurchaseBridgeMapper;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseSupplyMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
import com.xzx.xzxms.purchase.vo.SupplyByContractIdVO;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Resource
    private PurchaseBridgeMapper purchaseBridgeMapper;

    /**
     * 通过项目id进行查询
     * @param projectId
     * @return
     */
    @Override
    public List<PurchaseContract> findByProjectId(Long projectId, String contractName) {

/*        PurchaseContractExample example = new PurchaseContractExample();
        if (projectId == null) {
            example.createCriteria().andIsActiveNotEqualTo(0);
        }else {
            example.createCriteria().andProjectIdEqualTo(projectId).andIsActiveNotEqualTo(0);//查除了状态为0的其他合同
        }*/
        List<PurchaseContract> list = purchaseContractExtendMapper.findByProjectId(projectId, contractName);

        return list;
    }

    /**
     * sunny
     * 逻辑假删
     * @param id
     */
    @Transactional
    @Override
    public void deleteById(Long id) {

        PurchaseContract purchaseContract = purchaseContractMapper.selectByPrimaryKey(id);
        if(purchaseContract == null || (CommonConstant.INVALID).equals(purchaseContract.getIsActive())){
            throw new CustomerException("数据已不存在");
        }

        if (purchaseContract.getFirstAudit() != null){
            throw new CustomerException("合同已发往审核,请勿删除!");
        }

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

    /**
     * 新增或者修改合同
     * @param purchaseContract
     */
    @Transactional
    @Override
    public void saveOrUpdate(PurchaseContract purchaseContract) {
        long time = new Date().getTime();
        if(purchaseContract.getId() != null){
            //先判定是否已送审(是否有送审人)
            PurchaseContract pc = purchaseContractMapper.selectByPrimaryKey(purchaseContract.getId());
            if (pc.getIsActive() == CommonConstant.EFFECTIVE && pc.getSender() != null){
                throw new CustomerException("已送审!请勿修改合同信息");
            }
            purchaseContract.setUpdateTime(time);
            purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        }else {
            Long contractId = IDUtils.getId();
            purchaseContract.setId(contractId);
            purchaseContract.setIsActive(CommonConstant.EFFECTIVE);
            purchaseContract.setTime(time);
            purchaseContractMapper.insert(purchaseContract);

            PurchaseBridge purchaseBridge = new PurchaseBridge();
            purchaseBridge.setId(IDUtils.getId());
            purchaseBridge.setPurchaseProjectId(purchaseContract.getProjectId());
            purchaseBridge.setPurchaseContractId(contractId);
            purchaseBridgeMapper.insert(purchaseBridge);
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

        PurchaseSupply ps = purchaseSupplyMapper.selectByPrimaryKey(purchaseSupply.getId());

        if(ps.getPrice() != null && ps.getNumber() != null){
            //将修改前的供货价存入到被修正价保存
            ps.setRevisedPrice(ps.getPrice());
            //再将修正后的价格覆盖掉修正前的价格
            ps.setPrice(purchaseSupply.getRevisedPrice());
            ps.setRevisePeople(purchaseSupply.getRevisePeople());
            ps.setRevisedRemark(purchaseSupply.getRevisedRemark());
            ps.setReviseTime(new Date().getTime());
            ps.setTotalPrice(purchaseSupply.getRevisedPrice() * ps.getNumber());
            purchaseSupplyMapper.updateByPrimaryKeySelective(ps);
        }else {
            throw new CustomerException("供货单价或供货数量不能为空!");
        }
    }

    @Override
    public List<SysFile> findContractFileByContractId(Long contractId) {

        List<SysFile> sysFiles = purchaseContractExtendMapper.findContractFileByContractId(contractId, SysFileExtend.TYPE_PURCHASE_CONTRACT);
        return sysFiles;
    }

    /**
     * tjz
     * 自动生成合同编码
     * @return
     */
    @Override
    public String automaticGenerationContractNo() {
        //获取当前年月日，按照yyyyMMdd格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String YMD = df.format(new Date());
        List<String> contractNoByYMD = purchaseContractExtendMapper.findContractNoByYMD(YMD);
        //判断当前年月日有没有合同
        if(contractNoByYMD.size()>0) {
            //已有合同时生成合同编码
            //下面是按照“-”分割字段
            List<Integer> No = new ArrayList<>();
            for (String a : contractNoByYMD) {
                No.add(Integer.parseInt(a.split("-")[1]));
            }
            //使用方法排序，获取最大的编码序号
            Collections.sort(No);
            int maxNo = No.get(No.size() - 1);
            //尝试解决结果一位时前面补0
            DecimalFormat myDf = new DecimalFormat("00");
            String myNo = myDf.format(maxNo+1);
            //生成采购合同编码
            String newContractNo = "XGXZXGX" + YMD + "-" + myNo;
            return newContractNo;
        }else {
            //无合同时生成合同编码
            String newContractNo = "XGXZXGX" + YMD + "-" + "01";
            return newContractNo;
        }
    }

    @Override
    public void purchaseContractSend(PurchaseContract purchaseContract) {

        //先判定是否已送审(是否有送审人)
        PurchaseContract pc = purchaseContractMapper.selectByPrimaryKey(purchaseContract.getId());
        if (pc.getIsActive() == CommonConstant.EFFECTIVE && !StringUtils.isEmpty(pc.getSender())){
            throw new CustomerException("已送审!请勿重复提交");
        }
        purchaseContract.setSendTime(new Date().getTime());
        purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
    }

    @Override
    public List<SupplyByContractIdVO> findSupplyByContractId(Long contractId) {
        List<SupplyByContractIdVO> list = purchaseContractExtendMapper.findSupplyByContractId(contractId);
        return list;
    }
}
