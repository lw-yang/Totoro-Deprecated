package com.lwyang.customer.dao;

import com.lwyang.customer.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class CustomerMapperTest {

    @Autowired
    CustomerMapper customerMapper;


    @Test
    void insert() {
        Customer customer = Customer.builder()
                .id(1L)
                .username("test02")
                .password("123456")
                .answer("123456")
                .question("123456")
                .email("1234567")
                .status((byte) 1)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        int result = customerMapper.insert(customer);
        Assertions.assertEquals(1,result);
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
        Customer savedCustomer = customerMapper.selectByPrimaryKey(646306834856017920L);
        System.out.println(savedCustomer);
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }


    @Test
    void deleteByPrimaryKey() {
        int result = customerMapper.deleteByPrimaryKey(1L);
        Assertions.assertEquals(1,result);
    }
}