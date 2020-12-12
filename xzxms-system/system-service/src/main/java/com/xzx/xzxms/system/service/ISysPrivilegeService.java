package com.xzx.xzxms.system.service;


import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.system.bean.SysPrivilege;
import com.xzx.xzxms.system.bean.extend.SysPrivilegeExtend;
import com.xzx.xzxms.system.vm.PrivilegeTree;

import java.util.List;

public interface ISysPrivilegeService {

    /**
     * @Description: 查询所有权限
     * @Param: []
     * @return: java.util.List<Privilege>
     */
    List<SysPrivilege> findAll();

    /**
     * @Description: 通过parentId查询权限
     * @Param: [parentId]
     * @return: java.util.List<Privilege>
     */
    List<SysPrivilege> findByParentId(Long parentId);

    /**
     * @Description: 保存或更新权限
     * @Param: [privilege]
     * @return: void
     */
    void saveOrUpdate(SysPrivilege privilege) throws CustomerException;

    /**
     * @Description: 查询权限树
     * @Param: []
     * @return: java.util.List<PrivilegeTree>
     */
    List<PrivilegeTree> findPrivilegeTree();

    /**
     * @Description: 查询用户所有权限
     * @Param: [id]
     * @return: java.util.List<Privilege>
     */
    List<SysPrivilege> findByUserId(long id);

    /**
     * @Description: 查询用户菜单权限
     * @Param: [id]
     * @return: java.util.List<PrivilegeExtend>
     */
    List<SysPrivilegeExtend> findMenuByUserId(long id);

    /**
     *
     * @param id
     */
    void deleteById(long id);
}
