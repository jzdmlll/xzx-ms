package com.xzx.xzxms.inquiry.vm;


import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

public class ProDetailReqVM {
    private SysProDetailWithBLOBs proDetails;
    private List<SysFile> files;

    public SysProDetailWithBLOBs getProDetails() {
        return proDetails;
    }

    public void setProDetails(SysProDetailWithBLOBs proDetails) {
        this.proDetails = proDetails;
    }

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }

}
