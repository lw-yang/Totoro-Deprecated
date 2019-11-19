package com.lwyang.customer.enums;

public enum ConstEnum {

    TOKEN("token"),

    ;

    private String str;

    ConstEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
