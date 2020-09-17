package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysPrivilege;
import com.xzx.xzxms.bean.SysPrivilegeExample;
import com.xzx.xzxms.bean.extend.SysPrivilegeExtend;
import com.xzx.xzxms.dao.SysPrivilegeMapper;
import com.xzx.xzxms.dao.extend.SysPrivilegeExtendMapper;
import com.xzx.xzxms.service.ISysPrivilegeService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.vm.PrivilegeTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysPrivilegeServiceImpl implements ISysPrivilegeService {
    @Resource
    private SysPrivilegeMapper sysPrivilegeMapper;
    @Resource
    private SysPrivilegeExtendMapper sysPrivilegeExtendMapper;
    @Override
    public List<SysPrivilege> findAll() {
        return sysPrivilegeMapper.selectByExample(new SysPrivilegeExample());
    }

    @Override
    public List<SysPrivilege> findByParentId(Long parentId) {
        SysPrivilegeExample example = new SysPrivilegeExample();
        if(parentId == null){
            example.createCriteria().andParentIdIsNull();
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }

        return sysPrivilegeMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(SysPrivilege privilege) throws CustomerException {
        if(privilege.getId()!=null){
            sysPrivilegeMapper.updateByPrimaryKeySelective(privilege);
        } else {
            sysPrivilegeMapper.insert(privilege);
        }
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        return sysPrivilegeExtendMapper.selectAll();
    }

    @Override
    public List<SysPrivilege> findByUserId(long id) {
        return sysPrivilegeExtendMapper.selectByUserId(id);
    }

    @Override
    public List<SysPrivilegeExtend> findMenuByUserId(long id) {
        return sysPrivilegeExtendMapper.selectMenuByUserId(id);
    }

    @Override
    public void deleteById(long id) {
        sysPrivilegeMapper.deleteByPrimaryKey(id);
    }
}
