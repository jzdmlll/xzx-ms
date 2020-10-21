package com.xzx.xzxms.vm;

import com.xzx.xzxms.bean.SysFile;
import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.SysProDetailCheck;
import com.xzx.xzxms.bean.SysProDetailWithBLOBs;

import java.util.List;

public class ProDetailReqVM {
    private SysProDetailWithBLOBs proDetails;
    private List<SysFile> files;
    private List<SysProDetailCheck> proChecks;

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

    public List<SysProDetailCheck> getProChecks() {
        return proChecks;
    }

    public void setProChecks(List<SysProDetailCheck> proChecks) {
        this.proChecks = proChecks;
    }
}
