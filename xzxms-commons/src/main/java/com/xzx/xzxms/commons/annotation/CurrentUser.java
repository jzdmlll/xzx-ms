package com.xzx.xzxms.commons.annotation;

import java.lang.annotation.*;

/**
 * @Author Lzc
 * @Date 2021/3/15 10:53
 * @Version 1.0
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

}
