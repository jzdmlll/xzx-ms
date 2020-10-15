package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Compare;
import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProCheckExample;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.CompareMapper;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.FinallyCheckExtendMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.service.IFinallyCheckCompareService;
import com.xzx.xzxms.vm.FinallyCheckCompareVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class FinallyCheckCompareServiceImpl implements IFinallyCheckCompareService {

    @Resource
    private FinallyCheckExtendMapper finallyCheckExtendMapper;
    @Resource
    private CompareMapper compareMapper;
    @Resource
    private SysProCheckMapper sysProCheckMapper;

    @Override
    public List<Map> FindDraftComparePrice(long proDetailId, String checkName) {

        String name = "";
        double minPrice = 0;

        List<Map> maps = new ArrayList<Map>();
        List<FinallyCheckCompareVM> finallyCheckCompareVMS = finallyCheckExtendMapper.cascadeFindAllByParams(proDetailId, checkName);
        Map map = new HashMap();

        for (int i = 0; i < finallyCheckCompareVMS.size(); i++) {

            if (finallyCheckCompareVMS.get(i).getName().equals(name)) {
                if (finallyCheckCompareVMS.get(i).getSuPrice() < minPrice) {
                    minPrice = finallyCheckCompareVMS.get(i).getSuPrice();
                    //将之前的那个询价最低价标志置为0
                    finallyCheckCompareVMS.get(i - 1).setMinPrice(0);
                    finallyCheckCompareVMS.get(i).setMinPrice(1);

                } else if (finallyCheckCompareVMS.get(i).getSuPrice() == minPrice) {
                    finallyCheckCompareVMS.get(i).setMinPrice(1);
                }
                map.put(finallyCheckCompareVMS.get(i).getSupplier(), finallyCheckCompareVMS.get(i));
            } else {
                if (!map.isEmpty()) {
                    maps.add(map);
                    map = new HashMap();
                }
                minPrice = finallyCheckCompareVMS.get(i).getSuPrice();
                finallyCheckCompareVMS.get(i).setMinPrice(1);
                name = finallyCheckCompareVMS.get(i).getName();
                map.put("inquiry", finallyCheckCompareVMS.get(i));
                Map _map = new HashMap();
                _map.put("price", finallyCheckCompareVMS.get(i).getSuPrice());
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

    @Transactional
    @Override
    public void saveFinallyCheckMessage(long[] checkCompareIds, long[] unCheckCompareIds, long[] allInquiryIds, long userId, long roleId) {

        Compare compare=new Compare();

        for (long checkId : checkCompareIds){
            compare.setId(checkId);
            compare.setStatus(3);
            compare.setOperator(userId);
            compareMapper.updateByPrimaryKeySelective(compare);
        }

        for (long unCheckId : unCheckCompareIds){
            compare.setId(unCheckId);
            compare.setStatus(2);
            compare.setOperator(userId);
            compareMapper.updateByPrimaryKeySelective(compare);
        }

        SysProCheck sysProCheck=new SysProCheck();
        for(long inquiryId : allInquiryIds){
            sysProCheck.setCheckStatus(1);
            sysProCheck.setOperator(userId);
            SysProCheckExample sysProCheckExample=new SysProCheckExample();
            sysProCheckExample.createCriteria().andContentIdEqualTo(inquiryId).andContentIdEqualTo(roleId);
            sysProCheckMapper.updateByExampleSelective(sysProCheck,sysProCheckExample);
        }

    }
}
