package com.lwyang.customer.service.impl;

import com.lwyang.common.cache.ICache;
import com.lwyang.common.util.IdUtil;
import com.lwyang.customer.dao.CustomerMapper;
import com.lwyang.customer.entity.Customer;
import com.lwyang.customer.enums.ConstEnum;
import com.lwyang.customer.enums.CustomerErrorEnum;
import com.lwyang.customer.exception.CustomerException;
import com.lwyang.customer.service.CustomerService;
import com.lwyang.customer.vo.CustomerVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ICache cache;

    @Override
    public CustomerVo addCustomer(CustomerVo customerVo){
        int count = customerMapper.countByUsername(customerVo.getUsername());
        if (count != 0){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_USERNAME_EXIST);
        }
        count = customerMapper.countByEmail(customerVo.getEmail());
        if (count != 0){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_EMAIL_EXIST);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerVo, customer);

        Long id = IdUtil.nextId();
        customer.setId(id);
        customer.setPassword(DigestUtils.md5Hex(customerVo.getPassword()));
        customer.setCreateTime(LocalDateTime.now());
        customer.setUpdateTime(LocalDateTime.now());
        if (0 == customerMapper.insertSelective(customer)){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_INSERT_ERROR);
        }
        return CustomerVo.builder().username(customerVo.getUsername()).build();
    }

    @Override
    public Map<String,String> login(CustomerVo customerVo){
        Customer customer = customerMapper.selectByUsername(customerVo.getUsername());
        if (null == customer){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_NOT_EXIST);
        }

        String cryptPassword = DigestUtils.md5Hex(customerVo.getPassword());
        if (!StringUtils.equals(cryptPassword, customer.getPassword())){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_PASSWORD_ERROR);
        }

        String token = UUID.randomUUID().toString().replaceAll("-", "");
        cache.set(ConstEnum.TOKEN.getStr(), token);
        Map<String, String> returnData = new HashMap<>(1,1);
        returnData.put(ConstEnum.TOKEN.getStr(), token);
        return returnData;
    }

    @Override
    public CustomerVo getCustomer(String username){
        Customer customer = customerMapper.selectByUsername(username);
        if (customer == null){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_NOT_EXIST);
        }

        CustomerVo customerVo = new CustomerVo();
        BeanUtils.copyProperties(customer, customerVo);
        return customerVo;
    }

    @Override
    public Optional editCustomer(CustomerVo customerVo){
        int count = customerMapper.countByEmail(customerVo.getEmail());
        if (count != 0){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_EMAIL_EXIST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerVo, customer);
        if (0 == customerMapper.updateByUsernameSelective(customer)){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_UPDATE_ERROR);
        }
        return Optional.empty();
    }
}
