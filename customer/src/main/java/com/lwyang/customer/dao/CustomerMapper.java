package com.lwyang.customer.dao;

import com.lwyang.customer.entity.Customer;
import org.apache.commons.lang3.StringUtils;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer selectByUsername(String username);
}