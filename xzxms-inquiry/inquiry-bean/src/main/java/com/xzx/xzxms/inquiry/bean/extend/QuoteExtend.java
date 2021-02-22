package com.xzx.xzxms.inquiry.bean.extend;


import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

public class QuoteExtend extends Quote {

    private Long proDetailId;
    private Long supplierId;
    private List<SysFile> inquiryFiles;
    private List<SysFile> technologyFiles;

    private List<SysFile> files;

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }

    public List<SysFile> getInquiryFiles() {
        return inquiryFiles;
    }

    public void setInquiryFiles(List<SysFile> inquiryFiles) {
        this.inquiryFiles = inquiryFiles;
    }

    public List<SysFile> getTechnologyFiles() {
        return technologyFiles;
    }

    public void setTechnologyFiles(List<SysFile> technologyFiles) {
        this.technologyFiles = technologyFiles;
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
