package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.FinallyCheckExtendMapper;
import com.xzx.xzxms.service.IFinallyCheckService;
import com.xzx.xzxms.vm.FinallyCheckCompareVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class FinallyCheckServiceImpl implements IFinallyCheckService {
    @Resource
    private FinallyCheckExtendMapper finallyCheckExtendMapper;

    @Override
    public List<Map> cascadeFindAllByParams(long proDetailId) {

        String name = "";
        double minPrice = 0;
        double price = 0;
        List<Map> maps = new ArrayList<Map>();
        List<FinallyCheckCompareVM> finallyCheckCompareVMS = finallyCheckExtendMapper.cascadeFindAllByParams(proDetailId);

        Map map = new HashMap();

        for (int i = 0; i < finallyCheckCompareVMS.size(); i++) {
            if (finallyCheckCompareVMS.get(i).getSuPrice() != null){
                price = finallyCheckCompareVMS.get(i).getSuPrice();
            }
            String inquiryName = finallyCheckCompareVMS.get(i).getName();
            if (name.equals(finallyCheckCompareVMS.get(i).getName())) {
                if (price < minPrice) {
                    minPrice = price;
                    //将之前的那个询价最低价标志置为0
                    finallyCheckCompareVMS.get(i - 1).setMinPrice(0);
                    finallyCheckCompareVMS.get(i).setMinPrice(1);

                } else if (price == minPrice) {
                    finallyCheckCompareVMS.get(i).setMinPrice(1);
                }
                map.put(finallyCheckCompareVMS.get(i).getSupplier(), finallyCheckCompareVMS.get(i));
            } else {
                if (!map.isEmpty()) {
                    maps.add(map);
                    map = new HashMap();
                }
                minPrice = price;
                finallyCheckCompareVMS.get(i).setMinPrice(1);
                name = finallyCheckCompareVMS.get(i).getName();
                map.put("inquiry", finallyCheckCompareVMS.get(i));
                Map _map = new HashMap();
                _map.put("price", price);
                _map.put("totalPrice", finallyCheckCompareVMS.get(i).getSuTotalPrice());
                map.put("draft", _map);
                map.put(finallyCheckCompareVMS.get(i).getSupplier(), finallyCheckCompareVMS.get(i));
            }
            if (i == finallyCheckCompareVMS.size() - 1) {
                maps.add(map);
            }
        }

        return maps;
    }

    @Resource
    private SysProCheckMapper sysProCheckMapper;

    @Transactional
    @Override
    public void FinallyCheckCommit(long[] checkIds, long[] unCheckIds, List<Map> remarks, long userId) {

        long time = new Date().getTime();

        SysProCheck proCheck = new SysProCheck();
        // 更新选中比价
        proCheck.setCheckStatus(SysProCheckExtend.PASS_STATUS); //1选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : checkIds) {
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
        // 更新备注
        proCheck = new SysProCheck();
        proCheck.setOperator(userId);
        for(Map map :remarks){
            proCheck.setId(Long.parseLong(map.get("id").toString()));
            proCheck.setRemark(map.get("remark").toString());
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }
        // 更新未选中比价
        proCheck = new SysProCheck();
        proCheck.setCheckStatus(SysProCheckExtend.REFUSE_STATUS); //2未选用
        proCheck.setOperator(userId);
        proCheck.setTime(time);
        for (long id : unCheckIds) {
            proCheck.setId(id);
            sysProCheckMapper.updateByPrimaryKeySelective(proCheck);
        }


    }
}