package com.lwyang.customer.controller;

import com.lwyang.common.annotation.ResultBodyAdvice;
import com.lwyang.common.util.Result;
import com.lwyang.customer.enums.CustomerErrorEnum;
import com.lwyang.customer.exception.CustomerException;
import com.lwyang.customer.service.CustomerService;
import com.lwyang.customer.vo.CustomerEditVo;
import com.lwyang.customer.vo.CustomerVo;
import com.lwyang.customer.vo.LoginVo;
import com.lwyang.customer.vo.RegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * 顾客模块Controller
 *
 * @author lwyang
 */
@RestController
@RequestMapping(value = "customer/")
@Slf4j
@Api("CustomerController")
@ResultBodyAdvice
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    @ApiOperation(value = "用户注册", response = Result.class)
    public Map<String, String> register(@RequestBody @Validated RegisterVo registerVo) {
        return customerService.addCustomer(registerVo);
    }

    @PostMapping(value = "login")
    @ApiOperation(value = "用户登录", response = Result.class)
    public Map<String, String> login(@RequestBody @Validated LoginVo loginVo) {
        return customerService.login(loginVo);
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "获取用户信息", response = Result.class)
    public CustomerVo getCustomer(@PathVariable("username") String username){
        if (StringUtils.isBlank(username)){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_INVALID_PARAMS);
        }
        return customerService.getCustomer(username);
    }

    @PutMapping("/")
    @ApiOperation(value = "更新用户信息", response = Result.class)
    public Optional updateCustomer(@RequestBody @Validated CustomerEditVo customerEditVo){
        return customerService.editCustomer(customerEditVo);
    }

}
