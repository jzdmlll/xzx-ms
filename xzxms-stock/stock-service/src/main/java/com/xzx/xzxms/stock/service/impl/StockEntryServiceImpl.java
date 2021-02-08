package com.xzx.xzxms.stock.service.impl;/**
 * @Author sunny
 * @Date 2021/2/8 17:00
 * @Version 1.0
 */

import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.service.StockEntryService;
import com.xzx.xzxms.stock.vo.StockEntryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName StockEntryServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class StockEntryServiceImpl implements StockEntryService {

    @Override
    public List<StockEntryVO> findEntryByParams(String item) {

        return null;
    }

    @Override
    public void entry(List<StockEntry> stockEntries) {

    }
}
