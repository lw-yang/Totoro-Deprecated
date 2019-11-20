package com.lwyang.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.FormContentFilter;

/**
 * 配置支持PUT方法
 * @author lwyang
 */
@Configuration(proxyBeanMethods = false)
public class HttpPutConfiguration{

    @Bean
    public FormContentFilter httpPutFormContentFilter() {
        return new FormContentFilter();
    }
}
