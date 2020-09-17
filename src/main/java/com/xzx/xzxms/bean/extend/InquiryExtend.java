package com.xzx.xzxms.bean.extend;

import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.bean.SysFile;

import java.util.List;

public class InquiryExtend extends InquiryWithBLOBs {
    private List<SysFile> files;

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }
}
