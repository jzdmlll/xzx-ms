package com.xzx.xzxms.inquiry.bean.extend;


import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

public class QuoteExtend extends Quote {

    private List<SysFile> files;
    private long proDetailId;

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }

    public long getProDetailId() {
        return proDetailId;
    }

    public void setProDetailId(long proDetailId) {
        this.proDetailId = proDetailId;
    }
}
