package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.dao.extend.FinallyCheckExtendMapper;
import com.xzx.xzxms.service.IFinallyCheckCompareService;
import com.xzx.xzxms.vm.FinallyCheckCompareVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class FinallyCheckCompareServiceImpl implements IFinallyCheckCompareService {

    @Resource
    private FinallyCheckExtendMapper finallyCheckExtendMapper;

    @Override
    public List<Map> FindDraftComparePrice(long proDetailId, int compareStatus) {

        String name = "";

        List<Map> maps = new ArrayList<Map>();
        List<FinallyCheckCompareVM> finallyCheckCompareVMS = finallyCheckExtendMapper.cascadeFindAllByParams(proDetailId, compareStatus);
        Map map = new HashMap();

        for (int i = 0; i < finallyCheckCompareVMS.size(); i++) {

            if (finallyCheckCompareVMS.get(i).getName().equals(name)) {
                map.put(finallyCheckCompareVMS.get(i).getSupplier(), finallyCheckCompareVMS.get(i));
            } else {
                if (!map.isEmpty()) {
                    maps.add(map);
                    map = new HashMap();
                }
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
}
