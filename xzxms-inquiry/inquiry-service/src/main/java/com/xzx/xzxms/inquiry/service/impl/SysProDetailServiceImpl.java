package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.*;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.inquiry.dao.SysProOriginMapper;
import com.xzx.xzxms.inquiry.dao.extend.SysProDetailExtendMapper;
import com.xzx.xzxms.inquiry.service.ISysProDetailService;
import com.xzx.xzxms.inquiry.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.dao.PurchaseProjectMapper;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.SysFileExample;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import com.xzx.xzxms.system.dao.SysFileMapper;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SysProDetailServiceImpl implements ISysProDetailService {

    @Resource
    private SysProDetailExtendMapper sysProDetailExtendMapper;
    @Resource
    private SysProDetailMapper sysProDetailMapper;
    @Resource
    private JedisDao jedisDaoImpl;
    @Resource
    private IFileUploadService fileUploadServiceImpl;
    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private PurchaseProjectMapper purchaseProjectMapper;

    @Override
    public List<SysProDetailExtend> findById() {
        return sysProDetailExtendMapper.findById();
    }
    @Transactional
    @Override
    public void saveOrUpdate(SysProDetailWithBLOBs proDetail, List<SysFile> files, String loginId) {
        long time = new Date().getTime();
        String operatorId = proDetail.getOperator();
        if (proDetail.getId() != null){

            //修改前根据登录用户ID和项目创建ID判断是否有权限删除
            if (!loginId.equals(proDetail.getOperator())){
                throw new CustomerException("当前项目不是由您所创建,无修改权限!");
            }

            // 查询该项目是否有文件
            SysFileExample sysFileExample = new SysFileExample();
            sysFileExample.createCriteria().andOtherIdEqualTo(proDetail.getId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE)
                    .andTypeEqualTo(SysFileExtend.TYPE_PRODETAIL);
            Long fileNum = sysFileMapper.countByExample(sysFileExample);

            //采购项目文件也同时操作
            SysFileExample purFileExample = new SysFileExample();
            purFileExample.createCriteria().andOtherIdEqualTo(proDetail.getPurchaseProId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE)
                    .andTypeEqualTo(SysFileExtend.TYPE_PRODETAIL);
            Long purFileNum = sysFileMapper.countByExample(purFileExample);

            if (fileNum > 0) {
                // 修改
                // 覆盖之前文件
                SysFile newFile = new SysFile();
                newFile.setIsActive(CommonConstant.INVALID);
                newFile.setUpdateOperator(operatorId);
                newFile.setUpdateTime(time);
                sysFileMapper.updateByExampleSelective(newFile, sysFileExample);
            }

            if (purFileNum > 0){
                SysFile newFile = new SysFile();
                newFile.setIsActive(CommonConstant.INVALID);
                newFile.setUpdateOperator(operatorId);
                newFile.setUpdateTime(time);
                sysFileMapper.updateByExampleSelective(newFile, purFileExample);
            }

            // 修改
            // 文件上传
            for (SysFile file : files) {
                if (file.getOperator() == null || "".equals(file.getOperator())) {
                    //如果redis中存在该文件
                    if (jedisDaoImpl.exists(file.getId().toString())) {
                        //从redis中取出base64文件码
                        String base64File = jedisDaoImpl.get(file.getId().toString());
                        //解码，还原成输入流
                        InputStream inputStream = Base64Util.decodeBase64File(base64File);
                        System.out.println("redis");
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
                //文件信息持久化到数据库
                file.setType(SysFileExtend.TYPE_PRODETAIL);
                file.setOtherId(proDetail.getId());
                file.setTime(time);
                file.setIsActive(1);
                file.setIsUseful(1);
                file.setOperator(operatorId);
                sysFileMapper.insert(file);
                //插入采购项目文件
                file.setId(IDUtils.getId());
                file.setOtherId(proDetail.getPurchaseProId());
                sysFileMapper.insert(file);
            }
            //proDetail.setProRate(proDetail.getProRate()*1000);
            proDetail.setUpdateTime(new Date().getTime());
            sysProDetailMapper.updateByPrimaryKeySelective(proDetail);

            //采购项目表也更新
            PurchaseProject purchaseProject = new PurchaseProject();
            purchaseProject.setId(proDetail.getPurchaseProId());
            purchaseProject.setProjectName(proDetail.getName());
            purchaseProject.setRemark(proDetail.getRemark());
            purchaseProject.setUpdateOperator(proDetail.getUpdateOperator());
            purchaseProject.setUpdateTime(proDetail.getUpdateTime());
            purchaseProject.setProTypeId(proDetail.getProTypeId());
            purchaseProject.setProOriginId(proDetail.getProOriginId());
            purchaseProject.setProNo(proDetail.getProNo());
            purchaseProject.setProRate(proDetail.getProRate());
            purchaseProject.setContent(proDetail.getContent());
            purchaseProjectMapper.updateByPrimaryKeySelective(purchaseProject);

        }else {
            // 新增
            long proDetailId = IDUtils.getId();
            //采购项目ID
            long purchaseProId = IDUtils.getId();

            //文件上传
            for (SysFile file : files) {
                //如果redis中存在该文件
                if(jedisDaoImpl.exists(file.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(file.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    //清除redis该文件缓存
                    jedisDaoImpl.del(file.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());

                    //文件信息持久化到数据库
                    file.setType(SysFileExtend.TYPE_PRODETAIL);
                    file.setOtherId(proDetailId);
                    file.setTime(time);
                    file.setUrl(map.get("url").toString());
                    file.setIsActive(CommonConstant.EFFECTIVE);
                    file.setIsUseful(CommonConstant.IS_NOT_USEFUL);
                    file.setOperator(operatorId);
                    sysFileMapper.insert(file);
                    //询价项目文件插入 采购项目文件也要插入 2021/03/09 sunny
                    file.setId(IDUtils.getId());
                    file.setOtherId(purchaseProId);
                    sysFileMapper.insert(file);
                }
            }

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            String _month = String.valueOf(month);
            if (month < 10){
                _month = "0" + month;
            }
            StringBuffer currentTime = new StringBuffer();
            currentTime.append(year);
            currentTime.append(_month);
            //查询项目编号当前应为多少
            int current = sysProDetailExtendMapper.findCurrentExists(currentTime.toString());
            StringBuffer temp = new StringBuffer();
            temp.append(currentTime);
            temp.append("-");
            temp.append(current + 1);

            //项目信息插入数据库
            proDetail.setId(proDetailId);
            //与采购项目互绑
            proDetail.setPurchaseProId(purchaseProId);

            proDetail.setProNo(temp.toString());
            proDetail.setTime(time);
            proDetail.setIsActive(CommonConstant.EFFECTIVE);
            proDetail.setIsUseful(CommonConstant.IS_NOT_USEFUL);
            sysProDetailMapper.insert(proDetail);

            //同时采购项目也插入
            PurchaseProject purchaseProject = new PurchaseProject();
            purchaseProject.setId(purchaseProId);
            purchaseProject.setProjectName(proDetail.getName());
            purchaseProject.setIsActive(CommonConstant.EFFECTIVE);
            purchaseProject.setIsUseful(CommonConstant.IS_NOT_USEFUL);
            purchaseProject.setOperator(proDetail.getOperator());
            purchaseProject.setTime(time);
            purchaseProject.setInquiryProId(proDetailId);
            purchaseProject.setRemark(proDetail.getRemark());
            purchaseProject.setProTypeId(proDetail.getProTypeId());
            purchaseProject.setProOriginId(proDetail.getProOriginId());
            purchaseProject.setProNo(proDetail.getProNo());
            purchaseProject.setProRate(proDetail.getProRate());
            purchaseProject.setContent(proDetail.getContent());
            purchaseProjectMapper.insert(purchaseProject);
        }
    }

    @Override
    public boolean verifyExistence(String proName) {
        SysProDetailExample sysProDetailExample=new SysProDetailExample();
        sysProDetailExample.createCriteria().andNameEqualTo(proName).andIsActiveEqualTo(1);
        List<SysProDetail> sysProDetail = sysProDetailMapper.selectByExample(sysProDetailExample);
        if (sysProDetail.size() > 0){
            return true;
        }else {
            return false;
        }
    }

    //根据项目详情id查询利率
    @Override
    public SysProDetail findProRate(long proDetailId) {
        SysProDetail sysProDetail = sysProDetailMapper.selectByPrimaryKey(proDetailId);
        return sysProDetail;
    }

    //根据项目详情id修改更新利率
    @Override
    public void updateProRate(long proDetailId,int proRate) {
        SysProDetailWithBLOBs sysProDetail = new SysProDetailWithBLOBs();
        sysProDetail.setId(proDetailId);
        sysProDetail.setProRate(proRate);
        sysProDetailMapper.updateByPrimaryKeySelective(sysProDetail);

    }

    @Override
    public void setInvalid(Long id, String loginId) {

        SysProDetailExample example = new SysProDetailExample();
        example.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<SysProDetail> list = sysProDetailMapper.selectByExample(example);
        if (list == null){
            throw new CustomerException("此项目已失效,删除失败!");
        }else {
            SysProDetail sysProDetail = list.get(0);
            if (loginId.equals(sysProDetail.getOperator())){
                SysProDetailWithBLOBs proDetail = new SysProDetailWithBLOBs();
                proDetail.setId(id);
                proDetail.setIsActive(CommonConstant.INVALID);
                proDetail.setUpdateTime(new Date().getTime());
                proDetail.setUpdateOperator(loginId);
                sysProDetailMapper.updateByPrimaryKeySelective(proDetail);
            }else {
                throw new CustomerException("当前项目不是由您所创建,无删除权限!");
            }
        }
    }

    @Override
    public List<SysProDetail> inquiryResultFindPro(String proName, Long startTime, Long overTime) {

        if(overTime == 0){
            overTime = new Date().getTime();
        }
        SysProDetailExample sysProDetailExample = new SysProDetailExample();
        sysProDetailExample.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE).andNameLike("%"+proName+"%").andTimeBetween(startTime, overTime);
        List<SysProDetail> sysProDetails = sysProDetailMapper.selectByExample(sysProDetailExample);
        return sysProDetails;
    }

    @Override
    public SysProDetailExtend findById(long proDetailId) {
        return sysProDetailExtendMapper.findById(proDetailId);
    }

}
