package com.lwyang.customer.validator;

import com.lwyang.customer.annotation.Byte;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 自定义Byte类型的验证器
 * @author lwyang
 */
public class ByteValidator implements ConstraintValidator<Byte, java.lang.Byte> {

    private List<java.lang.Byte> candidateByte;

    @Override
    public void initialize(Byte constraintAnnotation) {
        String[] candidateString = constraintAnnotation.support();
        candidateByte = Arrays.stream(candidateString)
                .map(java.lang.Byte::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(java.lang.Byte value, ConstraintValidatorContext context) {
        long result = candidateByte.stream().filter(x->x.equals(value)).count();
        return result != 0;
    }
}
