package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.vm.PurchaseContractVM;
import com.xzx.xzxms.purchase.vm.PurchaseProjectVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：合同管理
 * @date：2020/12/15 19:07
 * @修改人：
 * @修改时间：2020/12/15 19:07
 * @修改描述：默认描述
 */
@Mapper
@Repository
public interface PurchaseContractManagementExtendMapper {

    /**
     * 查询所有项目
     * @param projectName
     * @return
     */
    List<PurchaseProjectVM> findAllProjects(@Param("projectName") String projectName);

    /**
     * 根据项目编号查找其对应合同
     * @param projectId
     * @return
     */
    List<PurchaseContractVM> findContractByProjectId(@Param("projectId") Long projectId);

    /**
     * 根据合同id修改合同审核级别
     * @param firstAudit
     * @param secondAudit
     * @param threeAudit
     * @param id
     */
    void updateContractAuditById(@Param("firstAudit") Integer firstAudit,
                                 @Param("secondAudit") Integer secondAudit,
                                 @Param("threeAudit") Integer threeAudit,
                                 @Param("id") Long id);
}
