package com.lwyang.customer.service;

import com.lwyang.customer.dto.EditCustomerDTO;
import com.lwyang.customer.dto.CustomerDTO;
import com.lwyang.customer.dto.LoginDTO;
import com.lwyang.customer.dto.RegisterDTO;

import java.util.Map;
import java.util.Optional;

/**
 * 顾客模块业务处理接口
 * @author lwyang
 */
public interface CustomerService {

    Map<String, String> addCustomer(RegisterDTO registerDTO);

    Map<String,String> login(LoginDTO loginDTO);

    CustomerDTO getCustomer(Long userId);

    Optional editCustomer(EditCustomerDTO editCustomerDTO);
}
