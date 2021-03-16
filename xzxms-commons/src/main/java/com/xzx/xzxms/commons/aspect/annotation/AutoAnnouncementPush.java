package com.xzx.xzxms.commons.aspect.annotation;

import com.xzx.xzxms.commons.constant.CommonConstant;

import java.lang.annotation.*;

/**
 * 系统消息推送注解
 * @Author Lzc
 * @Date 2021/3/15 13:58
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoAnnouncementPush {
    /**
     * 通知内容
     * @return
     */
    String value() default "";
    /**
     * 通知内容
     * @return
     */
    String title() default "标题";
    /**
     * 通告对象类型（USER:指定用户，ALL:全体用户）
     * @default ALL:全体用户
     * @return
     */
    String msgType() default CommonConstant.MSG_TYPE_UESR;
    /**
     * 消息类型  1:通知公告2:系统消息
     * @default 2:系统消息
     * @return
     */
    String msgCategory() default CommonConstant.MSG_CATEGORY_1;
}
