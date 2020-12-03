package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.SysCheckExtend;
import com.xzx.xzxms.vm.ToDoList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysProCheckExtendMapper {

    List<SysCheckExtend> cascadeRoleFindAll();

    List<SysCheckExtend> cascadeFindAllByCheckName(@Param("checkName") String checkName,
                                                   @Param("checkStatus") int[] checkStatus, @Param("proDetailId") long proDetailId);

    Integer findExistsCheck(@Param("proDetailId") long proDetailId);

    List<SysCheckExtend> cascadeFindTechnical(@Param("status")Integer status, @Param("proDetailId") long proDetailId);

    List<SysCheckExtend> cascadeFindBusiness(@Param("status")Integer status, @Param("proDetailId") long proDetailId);

    List<SysCheckExtend> cascadeFindCompare(@Param("status")Integer status, @Param("proDetailId") long proDetailId);

    List<SysCheckExtend> cascadeFindFinally(@Param("status")Integer status, @Param("proDetailId") long proDetailId);

    //查询报价是否被审核
    @Select("SELECT COUNT(1) FROM inquiry i LEFT JOIN quote q on i.id = q.inquiry_id " +
            "LEFT JOIN sys_pro_check c on q.id = c.quote_id WHERE i.is_active = 1 AND q.is_active = 1 AND c.business_audit IN(1,2) AND c.technical_audit IN (1,2) AND i.id = #{inquiryId}")
    int findQuoteIsChecked(long inquiryId);

    //待办
    List<ToDoList> findTechnicalAuditDeal();
    List<ToDoList> findBusinessAuditDeal();
    List<ToDoList> findCompareAuditDeal();
    List<ToDoList> findFinallyAuditDeal();

}
