package com.lwyang.customer.service;

import com.lwyang.customer.vo.CustomerVo;
import com.lwyang.customer.vo.RegisterVo;

import java.util.Map;
import java.util.Optional;

/**
 * 顾客模块业务处理接口
 * @author lwyang
 */
public interface CustomerService {

    CustomerVo addCustomer(RegisterVo registerVo);

    Map<String,String> login(CustomerVo customerVo);

    CustomerVo getCustomer(String username);

    Optional editCustomer(CustomerVo customerVo);
}
