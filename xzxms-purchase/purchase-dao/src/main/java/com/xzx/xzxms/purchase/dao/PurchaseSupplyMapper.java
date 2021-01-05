package com.xzx.xzxms.purchase.dao;

import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import com.xzx.xzxms.purchase.bean.PurchaseSupplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseSupplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    long countByExample(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int deleteByExample(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int insert(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int insertSelective(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    List<PurchaseSupply> selectByExampleWithBLOBs(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    List<PurchaseSupply> selectByExample(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    PurchaseSupply selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int updateByExampleSelective(@Param("record") PurchaseSupply record, @Param("example") PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") PurchaseSupply record, @Param("example") PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int updateByExample(@Param("record") PurchaseSupply record, @Param("example") PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int updateByPrimaryKeySelective(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Tue Jan 05 10:30:45 CST 2021
     */
    int updateByPrimaryKey(PurchaseSupply record);
}