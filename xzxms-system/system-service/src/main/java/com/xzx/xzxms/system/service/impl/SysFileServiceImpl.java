package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.system.bean.SysFile;
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
}
