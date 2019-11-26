package com.lwyang.category.exception;

import com.lwyang.category.enums.CategoryErrorEnum;
import com.lwyang.common.exception.TotoroException;

/**
 * @author lwyang  2019/11/26
 */
public class CategoryException extends TotoroException {

    public CategoryException(Integer code, String message) {
        super(code, message);
    }

    public CategoryException(CategoryErrorEnum categoryErrorEnum){
        super(categoryErrorEnum.getCode(), categoryErrorEnum.getMessage());
    }

}
