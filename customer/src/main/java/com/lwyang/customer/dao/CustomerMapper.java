package com.lwyang.customer.dao;

import com.lwyang.customer.entity.Customer;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据库操作接口
 * @author lwyang
 */
public interface CustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer selectByUsername(String username);

    Integer countByUsername(String username);

    Integer countByEmail(String email);

    int updateByUsernameSelective(Customer record);

    int deleteByPrimaryKeyIn(@Param("userIds") List<Long> userIds);
}