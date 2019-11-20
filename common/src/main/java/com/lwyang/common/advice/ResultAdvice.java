package com.lwyang.common.advice;

import com.lwyang.common.annotation.ResultBodyAdvice;
import com.lwyang.common.util.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Optional;

/**
 * 对方法返回值进行Result的封装
 *
 * @author lwyang
 */
@RestControllerAdvice
public class ResultAdvice implements ResponseBodyAdvice {


    /**
     * <p>判断是否有需要进行封装的注解，有{@link ResultBodyAdvice}才会进行封装</p>
     *
     * @param methodParameter  methodParameter
     * @param aClass aClass
     * @return 有 {@link ResultBodyAdvice} 注解返回true，否则返回false
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        if (methodParameter.hasMethodAnnotation(ResultBodyAdvice.class) ||
                methodParameter.getDeclaringClass().isAnnotationPresent(ResultBodyAdvice.class)) {
            return true;
        }
        return false;
    }

    /**
     * <P>封装返回值为{@link Result}结构</p>
     *
     * @param o 用户返回值
     * @param methodParameter methodParameter
     * @param mediaType 媒体类型
     * @param aClass aClass
     * @param serverHttpRequest serverHttpRequest
     * @param serverHttpResponse serverHttpResponse
     * @return Result 封装为通用返回结构
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (o instanceof Optional && !((Optional) o).isPresent()) {

            //返回值为空的情况下
            return Result.success();
        }else if (o instanceof Result){

            //返回异常已经被ExceptionAdvice封装过了，这里就直接返回
            return o;
        }

        return Result.success(o);
    }
}
