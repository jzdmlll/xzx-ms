package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProCheckExample;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.QuoteMapper;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.service.ISysProCheckService;
import com.xzx.xzxms.utils.CustomerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProCheckServiceImpl implements ISysProCheckService {

    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private SysProCheckExtendMapper sysProCheckExtendMapper;
    @Resource
    private QuoteMapper quoteMapper;

    @Override
    public List<SysProCheckExtend> cascadeFindAllByCheckName(String checkName, int[] checkStatus, long proDetailId) {
        return sysProCheckExtendMapper.cascadeFindAllByCheckName(checkName, checkStatus, proDetailId);
    }


    @Transactional
    @Override
    public void UpdateCheckStatus(Integer status, long[] ids, long operator) {
        for (long id : ids){
            SysProCheck sysProCheck = sysProCheckMapper.selectByPrimaryKey(id);
            Quote quote = quoteMapper.selectByPrimaryKey(sysProCheck.getContentId());
            SysProCheckExample sysProCheckExample = new SysProCheckExample();
            sysProCheckExample.createCriteria().andTypeEqualTo("比价审核").andCheckStatusNotEqualTo(0);
            List<SysProCheck> sysProCheck1 = sysProCheckMapper.selectByExample(sysProCheckExample);
            if (sysProCheck1.size() > 0){
                throw new CustomerException("已有比价结果，请勿再修改审核状态!");
            }

            if(status == 0) {
                quote.setIsUseful(0);
            }else {
                quote.setIsUseful(1);
            }
            sysProCheck.setId(id);
            sysProCheck.setCheckStatus(status);
            sysProCheck.setOperator(operator);
            sysProCheck.setTime(new Date().getTime());
            sysProCheckMapper.updateByPrimaryKeySelective(sysProCheck);
            quoteMapper.updateByPrimaryKeySelective(quote);
        }
    }
}
