package com.limai.database.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 禁止重复提交自定义注解
 *
 * @author Zhang bin
 * @version [版本号, 2020/5/28 16:10]
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRepeatSubmit {
    /**
     * 过期时间，单位毫秒
     */
    long value() default 5000;
}
