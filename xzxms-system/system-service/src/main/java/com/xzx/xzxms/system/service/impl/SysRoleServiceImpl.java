package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.commons.model.base.service.BaseCommonService;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.SysRoleExample;
import com.xzx.xzxms.system.bean.SysRolePrivilege;
import com.xzx.xzxms.system.bean.SysRolePrivilegeExample;
import com.xzx.xzxms.system.bean.extend.SysRoleExtend;
import com.xzx.xzxms.system.dao.SysRoleMapper;
import com.xzx.xzxms.system.dao.SysRolePrivilegeMapper;
import com.xzx.xzxms.system.dao.extend.SysRoleExtendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xzx.xzxms.system.service.ISysRoleService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements ISysRoleService {
    @Resource
    private SysRoleMapper roleMapper;
    @Resource
    private SysRolePrivilegeMapper rolePrivilegeMapper;
    @Resource
    private SysRoleExtendMapper roleExtendMapper;
    @Autowired
    private BaseCommonService baseCommonService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void authorization(long roleId, List<Long> privilegeIds) {
        // 根据roleId查询出所有的权限
        SysRolePrivilegeExample example = new SysRolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<SysRolePrivilege> list = rolePrivilegeMapper.selectByExample(example);
        // 将list转换为privilegeIDs的集合
        List<Long> old_privilegeIds = new ArrayList<>();
        for(SysRolePrivilege rp : list){
            old_privilegeIds.add(rp.getPrivilegeId());
        }
        // 依次判断有没有需要添加的权限，如果有则添加
        for(long privilegeId : privilegeIds){
            if (!old_privilegeIds.contains(privilegeId)) {
                SysRolePrivilege rp = new SysRolePrivilege();
                rp.setRoleId(roleId);
                rp.setPrivilegeId(privilegeId);
                rolePrivilegeMapper.insert(rp);
            }
        }
        // 依次判断 有没有需要删除的权限，如果有则删除
        for(long privilegeId: old_privilegeIds){
            if(!privilegeIds.contains(privilegeId)){
                // 根据privilegeId 从桥表中删除
                example.clear();
                example.createCriteria()
                        .andRoleIdEqualTo(roleId)
                        .andPrivilegeIdEqualTo(privilegeId);
                rolePrivilegeMapper.deleteByExample(example);
            }
        }
        baseCommonService.removePrivilegeRedis();
    }

    @Override
    public List<SysRole> findAll() {
        return roleMapper.selectByExample(new SysRoleExample());
    }

    @Override
    public List<SysRoleExtend> cascadePrivilegeFindAll() {
        return roleExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(SysRole role) throws CustomerException {
        if(role.getId()!=null){
            roleMapper.updateByPrimaryKeySelective(role);
        } else {
            roleMapper.insert(role);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        SysRole role = roleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new CustomerException("要删除的角色不存在");
        }
        roleMapper.deleteByPrimaryKey(id);
        baseCommonService.removePrivilegeRedis();
    }

    @Override
    public List<SysRole> selectAllHasCheckName() {
        return roleExtendMapper.selectAllHasCheckName();
    }
}
