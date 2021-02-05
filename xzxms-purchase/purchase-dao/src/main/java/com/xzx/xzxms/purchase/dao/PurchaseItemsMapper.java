package com.xzx.xzxms.purchase.dao;

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseItemsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    long countByExample(PurchaseItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int deleteByExample(PurchaseItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int insert(PurchaseItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int insertSelective(PurchaseItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    List<PurchaseItems> selectByExample(PurchaseItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    PurchaseItems selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int updateByExampleSelective(@Param("record") PurchaseItems record, @Param("example") PurchaseItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int updateByExample(@Param("record") PurchaseItems record, @Param("example") PurchaseItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int updateByPrimaryKeySelective(PurchaseItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_items
     *
     * @mbg.generated Tue Jan 26 10:18:20 CST 2021
     */
    int updateByPrimaryKey(PurchaseItems record);
}