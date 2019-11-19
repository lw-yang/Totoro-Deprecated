package com.lwyang.common.advice;

import com.lwyang.common.exception.TotoroException;
import com.lwyang.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 * @author lwyang
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(TotoroException.class)
    public Result exception(TotoroException exception){
        log.error(exception.getMessage());
        return Result.fail(exception.getCode(), exception.getMessage());
    }
}
