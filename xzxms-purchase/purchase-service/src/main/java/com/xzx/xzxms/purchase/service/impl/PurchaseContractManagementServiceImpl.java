package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.FileConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseContractExample;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractManagementExtendMapper;
import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import com.xzx.xzxms.purchase.vo.PurchaseContractVO;
import com.xzx.xzxms.purchase.vo.PurchaseProjectVO;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
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
        // 获取当前时间 时间戳
        Long time = new Date().getTime();
        // 获取操作人 ID
        String operatorId = purchaseContract.getOperator();
        // 遍历 文件上传 redis --> nginx
        for (SysFile file : fileList) {
            // 如果redis中存在文件
            if (jedisDaoImpl.exists(file.getId().toString())) {
                //从redis中取出base64文件码
                String base64File = jedisDaoImpl.get(file.getId().toString());
                //解码，还原成输入流
                InputStream inputStream = Base64Util.decodeBase64File(base64File);
                //清除redis该文件缓存
                jedisDaoImpl.del(file.getId().toString());
                //上传到Nginx
                Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());

                //文件信息插入到数据库
                file.setType(FileConstant.FILE_PURCHASE_CONTRACT);
                file.setOtherId(purchaseContract.getId());
                file.setTime(time);
                file.setUrl(map.get("url").toString());
                file.setIsActive(1);
                file.setIsUseful(1);
                file.setOperator(operatorId);
                sysFileMapper.insert(file);
            }else {
                throw new CustomerException("文件上传信息过期，请重新上传");
            }
        }

    }
}
