package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.Supplier;

import java.util.List;

public interface ISupplierService {
    /**
     * 通过id查询编码对象
     * @param id
     */
    List<Supplier> findById(Long id);


    /**
     * 新增或修改编码
     * @param supplier
     */
    void saveOrUpdate(Supplier supplier);

    /**
     * 通过id将is_active置为无效
     * @param id
     */
    void deleteById(long id);
}
