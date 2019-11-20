package com.lwyang.customer.enums;

/**
 * customer模块通用错误枚举类
 * @author lwyang
 */
public enum  CustomerErrorEnum {

    CUSTOMER_INVALID_PARAMS(1000, "参数校验失败"),
    CUSTOMER_INSERT_ERROR(1001, "顾客添加异常"),
    CUSTOMER_UPDATE_ERROR(1002,"顾客更新异常"),
    CUSTOMER_DELETE_ERROR(1003,"顾客删除异常"),
    CUSTOMER_NOT_EXIST(1004,"该顾客不存在"),
    CUSTOMER_PASSWORD_ERROR(1005,"密码错误"),
    CUSTOMER_USERNAME_EXIST(1006,"用户名已存在"),
    CUSTOMER_EMAIL_EXIST(1007,"邮箱已存在"),
    CUSTOMER_NO_UPDATE(1008,"用户信息无修改"),

    ;

    private Integer code;
    private String message;

    CustomerErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
