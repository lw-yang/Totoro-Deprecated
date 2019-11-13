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

    public static Result success(){
        return Result.builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .build();
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = Result.success();
        result.setData(data);
        return result;
    }

    public static Result fail(ResultEnum resultEnum){
        return Result.builder()
                .code(resultEnum.getCode())
                .message(resultEnum.getMessage())
                .build();
    }
}
