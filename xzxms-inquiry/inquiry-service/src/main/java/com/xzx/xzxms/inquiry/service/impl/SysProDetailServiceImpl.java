package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.*;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.inquiry.dao.SysProOriginMapper;
import com.xzx.xzxms.inquiry.dao.extend.SysProDetailExtendMapper;
import com.xzx.xzxms.inquiry.service.ISysProDetailService;
import com.xzx.xzxms.inquiry.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.SysFileExample;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import com.xzx.xzxms.system.dao.SysFileMapper;
import com.xzx.xzxms.system.service.IFileUploadService;
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
    @Autowired
    private JedisDao jedisDaoImpl;
    @Resource
    private IFileUploadService fileUploadServiceImpl;
    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private SysProOriginMapper sysProOriginMapper;

    @Override
    public List<SysProDetailExtend> findById() {
        return sysProDetailExtendMapper.findById();
    }
    @Transactional
    @Override
    public void saveOrUpdate(SysProDetailWithBLOBs proDetail, List<SysFile> files) {
        long time = new Date().getTime();
        String operatorId = proDetail.getOperator();
        if (proDetail.getId() != null){
            SysFileExample example = new SysFileExample();
            example.createCriteria().andOtherIdEqualTo(proDetail.getId());
            List<SysFile> sysFiles = sysFileMapper.selectByExample(example);
            for(SysFile file : sysFiles){
                file.setIsActive(0);
                sysFileMapper.updateByPrimaryKeySelective(file);
            }
            //文件上传
            for (SysFile file : files) {
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

                    //文件信息持久化到数据库
                    file.setType(SysFileExtend.TYPE_PRODETAIL);
                    file.setOtherId(proDetail.getId());
                    file.setTime(time);
                    file.setIsActive(1);
                    file.setIsUseful(1);
                    file.setOperator(operatorId);
                    sysFileMapper.insert(file);
                    System.out.println("数据库");
                }
            }
            proDetail.setProRate(proDetail.getProRate()*1000);
            sysProDetailMapper.updateByPrimaryKeySelective(proDetail);
           /* SysProDetailExample example2 = new SysProDetailExample();
            example2.createCriteria().andIdEqualTo(proDetail.getId());
            List<SysProDetail> sysProDetails = sysProDetailMapper.selectByExample(example2);
            for(SysProDetail sysProDetail:sysProDetails){
                sysProDetailMapper.updateByExample(example2);
            }*/
            /*int size = sysProCheckExtendMapper.findExistsCheck(proDetail.getId());
            if (size > 0){
                throw  new CustomerException("审核流程修改失败, 需将项目的所有报价单数据删除才可修改审核流程");
            }

            long proDetailId = proDetail.getId();
            sysProDetailMapper.updateByPrimaryKeySelective(proDetail);

            //审核流程插入前需判断是否存在，存在先删除后更新
            SysProDetailCheckExample example = new SysProDetailCheckExample();
            example.createCriteria().andProDetailIdEqualTo(proDetailId);
            List<SysProDetailCheck> sysProDetailCheck = sysProDetailCheckMapper.selectByExample(example);
            if (sysProDetailCheck.size() > 0){
                sysProDetailCheck.forEach((x)->{sysProDetailCheckMapper.deleteByPrimaryKey(x.getId());});
            }
            for(SysProDetailCheck check : proChecks) {
                check.setId(IDUtils.getId());
                check.setProDetailId(proDetailId);
                check.setTime(time);
                check.setCheckStatus(0);
                check.setOperator(operatorId);
                sysProDetailCheckMapper.insert(check);
            }*/

        }else {
            long proDetailId = IDUtils.getId();
            //文件上传
            for (SysFile file : files) {
                //如果redis中存在该文件
                if(jedisDaoImpl.exists(file.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(file.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    System.out.println("redis");
                    //清除redis该文件缓存
                    jedisDaoImpl.del(file.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());

                    //文件信息持久化到数据库
                    file.setType(SysFileExtend.TYPE_PRODETAIL);
                    file.setOtherId(proDetailId);
                    file.setTime(time);
                    file.setIsActive(1);
                    file.setIsUseful(1);
                    file.setOperator(operatorId);
                    sysFileMapper.insert(file);
                    System.out.println("数据库");
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
            proDetail.setProNo(temp.toString());
            proDetail.setTime(time);
            proDetail.setIsActive(1);
            proDetail.setIsUseful(0);
            sysProDetailMapper.insert(proDetail);
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
    public void setInvalid(long id) {
        SysProDetailWithBLOBs proDetail = new SysProDetailWithBLOBs();
        proDetail.setId(id);
        proDetail.setIsActive(0);
        sysProDetailMapper.updateByPrimaryKeySelective(proDetail);
    }

    @Override
    public List<SysProDetail> inquiryResultFindPro(String proName, Long startTime, Long overTime) {

        SysProOriginExample example = new SysProOriginExample();
        example.createCriteria().andNameEqualTo("招投标项目").andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<SysProOrigin> list = sysProOriginMapper.selectByExample(example);
        if (list.size() > 0){
            if(overTime == 0){
                overTime = new Date().getTime();
            }
            SysProDetailExample sysProDetailExample = new SysProDetailExample();
            sysProDetailExample.createCriteria().andIsActiveEqualTo(CommonConstant.EFFECTIVE).andNameLike("%"+proName+"%").andTimeBetween(startTime, overTime).andProOriginIdEqualTo(list.get(0).getId());
            List<SysProDetail> sysProDetails = sysProDetailMapper.selectByExample(sysProDetailExample);
            return sysProDetails;
        }
        return null;
    }

    @Override
    public SysProDetailExtend findById(long proDetailId) {
        return sysProDetailExtendMapper.findById(proDetailId);
    }

}
