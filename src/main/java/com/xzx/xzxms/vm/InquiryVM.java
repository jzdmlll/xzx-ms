package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.InquiryExtend;

import java.util.List;

public class InquiryVM extends InquiryExtend {
    private List<SysProCheck> proChecks;

    public List<SysProCheck> getProChecks() {
        return proChecks;
    }

    public void setProChecks(List<SysProCheck> proChecks) {
        this.proChecks = proChecks;
    }
}
