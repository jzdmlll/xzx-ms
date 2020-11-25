package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.SysCheckExtend;
import com.xzx.xzxms.vm.toDoList;
import org.apache.ibatis.annotations.Param;

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


    //待办
    List<toDoList> findTechnicalAuditDeal();
    List<toDoList> findBusinessAuditDeal();
    List<toDoList> findCompareAuditDeal();
    List<toDoList> findFinallyAuditDeal();

}
