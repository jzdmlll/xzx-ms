package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.inquiry.dao.extend.ProPurchaseExtendMapper;
import com.xzx.xzxms.inquiry.vm.ProPurchase;
import com.xzx.xzxms.purchase.bean.*;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseProjectMapper;
import com.xzx.xzxms.purchase.dao.PurchaseSupplyMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchasePlanExtendMapper;
import com.xzx.xzxms.purchase.dto.PurchaseItemsDTO;
import com.xzx.xzxms.purchase.dto.PurchaseItemsExcelImportDTO;
import com.xzx.xzxms.purchase.dto.PurchaseItemsListDTO;
import com.xzx.xzxms.purchase.service.PurchasePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import com.xzx.xzxms.purchase.vo.PurchaseItemsVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/21 15:15
 * @修改人：
 * @修改时间：2020/12/21 15:15
 * @修改描述：默认描述
 */
@Service
public class PurchasePlanServiceImpl implements PurchasePlanService {

    @Autowired
    private PurchasePlanExtendMapper purchasePlanExtendMapper;

    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;

    @Resource
    private SysProDetailMapper sysProDetailMapper;

    @Resource
    private InquiryMapper inquiryMapper;

    @Resource
    private ProPurchaseExtendMapper proPurchaseExtendMapper;

    @Resource
    private PurchaseProjectMapper purchaseProjectMapper;

    @Resource
    private PurchaseSupplyMapper purchaseSupplyMapper;

    /**
     * 周嘉玮
     * 根据项目id查询该项目下的所有购买项
     * @param projectId
     * @return
     */
    @Override
    public List<PurchaseItemsVO> findItemsByProjectIdService(Long projectId) {
        List<PurchaseItemsVO> itemsList = purchasePlanExtendMapper.findItemsByProjectId(projectId);
        return itemsList;
    }

    /**
     * 周嘉玮
     * @param purchaseItemsDTO
     * @return
     */
    @Override
    public String updateItemsInquiryService(PurchaseItemsDTO purchaseItemsDTO) {
        PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
        // 根据 is_active、project_id、id 这三个字段去查询需要修改的结果集
        purchaseItemsExample.createCriteria().andIsActiveEqualTo(1).andProjectIdEqualTo(purchaseItemsDTO.getPurchaseItems().getProjectId()).andIdIn(purchaseItemsDTO.getItemIds());

        // 需修改内容：询价状态、修改人、修改时间
        PurchaseItems purchaseItems = new PurchaseItems();
        purchaseItems.setIsInquiry(1);
        purchaseItems.setUpdateOperator(purchaseItemsDTO.getPurchaseItems().getOperator());
        purchaseItems.setUpdateTime(new Date().getTime());
        purchaseItemsMapper.updateByExampleSelective(purchaseItems, purchaseItemsExample);
        return "success";
    }

    /**
     * 周嘉玮
     * @param purchaseItems
     * @param itemNum
     * @return
     */
    @Transactional
    @Override
    synchronized public String insertItemService(PurchaseItems purchaseItems, Double itemNum) {
        
        // 根据项目id获取所有购买项的序号
        List<Double> serialNumbers = purchasePlanExtendMapper.findSerialNumbersByProjectId(purchaseItems.getProjectId());

        // 给所有序号进行排序
        Collections.sort(serialNumbers);

        // 获取最大一个序号
        Double maxSerialNumber = serialNumbers.get(serialNumbers.size()-1);

        // 新增数据序号 在原有最大序号上加一
        purchaseItems.setSerialNumber(maxSerialNumber+1);

        // 获取数据库中实际购买数量
        double number = purchasePlanExtendMapper.findNumberById(purchaseItems.getId());

        // 新增数据购买项的数量 = 实际购买数量 - 此次实际购买量
        purchaseItems.setNumber(number - itemNum);

        // 获取当前时间
        purchaseItems.setTime(new Date().getTime());

        // 获取原id
        Long id = purchaseItems.getId();

        // 生成id
        purchaseItems.setId(IDUtils.getId());

        // 插入新数据
        purchasePlanExtendMapper.insertItem(purchaseItems);

        // 修改原数据，修改其数量、操作员、操作时间
        purchasePlanExtendMapper.updateItemNumber(itemNum, id, purchaseItems.getOperator(), new Date().getTime());

        //
        return "success";
    }

    /**
     * 周嘉玮
     * @param id
     * @return
     */
    @Override
    public List<PurchaseSupply> findPurchasingSupplierByItemIdService(Long id) {
        return purchasePlanExtendMapper.findPurchasingSupplierByItemId(id);
    }

    /**
     * 周嘉玮
     * 修改人:sunny
     * 2021/01/25
     * @param purchaseItemsList
     * @return
     */
    @Transactional
    @Override
    public String insertSysProDetailService(PurchaseItemsListDTO purchaseItemsList) {
        // 获取项目id 判断该项目名是否已经存在
        Long result = purchasePlanExtendMapper.findProNameByProName(purchaseItemsList.getSysProDetailWithBLOBs().getName());
        // 当项目名称不重复
        if (result == null){
            // 获取当前年月
            SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
            String YM = df.format(new Date());
            // 获取该年月所有项目编号
            List<String> proNoByYM = purchasePlanExtendMapper.findProNoByYM(YM);
            // 将所得项目编号根据 " - " 分割 得到所有项目序号
            List<Integer> No = new ArrayList();
            for (String s : proNoByYM) {
                No.add(Integer.parseInt(s.split("-")[1]));
            }
            // 将所得No集合进行排序得到最大值
            // 给所有序号进行排序
            Collections.sort(No);
            // 获取最大一个序号
            int maxNo = No.get(No.size()-1);
            // 生成id
            Long id = IDUtils.getId();
            // 新建项目编号
            String newProNo = YM + "-" + (maxNo+1);
            // 生成时间戳
            Long time = new Date().getTime();

            purchaseItemsList.getSysProDetailWithBLOBs().setId(id);
            purchaseItemsList.getSysProDetailWithBLOBs().setProNo(newProNo);
            purchaseItemsList.getSysProDetailWithBLOBs().setIsActive(CommonConstant.EFFECTIVE);
            purchaseItemsList.getSysProDetailWithBLOBs().setIsUseful(CommonConstant.IS_NOT_USEFUL);
            purchaseItemsList.getSysProDetailWithBLOBs().setTime(time);
            // 根据项目id查找项目名
            String proName = purchasePlanExtendMapper.findProNameByProId(purchaseItemsList.getSysProDetailWithBLOBs().getPurchaseProId());
            purchaseItemsList.getSysProDetailWithBLOBs().setName(proName);
            // 向sys_pro_detail表中插入新项目
            sysProDetailMapper.insert(purchaseItemsList.getSysProDetailWithBLOBs());

            Inquiry inquiry = new Inquiry();
            List<Long> itemIds = new ArrayList<>();
            for (PurchaseItems item : purchaseItemsList.getPurchaseItemsList()) {
                inquiry.setId(IDUtils.getId());
                // 在根据item_id去purchase_items表中获取该购买项相关信息
                PurchaseItems itemInfo = purchasePlanExtendMapper.findItemInfoById(item.getId());
                inquiry.setName(itemInfo.getItem());
                inquiry.setRealBrand(itemInfo.getBrand());
                inquiry.setParams(itemInfo.getParams());
                inquiry.setModel(itemInfo.getModel());
                inquiry.setUnit(itemInfo.getUnit());
                inquiry.setNumber(itemInfo.getNumber());
                inquiry.setSort(itemInfo.getSerialNumber());
                inquiry.setIsinquiry(CommonConstant.IS_INQUIRY);
                inquiry.setVeto(CommonConstant.NOT_VETOED);
                inquiry.setProDetailId(id);
                inquiry.setIsActive(CommonConstant.EFFECTIVE);
                inquiry.setIsUseful(CommonConstant.IS_NOT_USEFUL);
                inquiry.setOperator(purchaseItemsList.getSysProDetailWithBLOBs().getOperator());
                inquiry.setTime(new Date().getTime());
                inquiry.setItemId(item.getId());

                //新增项
                inquiry.setTagNumber(itemInfo.getTagNumer());
                inquiry.setMeter(itemInfo.getMeter());
                inquiry.setMeasuringRange(itemInfo.getMeasuringRange());
                inquiry.setMeterSignal(itemInfo.getMeterSignal());
                inquiry.setConnectionMode(itemInfo.getConnectionMode());
                inquiry.setTube(itemInfo.getTube());

                inquiryMapper.insert(inquiry);
                // 获取所有的item的id
                itemIds.add(item.getId());
            }

            // 更新采购项目是否需要询价
            PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
            // 根据 is_active、id 这两个字段去查询需要修改的结果集
            purchaseItemsExample.createCriteria().andIsActiveEqualTo(1).andIdIn(itemIds);

            // 需修改内容：询价状态、修改人、修改时间
            PurchaseItems purchaseItems = new PurchaseItems();
            purchaseItems.setIsInquiry(1);
            purchaseItems.setUpdateOperator(purchaseItemsList.getSysProDetailWithBLOBs().getOperator());
            purchaseItems.setUpdateTime(new Date().getTime());
            purchaseItemsMapper.updateByExampleSelective(purchaseItems, purchaseItemsExample);


            return "success";
        // 当项目名存在时
        }else {
            String name = purchaseItemsList.getSysProDetailWithBLOBs().getName();
            List<Long> itemIds = new ArrayList<>();
            for (PurchaseItems item : purchaseItemsList.getPurchaseItemsList()) {
                Double sort = purchasePlanExtendMapper.findSort(name, item.getSerialNumber());
                // 当该购买项不存在时
                if (sort == null){
                    Inquiry inquiry = new Inquiry();
                    inquiry.setId(IDUtils.getId());
                    // 在根据item_id去purchase_items表中获取该购买项相关信息
                    PurchaseItems itemInfo = purchasePlanExtendMapper.findItemInfoById(item.getId());
                    inquiry.setName(itemInfo.getItem());
                    inquiry.setRealBrand(itemInfo.getBrand());
                    inquiry.setParams(itemInfo.getParams());
                    inquiry.setModel(itemInfo.getModel());
                    inquiry.setUnit(itemInfo.getUnit());
                    inquiry.setNumber(itemInfo.getNumber());
                    inquiry.setSort(itemInfo.getSerialNumber());
                    inquiry.setIsinquiry(1);
                    inquiry.setVeto(0);
                    inquiry.setProDetailId(result);
                    inquiry.setIsActive(1);
                    inquiry.setIsUseful(0);
                    inquiry.setOperator(purchaseItemsList.getSysProDetailWithBLOBs().getOperator());
                    inquiry.setTime(new Date().getTime());
                    inquiry.setItemId(item.getId());

                    //新增项
                    inquiry.setTagNumber(itemInfo.getTagNumer());
                    inquiry.setMeter(itemInfo.getMeter());
                    inquiry.setMeasuringRange(itemInfo.getMeasuringRange());
                    inquiry.setMeterSignal(itemInfo.getMeterSignal());
                    inquiry.setConnectionMode(itemInfo.getConnectionMode());
                    inquiry.setTube(itemInfo.getTube());

                    inquiryMapper.insert(inquiry);
                    System.out.println("添加：" + item.getSerialNumber());
                    // 获取所有的item的id
                    itemIds.add(item.getId());
                // 当该购买项已存在时
                }else {
                    System.out.println("该购买项已存在 " + item.getSerialNumber());
                    throw new CustomerException("该购买项已存在 " + item.getItem());
                }

                // 更新采购项目是否需要询价
                PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
                // 根据 is_active、id 这两个字段去查询需要修改的结果集
                purchaseItemsExample.createCriteria().andIsActiveEqualTo(1).andIdIn(itemIds);

                // 需修改内容：询价状态、修改人、修改时间
                PurchaseItems purchaseItems = new PurchaseItems();
                purchaseItems.setIsInquiry(1);
                purchaseItems.setUpdateOperator(purchaseItemsList.getSysProDetailWithBLOBs().getOperator());
                purchaseItems.setUpdateTime(new Date().getTime());
                purchaseItemsMapper.updateByExampleSelective(purchaseItems, purchaseItemsExample);
            }
            return "success";
        }
    }

    /**
     * 孙乃裕
     * @param purchaseItems
     */
    @Override
    public void addPurchaseItem(PurchaseItems purchaseItems) {

        int num = checkSerialNumberIsExists(purchaseItems.getProjectId(), purchaseItems.getSerialNumber());
        if (num > 0){
            throw new CustomerException("此采购项序号已存在，不能重复插入!");
        }
        purchaseItems.setId(IDUtils.getId());
        purchaseItems.setTime(new Date().getTime());
        purchaseItems.setIsInquiry(0);
        purchaseItems.setIsActive(CommonConstant.EFFECTIVE);
        purchaseItemsMapper.insert(purchaseItems);
    }

    /**
     * 孙乃裕
     * 修改人：tjz
     * @param purchaseItems
     */
    @Override
    public void updatePurchaseItem(PurchaseItems purchaseItems) {
        //增加了判断是否发往询价，没有才能修改
        int num = checkSerialNumberIsExists(purchaseItems.getProjectId(), purchaseItems.getSerialNumber());
        if (num > 0){
            throw new CustomerException("此采购项序号已存在，不能重复插入!");
        }else {
            if(purchaseItems.getIsInquiry()!=0) {
                throw new CustomerException("已经发往询价，请勿修改");
            }else {
                purchaseItems.setUpdateTime(new Date().getTime());
                purchaseItemsMapper.updateByPrimaryKeySelective(purchaseItems);
            }
        }
    }

    /**
     * 孙乃裕
     * @param purchaseItemsDTO
     */
    @Transactional
    @Override
    public void excelPurchaseItems(PurchaseItemsExcelImportDTO purchaseItemsDTO) {
        List<PurchaseItems> list = purchaseItemsDTO.getPurchaseItems();
        for(PurchaseItems purchaseItems : list){
            int num = checkSerialNumberIsExists(purchaseItems.getProjectId(), purchaseItems.getSerialNumber());
            if (num > 0){
                throw new CustomerException("此采购项序号已存在，不能重复插入!");
            }
            purchaseItems.setId(IDUtils.getId());
            purchaseItems.setTime(new Date().getTime());
            purchaseItems.setIsActive(CommonConstant.EFFECTIVE);
            purchaseItems.setIsInquiry(CommonConstant.IS_NOT_INQUIRY);
            purchaseItemsMapper.insert(purchaseItems);
        }
    }


    /**
     * 孙乃裕
     * @param projectId
     * @param serialNum
     */
    @Override
    public int checkSerialNumberIsExists(Long projectId, Double serialNum){
        return purchasePlanExtendMapper.findSerialNumber(projectId, serialNum);
    }

    @Transactional
    @Override
    public void inquiryResultSendPurchase(Long[] quoteIds, Long operator) {

        Long purchaseProjectId;

        for(long id : quoteIds){
            List<ProPurchase> proPurchases = proPurchaseExtendMapper.findInquiryResult(id);

            if (proPurchases.size() > 0){

                ProPurchase proPurchase = proPurchases.get(0);

                if (proPurchase.getInquiry().getItemId() == null){

                    purchaseProjectId = proPurchase.getPurchaseProId();

                    if (purchaseProjectId == null){

                        //先生成采购项目
                        PurchaseProject purchaseProject = new PurchaseProject();
                        purchaseProjectId = IDUtils.getId();
                        purchaseProject.setId(purchaseProjectId);
                        purchaseProject.setProjectName(proPurchase.getName());
                        purchaseProject.setIsActive(CommonConstant.EFFECTIVE);
                        purchaseProject.setOperator(operator + "");
                        purchaseProject.setTime(new Date().getTime());
                        purchaseProject.setInquiryProId(proPurchase.getId());
                        purchaseProject.setPurchaseProNo(proPurchase.getProNo());
                        purchaseProjectMapper.insert(purchaseProject);

                        //修改询价项目表中的采购项目ID
                        SysProDetailWithBLOBs sysProDetail = new SysProDetailWithBLOBs();
                        sysProDetail.setId(proPurchase.getId());
                        sysProDetail.setPurchaseProId(purchaseProjectId);
                        sysProDetailMapper.updateByPrimaryKeySelective(sysProDetail);
                    }

                    //再生成采购需求项
                    PurchaseItems purchaseItems = new PurchaseItems();
                    long purchaseItemsId = IDUtils.getId();
                    purchaseItems.setId(purchaseItemsId);
                    purchaseItems.setProjectId(purchaseProjectId);
                    purchaseItems.setSerialNumber(proPurchase.getInquiry().getSort());
                    purchaseItems.setItem(proPurchase.getInquiry().getName());
                    purchaseItems.setBrand(proPurchase.getInquiry().getBrand());
                    purchaseItems.setParams(proPurchase.getInquiry().getParams());
                    purchaseItems.setModel(proPurchase.getInquiry().getModel());
                    purchaseItems.setUnit(proPurchase.getInquiry().getUnit());
                    purchaseItems.setSalePrice(proPurchase.getInquiry().getCorrectPrice());
                    purchaseItems.setRequiredDelivery(proPurchase.getInquiry().getRequiredDelivery());
                    purchaseItems.setNumber(proPurchase.getInquiry().getNumber());
                    purchaseItems.setRemark(proPurchase.getInquiry().getRemark());
                    purchaseItems.setIsInquiry(CommonConstant.IS_INQUIRY);
                    purchaseItems.setIsActive(CommonConstant.EFFECTIVE);
                    purchaseItems.setOperator(operator+"");
                    purchaseItems.setTime(new Date().getTime());

                    //新增
                    purchaseItems.setTagNumer(proPurchase.getInquiry().getTagNumber());
                    purchaseItems.setMeter(proPurchase.getInquiry().getMeter());
                    purchaseItems.setMeasuringRange(proPurchase.getInquiry().getMeasuringRange());
                    purchaseItems.setMeterSignal(proPurchase.getInquiry().getMeterSignal());
                    purchaseItems.setConnectionMode(proPurchase.getInquiry().getConnectionMode());
                    purchaseItems.setTube(proPurchase.getInquiry().getTube());

                    purchaseItemsMapper.insert(purchaseItems);

                    //最后生成供货表
                    PurchaseSupply purchaseSupply = new PurchaseSupply();
                    long purchaseSupplyId = IDUtils.getId();
                    purchaseSupply.setId(purchaseSupplyId);
                    purchaseSupply.setSupplierId(proPurchase.getQuote().getSupplierId());
                    purchaseSupply.setSupplier(proPurchase.getQuote().getSupplier());
                    purchaseSupply.setItemId(purchaseItemsId);
                    purchaseSupply.setModel(proPurchase.getQuote().getSuModel());
                    purchaseSupply.setBrand(proPurchase.getQuote().getSuBrand());
                    purchaseSupply.setParams(proPurchase.getQuote().getSuParams());
                    purchaseSupply.setPrice(proPurchase.getQuote().getSuPrice());
                    purchaseSupply.setDelivery(proPurchase.getQuote().getSuDelivery());
                    purchaseSupply.setRemark(proPurchase.getQuote().getSuRemark());
                    purchaseSupply.setNumber(proPurchase.getInquiry().getNumber());
                    purchaseSupply.setWarranty(proPurchase.getQuote().getWarranty());
                    purchaseSupply.setIsActive(CommonConstant.EFFECTIVE);
                    purchaseSupply.setOperator(operator+"");
                    purchaseSupply.setTime(new Date().getTime());
                    purchaseSupply.setImage(proPurchase.getQuote().getImage());
                    purchaseSupplyMapper.insert(purchaseSupply);

                    //修改询价表中采购项ID
                    Inquiry inquiry = proPurchase.getInquiry();
                    inquiry.setItemId(purchaseItemsId);
                    inquiryMapper.updateByPrimaryKeySelective(inquiry);

                }else {
                    throw new CustomerException("提交异常, 此询价结果已发往采购!");
                }
            }else {
                throw new CustomerException("提交异常，存在询价结果供应商报价无效!");
            }
        }
    }

    /**
     * 周嘉玮
     * 从产品池选择完以后，将信息插入purchase_supply
     * @param purchaseSupply
     * @return
     */
    @Override
    public String insertSupplyByItemService(PurchaseSupply purchaseSupply) {

        PurchaseSupplyExample example = new PurchaseSupplyExample();
        example.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE).andItemIdEqualTo(purchaseSupply.getItemId());
        Long num = purchaseSupplyMapper.countByExample(example);

        if(num > 0){
            throw new CustomerException("已存在供货商，如需重新选择，请先删除已有的供货商!");
        }

        purchaseSupply.setId(IDUtils.getId());
        purchaseSupply.setIsActive(CommonConstant.EFFECTIVE);
        purchaseSupply.setArrivalStatus(0);
        purchaseSupply.setTime(new Date().getTime());
        purchaseSupplyMapper.insert(purchaseSupply);
        return "success";
    }

    @Override
    public void deletePurchaseSupply(PurchaseSupply purchaseSupply) {

        PurchaseItemsExample example = new PurchaseItemsExample();
        example.createCriteria().andIdEqualTo(purchaseSupply.getItemId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<PurchaseItems> list = purchaseItemsMapper.selectByExample(example);
        if(list.size() > 0){
            PurchaseItems purchaseItems = list.get(0);
            if(purchaseItems.getContractId() != null){
                //不存在合同则可以删除
                purchaseSupply.setIsActive(CommonConstant.INVALID);
                purchaseSupply.setUpdateTime(new Date().getTime());
                purchaseSupplyMapper.updateByPrimaryKeySelective(purchaseSupply);
            }else{
                throw new CustomerException("此采购项已建立合同,无法删除，如需删除，请先撤销系统编号为" + purchaseItems.getContractId() + "合同!");
            }
        }
    }

    @Override
    public void updatePurchaseSupply(PurchaseSupply purchaseSupply) {

        PurchaseItemsExample example = new PurchaseItemsExample();
        example.createCriteria().andIdEqualTo(purchaseSupply.getItemId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<PurchaseItems> list = purchaseItemsMapper.selectByExample(example);
        if(list.size() > 0){
            PurchaseItems purchaseItems = list.get(0);
            if(purchaseItems.getContractId() != null){
                //不存在合同则可以修改
                purchaseSupply.setUpdateTime(new Date().getTime());
                purchaseSupplyMapper.updateByPrimaryKeySelective(purchaseSupply);
            }else{
                throw new CustomerException("此采购项已建立合同,无法修改，如需修改，请先撤销系统编号为" + purchaseItems.getContractId() + "合同!");
            }
        }
    }

    @Override
    public void updatePurchaseItems(PurchaseItems purchaseItems) {

        PurchaseItemsExample example = new PurchaseItemsExample();
        example.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE).andIdEqualTo(purchaseItems.getId());
        List<PurchaseItems> list = purchaseItemsMapper.selectByExample(example);
        if(list.size() > 0){
            if(CommonConstant.IS_INQUIRY.equals(list.get(0).getIsInquiry())){
                throw new CustomerException("已发往询价，请勿修改操作!");
            }else {
                PurchaseSupplyExample supplyExample = new PurchaseSupplyExample();
                supplyExample.createCriteria().andItemIdEqualTo(purchaseItems.getId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
                List<PurchaseSupply> supplies = purchaseSupplyMapper.selectByExample(supplyExample);
                if(supplies.size() > 0){
                    throw new CustomerException("已存在供货商，请勿修改采购项信息，如需修改，先删除供货商!");
                }else{
                    purchaseItems.setUpdateTime(new Date().getTime());
                    purchaseItemsMapper.updateByPrimaryKeySelective(purchaseItems);
                }
            }
        }
    }

    /**
     * 修改人：tjz
     * @param purchaseItemIds 采购项 ID数组
     * @param operator
     */
    @Transactional
    @Override
    public void logicDeletePurchaseItems(Long[] purchaseItemIds,String operator) {
        PurchaseItems purchaseItems = new PurchaseItems();
        long time = new Date().getTime();
        for (Long purchaseItemId : purchaseItemIds) {
            //判断采购项相关的采购供货数量是否大于0，有供货数量就不可删除采购项
            PurchaseSupplyExample example = new PurchaseSupplyExample();
            example.createCriteria().andItemIdEqualTo(purchaseItemId).andNumberGreaterThan(0.0).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            List<PurchaseSupply> list = purchaseSupplyMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("采购项已有采购供货，不可删除");
            }else {
                purchaseItems.setId(purchaseItemId);
                purchaseItems.setIsActive(CommonConstant.INVALID);
                purchaseItems.setUpdateOperator(operator);
                purchaseItems.setUpdateTime(time);
                purchaseItemsMapper.updateByPrimaryKeySelective(purchaseItems);
            }
        }
    }
}
