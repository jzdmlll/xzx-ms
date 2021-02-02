package com.xzx.xzxms.equipment.service.Impl;/**
 * @Author sunny
 * @Date 2021/2/1 17:03
 * @Version 1.0
 */

import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.equipment.bean.EquipmentInvoice;
import com.xzx.xzxms.equipment.dao.extend.InvoiceExtendMapper;
import com.xzx.xzxms.equipment.service.InvoiceService;
import com.xzx.xzxms.equipment.vo.InvoiceVO;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public void invoiceUpload(EquipmentInvoice equipmentInvoice, List<SysFile> files) {

        iFileUploadServiceImpl.fileUpload(equipmentInvoice.getId(), files, SysFileExtend.TYPE_INVOICE);
    }

    @Override
    public List<InvoiceVO> findInvoice(Long contractId) {

        List<InvoiceVO> list = invoiceExtendMapper.findInvoiceByContractId(contractId);
        return list;
    }
}
