package com.lwyang.customer.controller;

import com.lwyang.common.util.Result;
import com.lwyang.customer.enums.CustomerErrorEnum;
import com.lwyang.customer.exception.CustomerException;
import com.lwyang.customer.service.CustomerService;
import com.lwyang.customer.service.impl.CustomerServiceImpl;
import com.lwyang.customer.vo.CustomerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Customer Controller
 *
 * @author lwyang
 */
@RestController
@RequestMapping(value = "customer/")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("register")
    public CustomerVo register(@RequestBody CustomerVo customerVo) {
        if (!customerVo.validateRegistration()){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_INVALID_PARAMS);
        }
        return customerService.addCustomer(customerVo);
    }

    @PostMapping(value = "login")
    public Map<String, String> login(@RequestBody CustomerVo customerVo) {
        if (!customerVo.validateLogin()){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_INVALID_PARAMS);
        }
        return customerService.login(customerVo);
    }


}
