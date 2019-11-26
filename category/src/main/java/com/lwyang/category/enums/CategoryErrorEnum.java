package com.lwyang.category.enums;

/**
 * Category模块异常枚举类
 * @author lwyang  2019/11/26
 */
public enum CategoryErrorEnum {

    CATEGORY_INSERT_ERROR(2000, "类别添加失败"),
    CATEGORY_NOT_EXIST(2001, "没有这个类别"),
    CATEGORY_UPDATE_ERROR(2002,"类别更新失败"),

    ;

    private Integer code;
    private String message;

    CategoryErrorEnum(Integer code, String message) {
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
