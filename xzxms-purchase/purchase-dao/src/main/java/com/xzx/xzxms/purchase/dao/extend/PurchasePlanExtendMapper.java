package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.vm.PurchaseItemsVM;
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
}
