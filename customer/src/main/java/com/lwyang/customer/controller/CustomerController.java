package com.lwyang.customer.controller;

import com.lwyang.common.util.Result;
import com.lwyang.customer.enums.CustomerErrorEnum;
import com.lwyang.customer.exception.CustomerException;
import com.lwyang.customer.service.CustomerService;
import com.lwyang.customer.service.impl.CustomerServiceImpl;
import com.lwyang.customer.vo.CustomerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * Customer Controller
 *
 * @author lwyang
 */
@RestController
@RequestMapping(value = "customer/")
@Slf4j
@Api("CustomerController")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    @ApiOperation(value = "用户注册", httpMethod = "post")
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

    @GetMapping("/{username}")
    public CustomerVo getCustomer(@PathVariable("username") String username){
        if (StringUtils.isBlank(username)){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_INVALID_PARAMS);
        }
        return customerService.getCustomer(username);
    }

    @PutMapping("/")
    public Optional updateCustomer(@RequestBody CustomerVo customerVo){
        if (!customerVo.validateUpdate()){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_NO_UPDATE);
        }
        return customerService.editCustomer(customerVo);
    }

}
