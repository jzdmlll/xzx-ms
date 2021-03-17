package com.xzx.xzxms.inquiry.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.inquiry.bean.ProPool;
import com.xzx.xzxms.inquiry.bean.extend.ProPoolExtend;

import java.util.List;

public interface IProductPoolService {

    /**
     * 修改
     * @param proPool
     */
    void addProductPool(ProPool proPool);

    /**
     * 修改
     * @param proPool
     */
    void updateMessage(ProPool proPool);

    /**
     * 查询
     * @param name
     * @param brand 品牌
     //* @param choose 选用标识
     * @return
     */
    IPage<ProPoolExtend> findByParams(Page<ProPoolExtend> page, String name, String brand, String proName, String model);

    /**
     * 批量置为无效（假删）
     * @param ids
     */
    void batchSetInvalid(long[] ids);

    /**
     * 查询历史报价和成本价
     * @param name（设备名）
     * @return
     */
    List<ProPool> findHistoryPrices(String name, String model);

    /**
     * 询价界面模糊查询产品池存在数据
     * @param name
     * @param model
     * @return
     */
    List<ProPool> fuzzyQueryByNameOrModel(String name, String model);
}
