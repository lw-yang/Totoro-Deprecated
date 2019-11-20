package com.lwyang.common.advice;

import com.lwyang.common.annotation.IgnoreResultAdvice;
import com.lwyang.common.util.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Optional;

/**
 * 对方法返回值进行Result的封装
 *
 * @author lwyang
 */
@RestControllerAdvice
public class ResultAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        if (methodParameter.hasMethodAnnotation(IgnoreResultAdvice.class) ||
                methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResultAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (o instanceof Optional && !((Optional) o).isPresent()) {

            //返回值为空的情况下
            return Result.success();
        }else if (o instanceof Result){

            //返回异常已经被ExceptionAdvice封装过了，这里就直接返回
            return o;
        }else if (o instanceof HashMap && ((HashMap) o).containsKey("error")){

            //请求出错（404...）直接返回
            return o;
        }
        return Result.success(o);
    }
}
