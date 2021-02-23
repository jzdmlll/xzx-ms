package com.xzx.xzxms.recruit.extend;

import com.xzx.xzxms.recruit.bean.RecruitFile;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/23 9:21
 * @修改人：
 * @修改时间：2021/2/23 9:21
 * @修改描述：默认描述
 */
public class RecruitFileExtend extends RecruitFile {
    /**
     * 1-招标信息文件
     */
    public static final int TYPE_RECRUIT_INFO = 1;
    /**
     * 2-投标公司资质文件
     */
    public static final int TYPE_QUALIFICATION = 2;
    /**
     * 3-开标、评标过程信息文件
     */
    public static final int TYPE_BID_EVALUATION = 3;
    /**
     *  4-汇总报告文件
     */
    public static final int TYPE_REPORT = 4;
}
