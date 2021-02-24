package com.xzx.xzxms.tender.extend;

import com.xzx.xzxms.tender.bean.TenderFile;


/**
 * @author：ZJW
 * @title：
 * @date：2021/2/24 19:18
 * @修改人：
 * @修改时间：2021/2/24 19:18
 * @修改描述：默认描述
 */
public class TenderFileExtend extends TenderFile {
    /**
     * 周嘉玮
     * 1 - 招标公告文件
     */
    public static final int TYPE_BID_ANNOUNCEMENT = 1;

    /**
     * 周嘉玮
     * 2 - 报名函
     */
    public static final int TYPE_APPLICATION_LETTER = 2;

    /**
     * 周嘉玮
     * 3 - 招标文件
     */
    public static final int TYPE_BID = 3;

    /***
     * 周嘉玮
     * 4 - 硬件清单
     */
    public static final int TYPE_HARDWARE = 4;

    /**
     * 周嘉玮
     * 5 - 技术文件
     */
    public static final int TYPE_TECHNOLOGY = 5;

    /**
     * 周嘉玮
     * 6 - 投标文件
     */
    public static final int TYPE_TENDER = 6;

    /**
     * 周嘉玮
     * 7 - 归档文件
     */
    public static final int TYPE_ARCHIVE = 7;

    /**
     * 周嘉玮
     * 8 - 最终报价清单文件
     */
    public static final int TYPE_FINAL_QUOTATION = 8;

    /**
     * 周嘉玮
     * 9 - 中标通知书
     */
    public static final int TYPE_LETTER_OF_ACCEPTANCE = 9;
}
