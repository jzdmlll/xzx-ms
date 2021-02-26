package com.xzx.xzxms.stock.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import com.xzx.xzxms.purchase.bean.PurchaseSupplyExample;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseSupplyMapper;
import com.xzx.xzxms.stock.bean.*;
import com.xzx.xzxms.stock.dao.StockDeliveryMapper;
import com.xzx.xzxms.stock.dao.StockEntryMapper;
import com.xzx.xzxms.stock.dao.StockMapper;
import com.xzx.xzxms.stock.service.StockReportService;
import com.xzx.xzxms.stock.vo.StockDetailVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/25 20:39
 * @修改人：
 * @修改时间：2021/2/25 20:39
 * @修改描述：默认描述
 */
@Service
public class StockReportServiceImpl implements StockReportService {

    @Resource
    StockMapper stockMapper;

    @Resource
    PurchaseItemsMapper purchaseItemsMapper;

    @Resource
    PurchaseSupplyMapper purchaseSupplyMapper;

    @Resource
    StockEntryMapper stockEntryMapper;

    @Resource
    StockDeliveryMapper stockDeliveryMapper;

    /**
     * 周嘉玮
     * 存货暂估明细表
     */
    @Transactional
    @Override
    public List<StockDetailVO> StockDetailService(Long date) throws Exception {

        List<StockDetailVO> StockDetailList = new ArrayList<>();

        // 开始日期
        Long beginDate = beginTime(date);
        // 结束日期
        Long endDate = endTime(date);

        // 获取所有库存
        StockExample stockExample = new StockExample();
        stockExample.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<Stock> stocks = stockMapper.selectByExample(stockExample);
        if (stocks.size() > 0){
            for (Stock stock : stocks) {
                // 品名
                String itemName = null;
                // 规格型号
                String specification = null;
                // 计量单位
                String unit = null;
                // 单价
                Double price = 0.0;
                // 现库存数量
                Double stockNumber = 0.0;
                // 本月入库数量
                Double entryNum = 0.0;
                // 本月出库数量
                Double deliveryNum = 0.0;
                // 上月库存数量
                Double lastMonthNum = 0.0;

                Long itemId = stock.getItemId();
                stockNumber = stock.getStockNumber(); //现库存
                // 根据item_id获取设备信息
                PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
                purchaseItemsExample.createCriteria().andIdEqualTo(itemId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
                List<PurchaseItems> purchaseItems = purchaseItemsMapper.selectByExample(purchaseItemsExample);
                if (purchaseItems.size() > 0){
                    PurchaseItems purchaseItem = purchaseItems.get(0);
                    itemName = purchaseItem.getItem();
                    String brand = purchaseItem.getBrand();
                    String params = purchaseItem.getParams();
                    String model = purchaseItem.getModel();
                    String tagNumber = purchaseItem.getTagNumer();
                    String meter = purchaseItem.getMeter();
                    String measuringRange = purchaseItem.getMeasuringRange();
                    String meterSignal = purchaseItem.getMeterSignal();
                    String connectionMode = purchaseItem.getConnectionMode();
                    String tube = purchaseItem.getTube();
                    List<String> str = new ArrayList<>();
                    specification = brand +","+ params +","+model+","+tagNumber+","+meter+","+measuringRange
                            +","+meterSignal+","+connectionMode+","+tube;
                    for (String sp : specification.split(",")) {
                        if (!sp.equals("null") && !sp.equals(" ")){
                            System.out.println(sp);
                            str.add(sp);
                        }
                    }
                    System.out.println(str);
                    specification = str.get(0);
                    for (int i=1; i<str.size(); i++){
                        specification = specification+","+str.get(i);
                    }
                    System.out.println(specification);

                    // 计量单位
                    unit = purchaseItem.getUnit();
                    // 单价
                    PurchaseSupplyExample purchaseSupplyExample = new PurchaseSupplyExample();
                    purchaseSupplyExample.createCriteria().andItemIdEqualTo(itemId).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
                    List<PurchaseSupply> purchaseSupplies = purchaseSupplyMapper.selectByExample(purchaseSupplyExample);
                    if (purchaseSupplies.size() > 0){
                        PurchaseSupply purchaseSupply = purchaseSupplies.get(0);
                        price = purchaseSupply.getPrice(); // 单价

                        // 获取入库记录
                        StockEntryExample stockEntryExample = new StockEntryExample();
                        // 根据itemId和起止时间查询其入库记录
                        stockEntryExample.createCriteria().andPurchaseItemIdEqualTo(itemId).andIsActiveEqualTo(CommonConstant.EFFECTIVE).andEntryTimeBetween(beginDate, endDate);
                        // 累加这个月的入库数量
                        List<StockEntry> stockEntries = stockEntryMapper.selectByExample(stockEntryExample);
                        if (stockEntries.size() > 0){
                            for (StockEntry stockEntry : stockEntries) {
                                entryNum = entryNum + stockEntry.getEntryNumber();
                            }
                        }

                        // 获取出库记录
                        StockDeliveryExample stockDeliveryExample = new StockDeliveryExample();
                        stockDeliveryExample.createCriteria().andItemIdEqualTo(itemId).andIsActiveEqualTo(CommonConstant.EFFECTIVE).andDeliveryTimeBetween(beginDate, endDate);
                        List<StockDelivery> stockDeliveries = stockDeliveryMapper.selectByExample(stockDeliveryExample);
                        if (stockDeliveries.size() > 0){
                            // 累加本月出库数量
                            for (StockDelivery stockDelivery : stockDeliveries) {
                                deliveryNum = deliveryNum + stockDelivery.getDeliveryNumber();
                            }
                        }

                    }
                }
                // 上月库存数量 = 本月库存数量 - 本月入库数量 + 本月出库数量
                lastMonthNum = stockNumber - entryNum + deliveryNum;
                if (lastMonthNum < 0){
                    throw new Exception(itemName +"("+ specification +")"+ "在数据库中库存数量存在异常，请核对库存数量以及出入库记录！");
                }

                StockDetailVO stockDetailVO = new StockDetailVO();
                stockDetailVO.setItemName(itemName);
                stockDetailVO.setSpecification(specification);
                stockDetailVO.setUnit(unit);
                stockDetailVO.setPrice(price);
                stockDetailVO.setLastNum(lastMonthNum);
                stockDetailVO.setLasePrice(lastMonthNum * price);
                stockDetailVO.setAddNum(entryNum);
                stockDetailVO.setAddPrice(entryNum * price);
                stockDetailVO.setReduceNum(deliveryNum);
                stockDetailVO.setReducePrice(deliveryNum * price);
                stockDetailVO.setNumber(stockNumber);
                stockDetailVO.setTotalPrice(stockNumber * price);

                StockDetailList.add(stockDetailVO);
            }
        }
        return StockDetailList;
    }

    // 开始日期
    @Override
    public Long beginTime(Long date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        // 根据当前时间获取本月的第一天
        String beginDate = time.split("-")[0] + "-" + time.split("-")[1] + "-01 00:00:00";
        Long beginDateTT = simpleDateFormat.parse(beginDate).getTime();

        return beginDateTT;
    }

    // 结束日期
    @Override
    public Long endTime(Long date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        // 根据当前时间获取下个月的第一天
        Long endDateTT = 0L;
        String s = time.split("-")[1];
        int a = Integer.parseInt(s);
        if (a == 12){
            int nextMonth = 1;
            int nextYear = Integer.parseInt(time.split("-")[0]) + 1;
            String endDate = nextYear + "-0" + nextMonth + "-01 00:00:00";
            endDateTT = simpleDateFormat.parse(endDate).getTime();
        }

        if (a >= 1 && a < 9){
            int nextMonth = a+1;
            String endDate = time.split("-")[0] + "-0" + nextMonth + "-01 00:00:00";
            endDateTT = simpleDateFormat.parse(endDate).getTime();
        }

        if (a >= 9 && a < 12){
            int nextMonth = a+1;
            String endDate = time.split("-")[0] + "-" + nextMonth + "-01 00:00:00";
            endDateTT = simpleDateFormat.parse(endDate).getTime();
        }
        return endDateTT;
    }
}
