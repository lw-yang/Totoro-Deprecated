package com.lwyang.common.enums;

/**
 * 定义返回元信息
 *
 * @author lwyang
 */
public enum ResultEnum {

    SUCCESS(0, "成功"),

    ;

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
