package com.xzx.xzxms.dao;

import com.xzx.xzxms.bean.PurchaseSupply;
import com.xzx.xzxms.bean.PurchaseSupplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseSupplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    long countByExample(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int deleteByExample(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int insert(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int insertSelective(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    List<PurchaseSupply> selectByExampleWithBLOBs(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    List<PurchaseSupply> selectByExample(PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    PurchaseSupply selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") PurchaseSupply record, @Param("example") PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int updateByExampleWithBLOBs(@Param("record") PurchaseSupply record, @Param("example") PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int updateByExample(@Param("record") PurchaseSupply record, @Param("example") PurchaseSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int updateByPrimaryKeyWithBLOBs(PurchaseSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_supply
     *
     * @mbg.generated Fri Dec 11 15:30:54 GMT+08:00 2020
     */
    int updateByPrimaryKey(PurchaseSupply record);
}