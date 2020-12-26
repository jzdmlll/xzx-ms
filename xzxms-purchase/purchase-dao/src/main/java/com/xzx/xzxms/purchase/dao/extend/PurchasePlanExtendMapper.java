package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.vm.PurchaseItemsVM;
import com.xzx.xzxms.purchase.vm.PurchaseSupplierVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/21 9:43
 * @修改人：
 * @修改时间：2020/12/21 9:43
 * @修改描述：默认描述
 */
@Mapper
@Repository
public interface PurchasePlanExtendMapper {
    /**
     * 根据项目id查询该项目下的所有购买项
     * @param projectId
     * @return
     */
    List<PurchaseItemsVM> findItemsByProjectId(@Param("projectId") String projectId);

    /**
     *
     * @param projectId
     * @param idList
     */
    void updateItemsInquiry(@Param("projectId") String projectId, @Param("idList") List<Long> idList);

    /**
     * 根据项目id获取所有购买项的序号
     * @param projectId
     * @return
     */
    List<Integer> findSerialNumbersByProjectId(@Param("projectId") String projectId);

    /**
     * 当购买项购买数量拆分，新增一条该购买项信息
     * @param purchaseItems
     */
    void insertItem(PurchaseItems purchaseItems);

    /**
     * 当购买项数量拆分时，修改当前购买数量
     * @param itemNum
     */
    void updateItemNumber(@Param("number") int itemNum, @Param("id") Long id);

    /**
     * 根据购买项id查找其供应商
     * @param id
     * @return
     */
    List<PurchaseSupplierVM> findPurchasingSupplierByItemId(@Param("id") Long id);

    /**
     * 根据 projectName 在表 sys_pro_detail 中查询是否有相同项目名
     * @param projectName
     */
    int findProNameByProName(@Param("name") String projectName);

    /**
     * 根据当前 年 月 查询所有符合条件的项目编号
     * @param proNo
     * @return
     */
    List<String> findProNoByYM(@Param("proNo") String proNo);
}
