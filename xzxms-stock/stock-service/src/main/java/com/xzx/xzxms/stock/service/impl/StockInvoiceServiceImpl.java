package com.xzx.xzxms.stock.service.impl;/**
 * @Author sunny
 * @Date 2021/2/7 17:18
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.stock.bean.StockInvoice;
import com.xzx.xzxms.stock.bean.StockInvoiceExample;
import com.xzx.xzxms.stock.dao.StockInvoiceMapper;
import com.xzx.xzxms.stock.dao.extend.StockInvoiceExtendMapper;
import com.xzx.xzxms.stock.service.StockInvoiceService;
import com.xzx.xzxms.stock.vo.StockInvoiceVO;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class StockInvoiceServiceImpl implements StockInvoiceService {

    @Resource
    private IFileUploadService iFileUploadServiceImpl;
    @Resource
    private StockInvoiceMapper stockInvoiceMapper;
    @Resource
    private StockInvoiceExtendMapper stockInvoiceExtendMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void invoiceUpload(StockInvoice stockInvoice, List<SysFile> files) {

        //判断发票是否存在
        StockInvoiceExample example = new StockInvoiceExample();
        example.createCriteria().andContractIdEqualTo(stockInvoice.getContractId()).andNoEqualTo(stockInvoice.getNo()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        Long num = stockInvoiceMapper.countByExample(example);
        if (num != 0){
            throw new CustomerException("此发票已上传，请勿重复上传!");
        }
        //发票插入
        stockInvoice.setId(IDUtils.getId());
        stockInvoice.setIsActive(CommonConstant.EFFECTIVE);
        stockInvoice.setTime(new Date().getTime());
        stockInvoiceMapper.insert(stockInvoice);

        //文件上传
        iFileUploadServiceImpl.fileUpload(stockInvoice.getId(), files, SysFileExtend.TYPE_INVOICE, stockInvoice.getOperator());
    }

    @Override
    public List<StockInvoiceVO> findInvoice(Long contractId) {

        List<StockInvoiceVO> list = stockInvoiceExtendMapper.findInvoiceByContractId(contractId);
        return list;
    }
}
