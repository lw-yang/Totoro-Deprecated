package com.lwyang.common.annotation;

import com.lwyang.common.util.Result;

import java.lang.annotation.*;

/**
 * 标识对返回值进行{@link Result}封装的注解
 *
 * @author lwyang
 * @see com.lwyang.common.advice.ResultAdvice
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Inherited
public @interface ResultBodyAdvice {
    String value() default "";
}
