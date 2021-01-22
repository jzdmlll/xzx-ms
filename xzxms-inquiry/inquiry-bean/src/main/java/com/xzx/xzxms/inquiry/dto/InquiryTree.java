package com.xzx.xzxms.inquiry.dto;/**
 * @Author sunny
 * @Date 2021/1/21 17:16
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.bean.Inquiry;
import lombok.Data;
import java.util.List;

/**
 *@ClassName inquiryTree
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Data
public class InquiryTree extends Inquiry {

    private List<Inquiry> children;

    public List<Inquiry> getChildren() {
        return children;
    }

    public void setChildren(List<Inquiry> children) {
        this.children = children;
    }
}
