package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.*;
import com.xzx.xzxms.bean.extend.SysFileExtend;
import com.xzx.xzxms.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.dao.SysFileMapper;
import com.xzx.xzxms.dao.SysProDetailCheckMapper;
import com.xzx.xzxms.dao.SysProDetailMapper;
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

    @Override
    public List<SysProDetailExtend> findById() { return sysProDetailExtendMapper.findById(); }

    @Transactional
    @Override
    public void saveOrUpdate(SysProDetailWithBLOBs proDetail, List<SysFile> files, List<SysProDetailCheck> proChecks) throws CustomerException {
        long time = new Date().getTime();
        long operatorId = proDetail.getOperator();

        /**
         * 项目详情ID不存在则说明该项目第一次导入；若ID存在，则需要将之前的信息删除再重新插入
         */
        if (proDetail.getId() != null){
            long proDetailId = proDetail.getId();
            SysProDetailWithBLOBs sysProDetailWithBLOBs;
            sysProDetailWithBLOBs=sysProDetailMapper.selectByPrimaryKey(proDetailId);
            //如果getIsUseful标志为0代表未使用过，则数据可删除修改，反之不能
            if (sysProDetailWithBLOBs !=null && sysProDetailWithBLOBs.getIsUseful().equals(0)){

                //先通过ID删除项目详情内容,同时删除审核表中相关数据
                sysProDetailMapper.deleteByPrimaryKey(proDetailId);
                sysProDetailCheckMapper.deleteByPrimaryKey(proDetailId);
            }else {
                throw new CustomerException("此项目已有后续操作，不能再更改项目信息!");
            }
        }

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


    @Override
    public SysProDetailExtend findById(long proDetailId) {
        return sysProDetailExtendMapper.findById(proDetailId);
    }
}
