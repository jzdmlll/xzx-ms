package com.xzx.xzxms.purchase.dao;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseContractMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    long countByExample(PurchaseContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int deleteByExample(PurchaseContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int insert(PurchaseContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int insertSelective(PurchaseContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    List<PurchaseContract> selectByExample(PurchaseContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    PurchaseContract selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int updateByExampleSelective(@Param("record") PurchaseContract record, @Param("example") PurchaseContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int updateByExample(@Param("record") PurchaseContract record, @Param("example") PurchaseContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int updateByPrimaryKeySelective(PurchaseContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_contract
     *
     * @mbg.generated Fri Feb 05 08:59:35 CST 2021
     */
    int updateByPrimaryKey(PurchaseContract record);
}