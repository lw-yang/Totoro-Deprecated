package com.lwyang.customer.validator;

import com.lwyang.customer.annotation.ByteSupport;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 自定义Byte类型的验证器
 * @author lwyang
 */
public class ByteValidator implements ConstraintValidator<ByteSupport, java.lang.Byte> {

    private List<java.lang.Byte> candidateByte;

    @Override
    public void initialize(ByteSupport constraintAnnotation) {
        String[] candidateString = constraintAnnotation.support();
        candidateByte = Arrays.stream(candidateString)
                .map(java.lang.Byte::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(java.lang.Byte value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        long result = candidateByte.stream().filter(x->x.equals(value)).count();
        return result != 0;
    }
}
