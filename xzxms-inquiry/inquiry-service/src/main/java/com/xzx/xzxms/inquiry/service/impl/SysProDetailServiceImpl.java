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
            // 查询该项目是否有文件
            SysFileExample sysFileExample = new SysFileExample();
            sysFileExample.createCriteria().andOtherIdEqualTo(proDetail.getId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE)
                    .andTypeEqualTo(SysFileExtend.TYPE_PRODETAIL);
            Long fileNum = sysFileMapper.countByExample(sysFileExample);
            if (fileNum > 0) {
                // 修改
                // 覆盖之前文件
                SysFile newFile = new SysFile();
                newFile.setIsActive(CommonConstant.INVALID);
                sysFileMapper.updateByExampleSelective(newFile, sysFileExample);
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
            }
            proDetail.setProRate(proDetail.getProRate()*1000);
            sysProDetailMapper.updateByPrimaryKeySelective(proDetail);

        }else {
            // 新增
            long proDetailId = IDUtils.getId();
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
                    file.setIsActive(1);
                    file.setIsUseful(1);
                    file.setOperator(operatorId);
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
