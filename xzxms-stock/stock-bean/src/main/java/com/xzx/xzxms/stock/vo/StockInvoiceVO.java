package com.xzx.xzxms.stock.vo;/**
 * @Author sunny
 * @Date 2021/2/7 17:17
 * @Version 1.0
 */

import com.xzx.xzxms.stock.bean.StockInvoice;

/**
 *@ClassName StockInvoice
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class StockInvoiceVO extends StockInvoice {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
