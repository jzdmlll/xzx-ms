package com.xzx.xzxms.purchase.dao.extend;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：合同管理
 * @date：2020/12/15 19:07
 * @修改人：
 * @修改时间：2020/12/15 19:07
 * @修改描述：默认描述
 */
@Mapper
@Repository
public interface PurchaseContractManagementExtendMapper {

    List<String> FindAllProjects(@Param("project_name") String project_name);

}
