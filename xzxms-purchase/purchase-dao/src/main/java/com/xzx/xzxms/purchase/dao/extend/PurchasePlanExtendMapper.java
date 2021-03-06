package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.vo.PurchaseItemsVO;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
     * 周嘉玮
     * 根据项目id查询该项目下的所有购买项
     * @param projectId
     * @return
     */
    List<PurchaseItemsVO> findItemsByProjectId(@Param("projectId") Long projectId);

    /**
     * 周嘉玮
     * @param projectId
     * @param idList
     */
    void updateItemsInquiry(@Param("projectId") Long projectId, @Param("idList") List<Long> idList);

    /**
     * 周嘉玮
     * 根据项目id获取所有购买项的序号
     * @param projectId
     * @return
     */
    List<Double> findSerialNumbersByProjectId(@Param("projectId") Long projectId);

    /**
     * 周嘉玮
     * 当购买项购买数量拆分，新增一条该购买项信息
     * @param purchaseItems
     */
    void insertItem(PurchaseItems purchaseItems);

    /**
     * 周嘉玮
     * 根据购买项id查找其购买数量
     * @param id
     * @return
     */
    Double findNumberById(@Param("id") Long id);

    /**
     * 周嘉玮
     * 根据购买项id查找其相关信息
     * @param id
     * @return
     */
    PurchaseItems findItemInfoById(@Param("id") Long id);

    /**
     * 周嘉玮
     * 根据项目id获取其项目名
     * @param projectId
     * @return
     */
    String findProNameByProId(@Param("projectId") Long projectId);

    /**
     * 周嘉玮
     * 当购买项数量拆分时，修改当前购买数量
     * @param itemNum
     */
    void updateItemNumber(@Param("number") Double itemNum,
                          @Param("id") Long id,
                          @Param("updateOperator") String updateOperator,
                          @Param("updateTime") Long updateTime);

    /**
     * 周嘉玮
     * 根据购买项id查找其供应商
     * @param id
     * @return
     */
    List<PurchaseSupply> findPurchasingSupplierByItemId(@Param("id") Long id);

    /**
     * 周嘉玮
     * 根据 projectId 在表 sys_pro_detail 中查询是否存在
     * @param projectId
     */
    Long findProNameByProName(@Param("id") Long projectId);

    /**
     * 周嘉玮
     * 根据当前 年 月 查询所有符合条件的项目编号
     * @param proNo
     * @return
     */
    List<String> findProNoByYM(@Param("proNo") String proNo);

    /**
     * 周嘉玮
     * 根据项目名称和购买序号 在表inquiry中查询是否有相同询价记录
     * @param name
     * @param sort
     * @return
     */
    Double findSort(@Param("name") String name, @Param("sort") Double sort);

    /**
     * 孙乃裕
     * 根据项目ID和序号查询采购项表是否存在
     * @param projectId
     * @param serialNum
     * @return
     */
    @Select("SELECT COUNT(1) FROM purchase_items WHERE project_id = #{projectId} AND serial_number = #{serialNum} AND is_active = 1")
    int findSerialNumber(@Param("projectId") Long projectId,@Param("serialNum") Double serialNum);

}
