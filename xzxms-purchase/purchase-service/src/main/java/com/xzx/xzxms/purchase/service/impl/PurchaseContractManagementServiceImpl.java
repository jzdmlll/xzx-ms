package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseContractExample;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractManagementExtendMapper;
import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import com.xzx.xzxms.purchase.vo.PurchaseContractGenerateNewVO;
import com.xzx.xzxms.purchase.vo.PurchaseContractGenerateVO;
import com.xzx.xzxms.purchase.vo.PurchaseContractVO;
import com.xzx.xzxms.purchase.vo.PurchaseProjectVO;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.system.bean.SysFileExample;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import com.xzx.xzxms.system.dao.SysFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/15 20:03
 * @修改人：
 * @修改时间：2020/12/15 20:03
 * @修改描述：默认描述
 */
@Service
@Repository
public class PurchaseContractManagementServiceImpl implements PurchaseContractManagementService {

    @Autowired
    PurchaseContractManagementExtendMapper purchaseContractManagementExtendMapper;

    @Resource
    PurchaseContractMapper purchaseContractMapper;

    @Resource
    private JedisDao jedisDaoImpl;

    @Autowired
    private IFileUploadService fileUploadServiceImpl;

    @Resource
    private SysFileMapper sysFileMapper;

    /**
     * 周嘉玮
     * 查找所有符合条件的项目
     * @param projectName
     * @return
     */
    @Override
    public List<PurchaseProjectVO> findAllProjectsService(String projectName) {
        List<PurchaseProjectVO> allProjects = purchaseContractManagementExtendMapper.findAllProjects(projectName);
        return allProjects;
    }

    /**
     * 周嘉玮
     * 根据项目id去查找其所有相关的合同信息
     * @param project_id
     * @return
     */
    @Override
    public List<PurchaseContractVO> findContractByProjectId(Long project_id) {
        List<PurchaseContractVO> contractList = purchaseContractManagementExtendMapper.findContractByProjectId(project_id);
        return contractList;
    }

    /**
     * 周嘉玮
     * 根据合同id修改合同审核级别 (送审)
     * @param purchaseContract
     * @return
     */
    @Override
    public String updateContractAuditByIdService(PurchaseContract purchaseContract) {

        PurchaseContractExample purchaseContractExample = new PurchaseContractExample();
        purchaseContractExample.createCriteria().andIdEqualTo(purchaseContract.getId());

        // 获取当前时间作为送审时间
        purchaseContract.setSendTime(new Date().getTime());

        purchaseContractMapper.updateByExampleSelective(purchaseContract, purchaseContractExample);
        return "success";
    }

    @Transactional
    @Override
    public void uploadContractFile(PurchaseContract purchaseContract, List<SysFile> fileList) {
        uploadPurchaseContractFile(purchaseContract, fileList);
    }

    @Transactional
    @Override
    public void purchaseContractEffective(PurchaseContract purchaseContract, List<SysFile> fileList) {

        //先将合同的状态改为正式有效状态
        purchaseContract.setContractStatus(CommonConstant.TAKE_EFFECT);
        purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        uploadPurchaseContractFile(purchaseContract, fileList);
    }

    @Override
    public List<PurchaseContractGenerateNewVO> findPurchaseMessageByContractId(Long contractId) {
        List<PurchaseContractGenerateNewVO> list = purchaseContractManagementExtendMapper.findPurchaseMessageByContractId(contractId);
        return list;
    }

    /**
     * sunny
     * 合同文件上传
     * @param purchaseContract
     * @param fileList
     */
    public void uploadPurchaseContractFile(PurchaseContract purchaseContract, List<SysFile> fileList){
        // 查询该合同下是否有文件
        SysFileExample sysFileExample = new SysFileExample();
        sysFileExample.createCriteria().andOtherIdEqualTo(purchaseContract.getId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE)
                .andTypeEqualTo(SysFileExtend.TYPE_PURCHASE_CONTRACT);
        Long fileNum = sysFileMapper.countByExample(sysFileExample);

        if (fileNum > 0) {
            // 修改
            // 覆盖之前文件
            SysFile newFile = new SysFile();
            newFile.setIsActive(CommonConstant.INVALID);
            sysFileMapper.updateByExampleSelective(newFile, sysFileExample);
        }

        Long time = new Date().getTime();
        // 遍历
        for (SysFile file : fileList) {

            // 文件上传 redis --> nginx
            if (file.getOperator()==null || "".equals(file.getOperator())) {
                if (jedisDaoImpl.exists(file.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(file.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    //清除redis该文件缓存
                    jedisDaoImpl.del(file.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());
                    file.setUrl(map.get("url").toString());
                }else {
                    throw new CustomerException("文件上传信息过期，请重新上传");
                }
            }else {
                // 新增 重新生成ID
                file.setId(IDUtils.getId());
            }
            //文件信息插入到数据库

            file.setType(SysFileExtend.TYPE_PURCHASE_CONTRACT);
            file.setOtherId(purchaseContract.getId());
            file.setTime(time);
            file.setIsActive(CommonConstant.EFFECTIVE);
            file.setIsUseful(CommonConstant.IS_NOT_USEFUL);
            file.setOperator(purchaseContract.getOperator());
            sysFileMapper.insert(file);
        }
    }

}
