package com.lwyang.customer.service;

import com.lwyang.common.util.IdUtil;
import com.lwyang.customer.dao.CustomerMapper;
import com.lwyang.customer.entity.Customer;
import com.lwyang.customer.enums.CustomerErrorEnum;
import com.lwyang.customer.exception.CustomerException;
import com.lwyang.customer.vo.CustomerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    public CustomerVo addCustomer(CustomerVo customerVo){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerVo, customer);
        Long id = IdUtil.nextId();
        customer.setId(id);
        customer.setCreateTime(LocalDateTime.now());
        customer.setUpdateTime(LocalDateTime.now());
        if (0 == customerMapper.insertSelective(customer)){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_INSERT_ERROR);
        }
        Customer savedCustomer = customerMapper.selectByPrimaryKey(id);
        if (null == savedCustomer){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_NOT_EXIST);
        }
        return CustomerVo.builder().username(savedCustomer.getUsername()).build();
    }
}
