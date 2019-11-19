package com.lwyang.common.exception;

/**
 * 通用异常
 * @author lwyang
 */
public class TotoroException extends RuntimeException {

    private Integer code;

    public TotoroException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
