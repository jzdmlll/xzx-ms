package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.dao.redis.impl.JedisDaoImpl;
import com.xzx.xzxms.commons.model.base.service.BaseCommonService;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.JsonUtils;
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
    @Resource
    private JedisDao jedisDaoImpl;
    @Override
    public List<SysPrivilege> findAll() {
        return sysPrivilegeMapper.selectByExample(new SysPrivilegeExample());
    }

    @Override
    public List<PrivilegeTree> findByParentId(Long parentId) {
        return findPrivilegeTree();
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
        String key = "xzx:menu:all";
        if (jedisDaoImpl.exists(key)) {
            return JsonUtils.jsonToList(jedisDaoImpl.get(key), PrivilegeTree.class);
        }else {
            List<PrivilegeTree> privilegeTrees = recursionFindPrivilegeTree(null, null);
            jedisDaoImpl.set(key, JsonUtils.objectToJson(privilegeTrees));
            return privilegeTrees;
        }
    }

    @Override
    public List<SysPrivilege> findByUserId(long id) {
        return sysPrivilegeExtendMapper.selectByUserId(id);
    }

    @Override
    public List<PrivilegeTree> findMenuByUserId(Long id, Long privilegeParentId) {
        String key = "xzx:menu:" + id;
        if (jedisDaoImpl.exists(key)) {
            return JsonUtils.jsonToList(jedisDaoImpl.get(key), PrivilegeTree.class);
        }else {
            List<PrivilegeTree> privilegeTrees = recursionFindPrivilegeTree(id, privilegeParentId);
            jedisDaoImpl.set(key, JsonUtils.objectToJson(privilegeTrees));
            return privilegeTrees;
        }
    }
    List<PrivilegeTree> recursionFindPrivilegeTree(Long id, Long privilegeParentId) {
        List<PrivilegeTree> sysPrivilegeExtends = sysPrivilegeExtendMapper.selectMenuByUserId(id, privilegeParentId);
        for (PrivilegeTree privilegeExtend : sysPrivilegeExtends) {
            for (PrivilegeTree child : privilegeExtend.getChildren()) {
                child.setChildren(recursionFindPrivilegeTree(id, child.getId()));
            }
        }
        return sysPrivilegeExtends;
    }
    @Override
    public void deleteById(long id) {
        sysPrivilegeMapper.deleteByPrimaryKey(id);
        baseCommonService.removePrivilegeRedis();
    }

}
