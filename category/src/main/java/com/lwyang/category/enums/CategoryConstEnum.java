package com.lwyang.category.enums;

/**
 * @author lwyang  2019/11/26
 */
public enum  CategoryConstEnum {

    CATEGORY_ID("CategoryId"),

    ;

    private String str;

    CategoryConstEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
