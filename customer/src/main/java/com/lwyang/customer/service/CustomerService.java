package com.lwyang.customer.service;

import com.lwyang.customer.vo.CustomerVo;

import java.util.Map;

public interface CustomerService {
    CustomerVo addCustomer(CustomerVo customerVo);

    Map<String,String> login(CustomerVo customerVo);
}
