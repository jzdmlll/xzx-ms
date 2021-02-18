package com.xzx.xzxms.equipment.service.Impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.equipment.bean.EquipmentFile;
import com.xzx.xzxms.equipment.dao.EquipmentFileMapper;
import com.xzx.xzxms.equipment.extend.EquipmentFileExtend;
import com.xzx.xzxms.equipment.service.EquipmentFileService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/7 15:41
 * @修改人：
 * @修改时间：2021/2/7 15:41
 * @修改描述：默认描述
 */
public class EquipmentFileServiceImpl implements EquipmentFileService {

    @Resource
    private JedisDao jedisDaoImpl;

    @Autowired
    private IFileUploadService fileUploadServiceImpl;

    @Resource
    private EquipmentFileMapper equipmentFileMapper;

    /**
     * 1-履约保证金
     */
    @Override
    public String insertPerformanceFileService(List<EquipmentFile> fileList) {

        List<EquipmentFile> equipmentFiles = FileService(fileList);
        for (EquipmentFile equipmentFile : equipmentFiles) {
            //文件信息插入到数据库
//            equipmentFile.setId(IDUtils.getId());
            equipmentFile.setType(EquipmentFileExtend.TYPE_PERFORMANCE);
//            equipmentFile.setOtherId(purchaseContract.getId());
            equipmentFile.setTime(new Date().getTime());
            equipmentFile.setIsActive(CommonConstant.EFFECTIVE);
//            equipmentFile.setOperator(purchaseContract.getOperator());
            equipmentFileMapper.insert(equipmentFile);
        }
        return null;
    }

    /**
     * 2-供货发票
     */
    @Override
    public String insertSupplierInvoiceFileService(List<EquipmentFile> fileList) {
        List<EquipmentFile> equipmentFiles = FileService(fileList);
        for (EquipmentFile equipmentFile : equipmentFiles) {
            //文件信息插入到数据库
//            equipmentFile.setId(IDUtils.getId());
            equipmentFile.setType(EquipmentFileExtend.TYPE_SUPPLIER_INVOICE);
//            equipmentFile.setOtherId(purchaseContract.getId());
            equipmentFile.setTime(new Date().getTime());
            equipmentFile.setIsActive(CommonConstant.EFFECTIVE);
//            equipmentFile.setOperator(purchaseContract.getOperator());
            equipmentFileMapper.insert(equipmentFile);
        }
        return null;
    }

    /**
     * 3-付款通知单
     */
    @Override
    public String insertPaymentNoticeFileService(List<EquipmentFile> fileList) {
        List<EquipmentFile> equipmentFiles = FileService(fileList);
        for (EquipmentFile equipmentFile : equipmentFiles) {
            //文件信息插入到数据库
//            equipmentFile.setId(IDUtils.getId());
            equipmentFile.setType(EquipmentFileExtend.TYPE_PAYMENT_NOTICE);
//            equipmentFile.setOtherId(purchaseContract.getId());
            equipmentFile.setTime(new Date().getTime());
            equipmentFile.setIsActive(CommonConstant.EFFECTIVE);
//            equipmentFile.setOperator(purchaseContract.getOperator());
            equipmentFileMapper.insert(equipmentFile);
        }
        return null;
    }

    /**
     * 4-实际付款
     */
    @Override
    public String insertActualPaymentFileService(List<EquipmentFile> fileList) {
        List<EquipmentFile> equipmentFiles = FileService(fileList);
        for (EquipmentFile equipmentFile : equipmentFiles) {
            //文件信息插入到数据库
//            equipmentFile.setId(IDUtils.getId());
            equipmentFile.setType(EquipmentFileExtend.TYPE_ACTUAL_PAYMENT);
//            equipmentFile.setOtherId(purchaseContract.getId());
            equipmentFile.setTime(new Date().getTime());
            equipmentFile.setIsActive(CommonConstant.EFFECTIVE);
//            equipmentFile.setOperator(purchaseContract.getOperator());
            equipmentFileMapper.insert(equipmentFile);
        }
        return null;
    }

    @Override
    public List<EquipmentFile> FileService(List<EquipmentFile> fileList) {
        // 遍历
        for (EquipmentFile equipmentFile : fileList) {
            // 文件上传 redis --> nginx
            if (equipmentFile.getOperator()==null || "".equals(equipmentFile.getOperator())) {
                if (jedisDaoImpl.exists(equipmentFile.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(equipmentFile.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    //清除redis该文件缓存
                    jedisDaoImpl.del(equipmentFile.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, equipmentFile.getName());
                    equipmentFile.setUrl(map.get("url").toString());
                }else {
                    throw new CustomerException("文件上传信息过期，请重新上传");
                }
            }else {
                // 新增 重新生成ID
                equipmentFile.setId(IDUtils.getId());
            }
        }
        return fileList;
    }
}
