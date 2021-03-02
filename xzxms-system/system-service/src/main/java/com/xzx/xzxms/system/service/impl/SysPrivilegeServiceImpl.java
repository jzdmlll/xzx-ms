package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.commons.model.base.service.BaseCommonService;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.system.bean.SysPrivilege;
import com.xzx.xzxms.system.bean.SysPrivilegeExample;
import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.SysRoleExample;
import com.xzx.xzxms.system.bean.extend.SysPrivilegeExtend;
import com.xzx.xzxms.system.dao.SysPrivilegeMapper;
import com.xzx.xzxms.system.dao.SysRoleMapper;
import com.xzx.xzxms.system.dao.extend.SysPrivilegeExtendMapper;
import com.xzx.xzxms.system.vm.PrivilegeTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xzx.xzxms.system.service.ISysPrivilegeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysPrivilegeServiceImpl implements ISysPrivilegeService {
    @Resource
    private SysPrivilegeMapper sysPrivilegeMapper;
    @Resource
    private SysPrivilegeExtendMapper sysPrivilegeExtendMapper;
    @Autowired
    private BaseCommonService baseCommonService;
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
            sysPrivilegeMapper.updateByPrimaryKey(privilege);
        } else {
            sysPrivilegeMapper.insert(privilege);
        }
        baseCommonService.removePrivilegeRedis();
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
        baseCommonService.removePrivilegeRedis();
    }
}
