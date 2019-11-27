package com.lwyang.common.util;

import com.lwyang.common.enums.ResultEnum;
import lombok.Builder;
import lombok.Data;

/**
 * 通用返回结构 {@link ResultEnum}
 *
 * @author lwyang
 * @param <T> 返回成功时的数据类型
 */
@Data
@Builder
public class Result<T> {

    private int code;

    private String message;

    private T data;

    /**
     * 返回成功的工具方法
     * @return Result
     * @see com.lwyang.common.advice.ResultAdvice
     */
    public static Result success(){
        return Result.builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .build();
    }

    /**
     * 返回成功的工具方法,并且带有返回数据data
     * @return Result
     * @see com.lwyang.common.advice.ResultAdvice
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = Result.success();
        result.setData(data);
        return result;
    }

    /**
     * 返回失败的工具方法
     * @param code 错误码
     * @param message 错误信息
     * @return Result
     * @see com.lwyang.common.advice.ExceptionAdvice
     */
    public static Result fail(Integer code, String message){
        return Result.builder()
                .code(code)
                .message(message)
                .build();
    }
}
