package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseProjectExtendMapper {
    /**
     * 根据项目名模糊查询
     * @param name
     * @return
     */
    List<PurchaseProject> findAllLike(@Param("name") String name);
}
