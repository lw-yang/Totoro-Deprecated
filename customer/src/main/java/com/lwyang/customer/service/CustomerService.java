package com.lwyang.customer.service;

import com.lwyang.customer.vo.CustomerEditDTO;
import com.lwyang.customer.vo.CustomerDTO;
import com.lwyang.customer.vo.LoginDTO;
import com.lwyang.customer.vo.RegisterDTO;

import java.util.Map;
import java.util.Optional;

/**
 * 顾客模块业务处理接口
 * @author lwyang
 */
public interface CustomerService {

    Map<String, String> addCustomer(RegisterDTO registerDTO);

    Map<String,String> login(LoginDTO loginDTO);

    CustomerDTO getCustomer(String username);

    Optional editCustomer(CustomerEditDTO customerEditDTO);
}
