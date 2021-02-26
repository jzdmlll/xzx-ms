package com.xzx.xzxms.stock.service.impl;/**
 * @Author sunny
 * @Date 2021/2/7 17:18
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.stock.bean.StockInvoice;
import com.xzx.xzxms.stock.bean.StockInvoiceExample;
import com.xzx.xzxms.stock.dao.StockInvoiceMapper;
import com.xzx.xzxms.stock.dao.extend.StockInvoiceExtendMapper;
import com.xzx.xzxms.stock.service.StockInvoiceService;
import com.xzx.xzxms.stock.vo.StockInvoiceVO;
import com.xzx.xzxms.system.bean.SysFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StockInvoiceServiceImpl implements StockInvoiceService {

    @Resource
    private IFileUploadService iFileUploadServiceImpl;
    @Resource
    private StockInvoiceMapper stockInvoiceMapper;
    @Resource
    private StockInvoiceExtendMapper stockInvoiceExtendMapper;
    @Resource
    private JedisDao jedisDaoImpl;

    @Transactional
    @Override
    public void invoiceUpload(StockInvoice stockInvoice, List<SysFile> files) {

        //判断发票是否存在
        StockInvoiceExample example = new StockInvoiceExample();
        example.createCriteria().andContractIdEqualTo(stockInvoice.getContractId()).andNoEqualTo(stockInvoice.getNo()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        Long num = stockInvoiceMapper.countByExample(example);
        if (num != 0){
            throw new CustomerException("此发票已上传，请勿重复上传!");
        }

        //文件上传
        if (files!=null && files.size()>0 && jedisDaoImpl.exists(files.get(0).getId().toString())) {
            //从redis中取出base64文件码
            String base64File = jedisDaoImpl.get(files.get(0).getId().toString());
            //解码，还原成输入流
            InputStream inputStream = Base64Util.decodeBase64File(base64File);
            //清除redis该文件缓存
            jedisDaoImpl.del(files.get(0).getId().toString());
            //上传到Nginx
            Map<String, Object> map = iFileUploadServiceImpl.uploadByStream(inputStream, files.get(0).getName());
            stockInvoice.setImage(map.get("url").toString());
        } else {
            throw new CustomerException("文件上传信息过期，请重新上传");
        }
        //发票插入
        stockInvoice.setId(IDUtils.getId());
        stockInvoice.setIsActive(CommonConstant.EFFECTIVE);
        stockInvoice.setTime(new Date().getTime());
        stockInvoiceMapper.insert(stockInvoice);
    }

    @Override
    public List<StockInvoiceVO> findInvoice(Long contractId) {

        List<StockInvoiceVO> list = stockInvoiceExtendMapper.findInvoiceByContractId(contractId);
        return list;
    }
}
