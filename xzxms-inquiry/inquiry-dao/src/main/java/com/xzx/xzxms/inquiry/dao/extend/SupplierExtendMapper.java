package com.xzx.xzxms.inquiry.dao.extend;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierExtendMapper {
    /**
     * 根据供应商名字模糊查询相关内容
     * @param name
     * @return
     */
    // List<Supplier> findAllLike(@Param("name") String name);
}
