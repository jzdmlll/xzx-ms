package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchasePlanExtendMapper;
import com.xzx.xzxms.purchase.service.PurchasePlanService;
import com.xzx.xzxms.purchase.vm.PurchaseItemsVM;
import com.xzx.xzxms.purchase.vm.PurchaseSupplierVM;
import org.springframework.beans.factory.annotation.Autowired;
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
    PurchasePlanExtendMapper purchasePlanExtendMapper;

    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;

    /**
     * 根据项目id查询该项目下的所有购买项
     * @param projectId
     * @return
     */
    @Override
    public List<PurchaseItemsVM> findItemsByProjectIdService(String projectId) {
        List<PurchaseItemsVM> itemsList = purchasePlanExtendMapper.findItemsByProjectId(projectId);
        return itemsList;
    }

    @Override
    public String updateItemsInquiryService(String projectId, List<Long> idList) {
        PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
        purchaseItemsExample.createCriteria().andProjectIdEqualTo(projectId).andIdIn(idList);
        PurchaseItems purchaseItems = new PurchaseItems();
        purchaseItems.setIsInquiry(1);
        //purchaseItemsMapper.updateByExample(purchaseItems, purchaseItemsExample);
        purchaseItemsMapper.updateByExampleSelective(purchaseItems, purchaseItemsExample);
        return "success";
    }

    @Transactional
    @Override
    synchronized public String insertItemService(PurchaseItems purchaseItems, int itemNum) {
        
        // 根据项目id获取所有购买项的序号
        List<Integer> serialNumbers = purchasePlanExtendMapper.findSerialNumbersByProjectId(purchaseItems.getProjectId());

        // 给所有序号进行排序
        Collections.sort(serialNumbers);

        // 获取最大一个序号
        int maxSerialNumber = serialNumbers.get(serialNumbers.size()-1);
        System.out.println("=======" + maxSerialNumber);

        // 新增数据序号 在原有最大序号上加一
        purchaseItems.setSerialNumber(maxSerialNumber+1);

        // 新增数据购买项的数量 = 原需购买量 - 此次实际购买量
        purchaseItems.setNumber(purchaseItems.getNumber() - itemNum);
        System.out.println("--------" + (purchaseItems.getNumber() - itemNum));

        // 获取当前时间
        purchaseItems.setTime(new Date().getTime());

        // 获取原id
        Long id = purchaseItems.getId();

        // 生成id
        purchaseItems.setId(IDUtils.getId());

        // 插入新数据
        purchasePlanExtendMapper.insertItem(purchaseItems);

        // 修改原数据
        purchasePlanExtendMapper.updateItemNumber(itemNum, id);

        return "success";
    }

    @Override
    public List<PurchaseSupplierVM> findPurchasingSupplierByItemIdService(Long id) {
        List<PurchaseSupplierVM> supplierInfo = purchasePlanExtendMapper.findPurchasingSupplierByItemId(id);

        for (PurchaseSupplierVM purchaseSupplierVM : supplierInfo) {
            System.out.println(purchaseSupplierVM);
        }
        return supplierInfo;
    }

    @Override
    public String insertSysProDetail(SysProDetail sysProDetail) {
        // 获取当前年月
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
        String YM = df.format(new Date());
        
        // 获取该年月所有项目编号
        List<String> proNoByYM = purchasePlanExtendMapper.findProNoByYM(YM);
        
        // 将所得项目编号根据 " - " 分割 得到所有项目序号
        List<Integer> No = new ArrayList();
        for (String s : proNoByYM) {
            No.add(Integer.parseInt(s.split("-")[1]));
            System.out.println("===== " + s);
        }
        System.out.println(No.toString());
        
        // 将所得No集合进行排序得到最大值
        // 给所有序号进行排序
        Collections.sort(No);

        // 获取最大一个序号
        int maxNo = No.get(No.size()-1);
        System.out.println("maxNo " + maxNo);
        
        // 新建项目编号
        
        String newProNo = YM + "-" + (maxNo+1);
        System.out.println(newProNo);

        // 判断该项目名是否已经存在
        int result = purchasePlanExtendMapper.findProNameByProName(sysProDetail.getName());
        if (result == 0){
            return "无重复名";
        }else {
            return "该项目名已存在";
        }
    }
}
