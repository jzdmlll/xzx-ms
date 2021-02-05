package com.xzx.xzxms.equipment.service.Impl;/**
 * @Author sunny
 * @Date 2021/2/1 17:03
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.equipment.bean.EquipmentInvoice;
import com.xzx.xzxms.equipment.bean.EquipmentInvoiceExample;
import com.xzx.xzxms.equipment.dao.EquipmentInvoiceMapper;
import com.xzx.xzxms.equipment.dao.extend.InvoiceExtendMapper;
import com.xzx.xzxms.equipment.service.InvoiceService;
import com.xzx.xzxms.equipment.vo.InvoiceVO;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName InvoiceServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Resource
    private IFileUploadService iFileUploadServiceImpl;
    @Resource
    private InvoiceExtendMapper invoiceExtendMapper;
    @Resource
    private EquipmentInvoiceMapper equipmentInvoiceMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void invoiceUpload(EquipmentInvoice equipmentInvoice, List<SysFile> files) {

        //判断发票是否存在
        EquipmentInvoiceExample example = new EquipmentInvoiceExample();
        example.createCriteria().andContractIdEqualTo(equipmentInvoice.getContractId()).andNoEqualTo(equipmentInvoice.getNo()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        Long num = equipmentInvoiceMapper.countByExample(example);
        if (num != 0){
            throw new CustomerException("此发票已上传，请勿重复上传!");
        }
        //发票插入
        equipmentInvoice.setId(IDUtils.getId());
        equipmentInvoice.setIsActive(CommonConstant.EFFECTIVE);
        equipmentInvoice.setTime(new Date().getTime());
        equipmentInvoiceMapper.insert(equipmentInvoice);

        //文件上传
        iFileUploadServiceImpl.fileUpload(equipmentInvoice.getId(), files, SysFileExtend.TYPE_INVOICE);
    }

    @Override
    public List<InvoiceVO> findInvoice(Long contractId) {

        List<InvoiceVO> list = invoiceExtendMapper.findInvoiceByContractId(contractId);
        return list;
    }
}
