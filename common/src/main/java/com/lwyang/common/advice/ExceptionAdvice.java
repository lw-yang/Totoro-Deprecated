package com.lwyang.common.advice;

import com.lwyang.common.enums.ResultEnum;
import com.lwyang.common.exception.TotoroException;
import com.lwyang.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 *
 * @author lwyang
 * @see TotoroException
 * @see MethodArgumentNotValidException
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    /**
     * 捕获项目自定义异常
     * @param exception TotoroException
     * @return Result 封装为通用返回结构
     */
    @ExceptionHandler(TotoroException.class)
    public Result exception(TotoroException exception){
        log.error("捕获异常: {}", exception.getMessage());
        return Result.fail(exception.getCode(), exception.getMessage());
    }

    /**
     * 捕获Validate验证失败异常
     * @param validateException MethodArgumentNotValidException
     * @return Result 封装为通用返回结构
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result validateException(MethodArgumentNotValidException validateException){
        log.error("验证失败: {}", validateException.getBindingResult().getFieldError().getDefaultMessage());
        return Result.fail(ResultEnum.VALIDATE_FAIL.getCode(), validateException.getBindingResult().getFieldError().getDefaultMessage());
    }
}
