package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.bean.SysProDetailExample;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.bean.PurchaseProject;
import com.xzx.xzxms.purchase.bean.PurchaseProjectExample;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseProjectMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseProjectExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;
    /**
     * 模糊查询项目名
     * @param name
     * @return
     */
    @Override
    //调用extendMapper中写的模糊查询方法
    public List<PurchaseProject> findAllLike(String name) {
        return purchaseProjectExtendMapper.findAllLike(name);
    }

    /**
     * 通过主键id查询采购项目对象
     * @param id
     * @return
     */
    @Override
    //使用example的筛选方式，通过selectByExample方法进行查询
    public List<PurchaseProject> findById(Long id) {
        PurchaseProjectExample example = new PurchaseProjectExample();
        example.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(1);
        return purchaseProjectMapper.selectByExample(example);
    }

    /**
     * 通过主键id逻辑假删
     * @param id
     */
    //这里新增了user参数
    @Transactional
    @Override
    public void deleteById(Long id, Long user) {
        long time = new Date().getTime();
        //通过前台传的参数id查询采购项目对象
        PurchaseProject purchaseProject = purchaseProjectMapper.selectByPrimaryKey(id);
        //如果查询出的采购项目对象为空或者该采购项目对象为无效的，则返回“数据不存在”

        if(purchaseProject==null || purchaseProject.getIsActive().equals(0)){
            throw new CustomerException("该数据已不存在");
        }else {
            //判断项目下是否有采购项，无采购项的情况才能删除
            PurchaseItemsExample example = new PurchaseItemsExample();
            example.createCriteria().andProjectIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
            List<PurchaseItems> list = purchaseItemsMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该项目下已有采购项，不可删除。");
            }else {
                //修改符合条件的采购项目对象的部分内容，is_active置为0代表对象无效
                purchaseProject.setIsActive(0);
                purchaseProject.setUpdateTime(time);
                purchaseProject.setUpdateOperator(user + "");
                //使用updateByPrimaryKeySelective方法，将不为空的字段进行修改操作
                purchaseProjectMapper.updateByPrimaryKeySelective(purchaseProject);
            }
        }
    }

    /**
     * 新增或者修改采购项目，这里判断了采购项目名是否与询价项目名冲突
     * @param purchaseProject
     */
    @Override
    public void saveOrUpdate(PurchaseProject purchaseProject) {
        //获取操作时间
        long time = new Date().getTime();
        //如果采购项目的id不为空，设置更新时间，使用updateByPrimaryKeySelective方法，更新不为空的数据
        if(purchaseProject.getId() != null){
            purchaseProject.setUpdateTime(time);
           purchaseProjectMapper.updateByPrimaryKeySelective(purchaseProject);
        }else {
            //首先通过example类进行筛选，找出项目详情表中与参数对象中的采购项目名一样，且有效的数据。
            SysProDetailExample sysProDetailExample = new SysProDetailExample();
            sysProDetailExample.createCriteria().andNameEqualTo(purchaseProject.getProjectName()).andIsActiveEqualTo(1);
            List<SysProDetail> list = sysProDetailMapper.selectByExample(sysProDetailExample);
            //判断采购项目名是否与询价项目名重复，重复则返回“项目名已经存在”
            if(list.size()>0){
                throw new  CustomerException("项目名已经存在");
            }else {
                //先set一些数据
                purchaseProject.setId(IDUtils.getId());
                purchaseProject.setIsActive(1);
                purchaseProject.setTime(time);
                //使用insert方法插入到采购项目表
                purchaseProjectMapper.insert(purchaseProject);
            }
        }
    }
}