package com.xzx.xzxms.equipment.extend;

import com.xzx.xzxms.equipment.bean.EquipmentFile;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/7 11:34
 * @修改人：
 * @修改时间：2021/2/7 11:34
 * @修改描述：默认描述
 */
public class EquipmentFileExtend extends EquipmentFile {

    /**
     * 1-履约保证金
     */
    public static final int TYPE_PERFORMANCE = 1;

    /**
     * 2-供货发票
     */
    public static final int TYPE_SUPPLIER_INVOICE = 2;
    /**
     * 3-付款通知单
     */
    public static final int TYPE_PAYMENT_NOTICE = 3;
    /**
     * 4-实际付款
     */
    public static final int TYPE_ACTUAL_PAYMENT = 4;
}
