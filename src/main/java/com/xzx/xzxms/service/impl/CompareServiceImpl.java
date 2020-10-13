package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Compare;
import com.xzx.xzxms.dao.CompareMapper;
import com.xzx.xzxms.dao.extend.CompareExtendMapper;
import com.xzx.xzxms.service.ICompareService;
import com.xzx.xzxms.vm.CompareReqVM;
import com.xzx.xzxms.vm.InquiryCompareVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompareServiceImpl implements ICompareService {
    @Resource
    private CompareExtendMapper compareExtendMapper;
    @Resource
    private CompareMapper compareMapper;
    @Override
    public List<InquiryCompareVM> cascadeFindAll(int compareStatus, long proDetailId) {
        return compareExtendMapper.cascadeFindAll(compareStatus, proDetailId);
    }

    @Override
    public List<InquiryCompareVM> cascadeFindAllByParams(long proDetailId, String name) {
        List<InquiryCompareVM> inquiryWithBLOBs = compareExtendMapper.cascadeFindAllByParams(proDetailId, name);
        return inquiryWithBLOBs;
    }
    @Transactional
    @Override
    public void completeCompare(long[] compareId, long[] otherCompareId, List<Map> remarks) {

        Compare compare = new Compare();
        // 更新选中比价
        compare.setStatus(1); //1选用
        for(Map map :remarks){
            compare.setId((Long)map.get("id"));
            compare.setRemark(map.get("remark").toString());
            compareMapper.updateByPrimaryKeySelective(compare);
        }
        // 更新未选中比价
        compare = new Compare();
        compare.setStatus(2); //2未选用
        for (long id : otherCompareId) {
            compare.setId(id);
            System.out.println(id);
            compareMapper.updateByPrimaryKeySelective(compare);
        }
    }

    @Override
    public List<?> batchGetCompare(CompareReqVM compareReqVM) {
        long[] proDetailIds = compareReqVM.getProDetailIds();
        String[] names = compareReqVM.getNames();

        List<Map> result = new ArrayList<>();
        for(int i=0; i < names.length; i++){
            List<InquiryCompareVM> inquiryCompareVMS = compareExtendMapper.cascadeFindAllByParams(proDetailIds[i], names[i]);
            Map map = new HashMap();
            map.put("name", names[i]);
            map.put("inquiryCompareVMS",inquiryCompareVMS);
            result.add(map);
        }
        return result;
    }
}
