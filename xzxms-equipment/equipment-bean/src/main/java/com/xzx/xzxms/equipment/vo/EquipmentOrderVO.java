package com.xzx.xzxms.equipment.vo;

/**
 * @author：ZJW
 * @title：用于点击查看订单跟踪详情
 * @date：2021/1/26 15:37
 * @修改人：
 * @修改时间：2021/1/26 15:37
 * @修改描述：默认描述
 */
public class EquipmentOrderVO {
    private Long id;
    private String payType;
    private Double needPay;
    private String unitMoney;
    private String currency;
    private Long schedulerPayTime;
    private Long schedulerDeliveryTime;
    private Double schedulerArrivalNum; //预定到货数量
    private String unitItem;
    private Double notSignNum; // 未签收数量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Double getNeedPay() {
        return needPay;
    }

    public void setNeedPay(Double needPay) {
        this.needPay = needPay;
    }

    public String getUnitMoney() {
        return unitMoney;
    }

    public void setUnitMoney(String unitMoney) {
        this.unitMoney = unitMoney;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getSchedulerPayTime() {
        return schedulerPayTime;
    }

    public void setSchedulerPayTime(Long schedulerPayTime) {
        this.schedulerPayTime = schedulerPayTime;
    }

    public Long getSchedulerDeliveryTime() {
        return schedulerDeliveryTime;
    }

    public void setSchedulerDeliveryTime(Long schedulerDeliveryTime) {
        this.schedulerDeliveryTime = schedulerDeliveryTime;
    }

    public Double getSchedulerArrivalNum() {
        return schedulerArrivalNum;
    }

    public void setSchedulerArrivalNum(Double schedulerArrivalNum) {
        this.schedulerArrivalNum = schedulerArrivalNum;
    }

    public String getUnitItem() {
        return unitItem;
    }

    public void setUnitItem(String unitItem) {
        this.unitItem = unitItem;
    }

    public Double getNotSignNum() {
        return notSignNum;
    }

    public void setNotSignNum(Double notSignNum) {
        this.notSignNum = notSignNum;
    }

    @Override
    public String toString() {
        return "EquipmentOrderVO{" +
                "id=" + id +
                ", payType='" + payType + '\'' +
                ", needPay=" + needPay +
                ", unitMoney='" + unitMoney + '\'' +
                ", currency='" + currency + '\'' +
                ", schedulerPayTime=" + schedulerPayTime +
                ", schedulerDeliveryTime=" + schedulerDeliveryTime +
                ", schedulerArrivalNum=" + schedulerArrivalNum +
                ", unitItem='" + unitItem + '\'' +
                ", notSignNum=" + notSignNum +
                '}';
    }
}
