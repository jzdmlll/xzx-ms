package com.xzx.xzxms.inquiry.bean.extend;


import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

public class QuoteExtend extends Quote {

    private List<SysFile> files;
    private Long proDetailId;
    private Long supplierId;

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }

    public Long getProDetailId() {
        return proDetailId;
    }

    public void setProDetailId(Long proDetailId) {
        this.proDetailId = proDetailId;
    }

    @Override
    public Long getSupplierId() {
        return supplierId;
    }

    @Override
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
