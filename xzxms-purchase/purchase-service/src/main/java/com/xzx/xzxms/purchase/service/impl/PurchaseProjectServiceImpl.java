package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.bean.SysProDetailExample;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.bean.PurchaseProjectExample;
import com.xzx.xzxms.purchase.dao.PurchaseProjectMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseProjectExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseProjectService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseProjectServiceImpl implements IPurchaseProjectService {
    @Resource
    private PurchaseProjectExtendMapper purchaseProjectExtendMapper;
    @Resource
    private PurchaseProjectMapper purchaseProjectMapper;
    @Resource
    private SysProDetailMapper sysProDetailMapper;
    /**
     * 模糊查询项目名
     * @param name
     * @return
     */
    @Override
    public List<PurchaseProject> findAllLike(String name) {
        return purchaseProjectExtendMapper.findAllLike(name);
    }

    /**
     * 通过主键id查询采购项目对象
     * @param id
     * @return
     */
    @Override
    public List<PurchaseProject> findById(Long id) {
        PurchaseProjectExample example = new PurchaseProjectExample();
        example.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(1);
        return purchaseProjectMapper.selectByExample(example);
    }

    /**
     * 通过主键id逻辑假删
     * @param id
     */
    @Override
    public void deleteById(long id) {
        long time = new Date().getTime();
        PurchaseProject purchaseProject = purchaseProjectMapper.selectByPrimaryKey(id);
        if(purchaseProject==null || purchaseProject.getIsActive().equals(0)){
            throw new CustomerException("该数据已不存在");
        }else {
            purchaseProject.setIsActive(0);
            purchaseProject.setTime(time);
            purchaseProjectMapper.updateByPrimaryKeySelective(purchaseProject);
        }
    }

    /**
     * 新增或者修改采购项目，这里判断了采购项目名是否与询价项目名冲突
     * @param purchaseProject
     */
    @Override
    public void saveOrUpdate(PurchaseProject purchaseProject) {
        long time = new Date().getTime();
        if(purchaseProject.getId() != null){
            purchaseProject.setTime(time);
           purchaseProjectMapper.updateByPrimaryKeySelective(purchaseProject);
        }else {
            SysProDetailExample sysProDetailExample = new SysProDetailExample();
            sysProDetailExample.createCriteria().andNameEqualTo(purchaseProject.getProjectName()).andIsActiveEqualTo(1);
            List<SysProDetail> list = sysProDetailMapper.selectByExample(sysProDetailExample);
            if(list.size()>0){
                throw new  CustomerException("项目名已经存在");
            }else {
                purchaseProject.setId(IDUtils.getId());
                purchaseProject.setIsActive(1);
                purchaseProject.setTime(time);
                purchaseProjectMapper.insert(purchaseProject);
            }
        }
    }
}