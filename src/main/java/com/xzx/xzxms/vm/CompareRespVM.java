package com.xzx.xzxms.vm;

import java.util.List;
import java.util.Map;

public class CompareRespVM {
    private long[] checkCompareIds;
    private long[] otherCompareIds;
    private List<Map> remarks;

    public long[] getCheckCompareIds() {
        return checkCompareIds;
    }

    public void setCheckCompareIds(long[] checkCompareIds) {
        this.checkCompareIds = checkCompareIds;
    }

    public long[] getOtherCompareIds() {
        return otherCompareIds;
    }

    public void setOtherCompareIds(long[] otherCompareIds) {
        this.otherCompareIds = otherCompareIds;
    }

    public List<Map> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Map> remarks) {
        this.remarks = remarks;
    }
}
