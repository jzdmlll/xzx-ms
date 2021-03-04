package com.xzx.xzxms.inquiry.service.impl;/**
 * @Author sunny
 * @Date 2021/2/19 14:33
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.inquiry.dao.extend.ProProcessExtendMapper;
import com.xzx.xzxms.inquiry.service.IIndexService;
import com.xzx.xzxms.inquiry.vo.ProProcessVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName IndexServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class IndexServiceImpl implements IIndexService {

    @Resource
    private InquiryMapper inquiryMapper;
    @Resource
    private SysProDetailMapper sysProDetailMapper;
    @Resource
    private ProProcessExtendMapper proProcessExtendMapper;


    @Override
    public List<ProProcessVO> findProProcess(Long proId) {

        List<ProProcessVO> list = proProcessExtendMapper.findProProcessByProId(proId);
        return list;
    }
}
