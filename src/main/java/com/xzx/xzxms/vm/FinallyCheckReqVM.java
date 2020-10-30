package com.xzx.xzxms.vm;


import com.xzx.xzxms.bean.SysProCheck;

import java.util.List;
import java.util.Map;

public class FinallyCheckReqVM {
    private long[] checkCompareIds;
    private long[] uncheckCompareIds;
    private long userId;
    private List<Map> remarks;

    public long[] getCheckCompareIds() {
        return checkCompareIds;
    }

    public void setCheckCompareIds(long[] checkCompareIds) {
        this.checkCompareIds = checkCompareIds;
    }

    public long[] getUncheckCompareIds() {
        return uncheckCompareIds;
    }

    public void setUncheckCompareIds(long[] uncheckCompareIds) {
        this.uncheckCompareIds = uncheckCompareIds;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Map> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Map> remarks) {
        this.remarks = remarks;
    }
}
