package com.lwyang.customer.service.impl;

import com.lwyang.common.cache.ICache;
import com.lwyang.common.util.IdUtil;
import com.lwyang.customer.dao.CustomerMapper;
import com.lwyang.customer.entity.Customer;
import com.lwyang.customer.enums.CustomerConstEnum;
import com.lwyang.customer.enums.CustomerErrorEnum;
import com.lwyang.customer.exception.CustomerException;
import com.lwyang.customer.service.CustomerService;
import com.lwyang.customer.vo.CustomerEditVo;
import com.lwyang.customer.vo.CustomerVo;
import com.lwyang.customer.vo.LoginVo;
import com.lwyang.customer.vo.RegisterVo;
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

/**
 * 顾客模块业务处理
 * @author lwyang
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ICache cache;

    @Override
    public Map<String, String> addCustomer(RegisterVo registerVo){
        int count = customerMapper.countByUsername(registerVo.getUsername());
        if (count != 0){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_USERNAME_EXIST);
        }
        count = customerMapper.countByEmail(registerVo.getEmail());
        if (count != 0){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_EMAIL_EXIST);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(registerVo, customer);

        Long id = IdUtil.nextId();
        customer.setId(id);
        customer.setPassword(DigestUtils.md5Hex(registerVo.getPassword()));
        customer.setCreateTime(LocalDateTime.now());
        customer.setUpdateTime(LocalDateTime.now());
        if (0 == customerMapper.insertSelective(customer)){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_INSERT_ERROR);
        }
        Map<String, String> returnData = new HashMap<>(1,1);
        returnData.put(CustomerConstEnum.USERNAME.getStr(),registerVo.getUsername());
        return returnData;
    }

    @Override
    public Map<String,String> login(LoginVo loginVo){
        Customer customer = customerMapper.selectByUsername(loginVo.getUsername());
        if (null == customer){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_NOT_EXIST);
        }

        String cryptPassword = DigestUtils.md5Hex(loginVo.getPassword());
        if (!StringUtils.equals(cryptPassword, customer.getPassword())){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_PASSWORD_ERROR);
        }

        String token = UUID.randomUUID().toString().replaceAll("-", "");
        cache.set(CustomerConstEnum.TOKEN.getStr(), token);
        Map<String, String> returnData = new HashMap<>(1,1);
        returnData.put(CustomerConstEnum.TOKEN.getStr(), token);
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
    public Optional editCustomer(CustomerEditVo customerEditVo){
        int count = customerMapper.countByEmail(customerEditVo.getEmail());
        if (count != 0){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_EMAIL_EXIST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerEditVo, customer);
        customer.setUpdateTime(LocalDateTime.now());
        if (0 == customerMapper.updateByUsernameSelective(customer)){
            throw new CustomerException(CustomerErrorEnum.CUSTOMER_UPDATE_ERROR);
        }
        return Optional.empty();
    }
}
