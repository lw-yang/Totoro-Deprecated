package com.lwyang.customer.annotation;

import com.lwyang.customer.validator.ByteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Byte类型数据的验证注解
 *
 * @author lwyang
 * @see ByteValidator
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ByteValidator.class)
public @interface ByteSupport {

    String message() default "{com.lwyang.customer.annotation.Byte.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // 支持的Byte类型的数
    String[] support() default "";
}
