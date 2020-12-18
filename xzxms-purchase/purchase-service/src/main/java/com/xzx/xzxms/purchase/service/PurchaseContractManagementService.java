package com.xzx.xzxms.purchase.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/15 20:01
 * @修改人：
 * @修改时间：2020/12/15 20:01
 * @修改描述：默认描述
 */

public interface PurchaseContractManagementService {

    /**
     * 查找所有符合条件的项目
     * @param project_name
     * @return
     */
    List<String> FindAllProjectsService(String project_name);
}
