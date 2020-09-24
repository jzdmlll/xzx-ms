package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Compare;
import com.xzx.xzxms.dao.CompareMapper;
import com.xzx.xzxms.dao.extend.CompareExtendMapper;
import com.xzx.xzxms.service.ICompareService;
import com.xzx.xzxms.vm.InquiryCompareVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    public void completeCompare(long compareId, long[] otherCompareId) {
        // 更新选中比价
        Compare compare = new Compare();
        compare.setId(compareId);
        compare.setStatus(1); //1选用
        compareMapper.updateByPrimaryKeySelective(compare);

        // 更新未选中比价
        compare.setStatus(2); //2未选用
        for (long id : otherCompareId) {
            compare.setId(id);
            System.out.println(id);
            compareMapper.updateByPrimaryKeySelective(compare);
        }
    }
}
