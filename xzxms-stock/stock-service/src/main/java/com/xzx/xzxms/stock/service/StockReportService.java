package com.xzx.xzxms.stock.service;

import com.xzx.xzxms.stock.vo.StockDetailVO;

import java.text.ParseException;
import java.util.List;

/**
 * @author：ZJW
 * @title：报表
 * @date：2021/2/25 20:37
 * @修改人：
 * @修改时间：2021/2/25 20:37
 * @修改描述：默认描述
 */
public interface StockReportService {
    /**
     * 周嘉玮
     * 存货暂估明细表
     */
    List<StockDetailVO> StockDetailService(Long date) throws Exception;

    // 获取开始日期
    Long beginTime(Long date) throws ParseException;

    // 获取结束日期
    Long endTime(Long date) throws ParseException;

}
