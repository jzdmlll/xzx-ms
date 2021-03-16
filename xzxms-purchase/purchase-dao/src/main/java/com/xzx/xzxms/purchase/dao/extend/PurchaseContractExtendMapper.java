package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.vo.SupplyByContractIdVO;
import com.xzx.xzxms.system.bean.SysFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseContractExtendMapper {
    /**
     * 根据合同编号进行模糊查询
     * @param contractNo
     * @return
     */
    List<PurchaseContract> findAllLikeByContractNo(@Param("contractNo") String contractNo);


    List<SysFile> findContractFileByContractId(@Param("contractId") Long contractId, @Param("type") Integer type);

    /**
     * 通过年月日模糊查询所有符合条件的合同编码contract_no
     * @param contractNo
     * @return
     */
    List<String> findContractNoByYMD(@Param("contractNo") String contractNo);

    /**
     * 通过项目ID 查询出项目下所有的合同(根据桥表查询)
     * @param projectId
     * @param contractName
     * @return
     */
    List<PurchaseContract> findByProjectId(@Param("projectId") Long projectId, @Param("contractName") String contractName);

    /**
     * 根据采购合同ID查询出合同下所有采购项信息
     * @param contractId
     * @return
     */
    List<SupplyByContractIdVO> findSupplyByContractId(Long contractId);
}
