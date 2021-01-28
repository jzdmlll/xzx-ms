package com.xzx.xzxms.inquiry.vo;/**
 * @Author sunny
 * @Date 2021/1/28 16:18
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;

import java.util.List;

/**
 *@ClassName InquiryAndQuote
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class InquiryAndQuoteVO extends Inquiry {

    List<Quote> quotes;

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
