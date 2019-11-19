package com.lwyang.customer.exception;

import com.lwyang.common.exception.TotoroException;
import com.lwyang.customer.enums.CustomerErrorEnum;

/**
 * customer模块通用异常类
 * @author lwyang
 */
public class CustomerException extends TotoroException {

    public CustomerException(Integer code, String message) {
        super(code, message);
    }

    public CustomerException(CustomerErrorEnum customerErrorEnum){
        super(customerErrorEnum.getCode(), customerErrorEnum.getMessage());
    }
}
