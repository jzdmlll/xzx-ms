package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.SysProCheck;

public class InquiryCompareExtend extends Inquiry {

    public SysProCheck sysProCheck;

    public SysProCheck getSysProCheck() {
        return sysProCheck;
    }

    public void setSysProCheck(SysProCheck sysProCheck) {
        this.sysProCheck = sysProCheck;
    }
}
