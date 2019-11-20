package com.lwyang.customer.service;

import com.lwyang.customer.vo.CustomerVo;

import java.util.Map;
import java.util.Optional;

public interface CustomerService {
    CustomerVo addCustomer(CustomerVo customerVo);

    Map<String,String> login(CustomerVo customerVo);

    CustomerVo getCustomer(String username);

    Optional editCustomer(CustomerVo customerVo);
}
