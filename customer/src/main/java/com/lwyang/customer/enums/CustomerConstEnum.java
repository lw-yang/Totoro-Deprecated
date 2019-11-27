package com.lwyang.customer.enums;

/**
 * 通用常量
 * @author lwyang
 */
public enum CustomerConstEnum {

    TOKEN("token"),
    USERNAME("username"),
    USER_ID("userId"),

    ;

    private String str;

    CustomerConstEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
