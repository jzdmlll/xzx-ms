package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.purchase.dao.extend.PurchaseContractManagementExtendMapper;
import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/15 20:03
 * @修改人：
 * @修改时间：2020/12/15 20:03
 * @修改描述：默认描述
 */
@Service
@Repository
public class PurchaseContractManagementServiceImpl implements PurchaseContractManagementService {

    @Autowired
    PurchaseContractManagementExtendMapper purchaseContractManagementExtendMapper;

    /**
     * 查找所有符合条件的项目
     * @param project_name
     * @return
     */
    @Override
    public List<String> FindAllProjectsService(String project_name) {
        List<String> allProjects = purchaseContractManagementExtendMapper.FindAllProjects(project_name);
        return allProjects;
    }
}
