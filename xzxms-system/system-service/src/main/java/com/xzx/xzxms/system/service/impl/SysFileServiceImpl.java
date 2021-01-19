package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.SysFileExample;
import com.xzx.xzxms.system.dao.SysFileMapper;
import org.springframework.stereotype.Service;
import com.xzx.xzxms.system.service.ISysFileService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysFileServiceImpl implements ISysFileService {
    @Resource
    private SysFileMapper sysFileMapper;
    @Override
    public List<SysFile> findAll() {
        return null;
    }

    @Override
    public List<SysFile> findById(long fileId) {
        return null;
    }

    @Override
    public void saveOrUpdate(SysFile sysFile) {
        if (sysFile.getId() != null){
            sysFileMapper.updateByPrimaryKeySelective(sysFile);
        }else {
            sysFile.setId(IDUtils.getId());
            sysFileMapper.insert(sysFile);
        }
    }

    @Override
    public void setInvalid(long[] ids) {

    }

    @Override
    public void delete(long[] ids) {

    }

    @Override
    public List<SysFile> findByProId(Long proId) {

        SysFileExample example = new SysFileExample();
        //文件类型为0代表项目文件
        example.createCriteria().andOtherIdEqualTo(proId).andTypeEqualTo(0).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<SysFile> sysFiles = sysFileMapper.selectByExample(example);
        return sysFiles;
    }

    @Override
    public List<SysFile> findByOtherId(Long otherId, Integer type) {

        SysFileExample example = new SysFileExample();
        example.createCriteria().andOtherIdEqualTo(otherId).andTypeEqualTo(type).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<SysFile> sysFiles = sysFileMapper.selectByExample(example);
        return sysFiles;
    }
}
