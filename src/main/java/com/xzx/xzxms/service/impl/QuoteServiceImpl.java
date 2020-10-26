package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Quote;
import com.xzx.xzxms.bean.QuoteExample;
import com.xzx.xzxms.dao.QuoteMapper;
import com.xzx.xzxms.service.IQuoteService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuoteServiceImpl implements IQuoteService {
    @Resource
    private QuoteMapper quoteMapper;
    @Override
    public List<Quote> findByInquiryId(long inquiryId) {
        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiryId);
        return quoteMapper.selectByExample(example);
    }

    @Override
    public void ImportExcelQuote(MultipartFile excelData) {

    }
}
