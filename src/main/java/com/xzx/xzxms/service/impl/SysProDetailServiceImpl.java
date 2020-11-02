package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.*;
import com.xzx.xzxms.bean.extend.SysFileExtend;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.dao.SysFileMapper;
import com.xzx.xzxms.dao.SysProDetailCheckMapper;
import com.xzx.xzxms.dao.SysProDetailMapper;
import com.xzx.xzxms.dao.extend.SysProCheckExtendMapper;
import com.xzx.xzxms.dao.extend.SysProDetailExtendMapper;
import com.xzx.xzxms.dao.redis.JedisDao;
import com.xzx.xzxms.service.IFileUploadService;
import com.xzx.xzxms.service.ISysProDetailService;
import com.xzx.xzxms.utils.Base64Util;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import com.xzx.xzxms.service.ISysProCheckService;

@Service
public class SysProDetailServiceImpl implements ISysProDetailService {

    @Resource
    private SysProDetailExtendMapper sysProDetailExtendMapper;
    @Resource
    private SysProDetailMapper sysProDetailMapper;
    @Resource
    private SysProDetailCheckMapper sysProDetailCheckMapper;
    @Autowired
    private JedisDao jedisDaoImpl;
    @Resource
    private IFileUploadService fileUploadServiceImpl;
    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private SysProCheckExtendMapper sysProCheckExtendMapper;

    @Override
    public List<SysProDetailExtend> findById() { return sysProDetailExtendMapper.findById(); }
    @Transactional
    @Override
    public void saveOrUpdate(SysProDetailWithBLOBs proDetail, List<SysFile> files, List<SysProDetailCheck> proChecks) {
        long time = new Date().getTime();
        long operatorId = proDetail.getOperator();
        if (proDetail.getId() != null){

            //判断该项目是否存在审核，若存在审核则不能修改审核流程，必须将报价单的数据全部删除，则系统删除对应的项目审核
//            if (proChecks.size() >0 ){
//                throw new CustomerException("失败，项目已有审核");
//            }
            int size = sysProCheckExtendMapper.findExistsCheck(proDetail.getId());
            if (size > 0){
                throw  new CustomerException("审核流程修改失败, 需将项目的所有报价单数据删除才可修改审核流程");
            }

            long proDetailId = proDetail.getId();
            sysProDetailMapper.updateByPrimaryKeySelective(proDetail);

            for(SysProDetailCheck check : proChecks) {
                check.setId(IDUtils.getId());
                check.setProDetailId(proDetailId);
                check.setTime(time);
                check.setCheckStatus(0);
                check.setOperator(operatorId);
                sysProDetailCheckMapper.insert(check);
            }

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

                    System.out.println(map.get("url"));
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
            //项目信息插入数据库
            proDetail.setId(proDetailId);
            proDetail.setTime(time);
            proDetail.setIsActive(1);
            proDetail.setIsUseful(0);
            sysProDetailMapper.insert(proDetail);

            //审核信息插入数据库
            for (SysProDetailCheck proDetailCheck : proChecks) {
                proDetailCheck.setCheckStatus(0);
                proDetailCheck.setProDetailId(proDetailId);
                proDetailCheck.setTime(time);
                proDetailCheck.setId(IDUtils.getId());
                proDetailCheck.setOperator(operatorId);
                sysProDetailCheckMapper.insert(proDetailCheck);
            }
        }
    }

    @Override
    public boolean verifyExistence(String proName) {
        SysProDetailExample sysProDetailExample=new SysProDetailExample();
        sysProDetailExample.createCriteria().andNameEqualTo(proName);
        List<SysProDetail> sysProDetail = sysProDetailMapper.selectByExample(sysProDetailExample);
        if (sysProDetail.size() > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<SysProDetailCheck> findProDetailCheck(long proDetailId) {
        SysProDetailCheckExample example = new SysProDetailCheckExample();
        example.createCriteria().andProDetailIdEqualTo(proDetailId);
        return sysProDetailCheckMapper.selectByExample(example);
    }

    @Override
    public SysProDetailExtend findById(long proDetailId) {
        return sysProDetailExtendMapper.findById(proDetailId);
    }

}
