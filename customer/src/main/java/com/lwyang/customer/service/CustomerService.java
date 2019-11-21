package com.lwyang.customer.service;

import com.lwyang.customer.vo.CustomerEditVo;
import com.lwyang.customer.vo.CustomerVo;
import com.lwyang.customer.vo.LoginVo;
import com.lwyang.customer.vo.RegisterVo;

import java.util.Map;
import java.util.Optional;

/**
 * 顾客模块业务处理接口
 * @author lwyang
 */
public interface CustomerService {

    Map<String, String> addCustomer(RegisterVo registerVo);

    Map<String,String> login(LoginVo loginVo);

    CustomerVo getCustomer(String username);

    Optional editCustomer(CustomerEditVo customerEditVo);
}
