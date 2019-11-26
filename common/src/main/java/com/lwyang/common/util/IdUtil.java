package com.lwyang.common.util;

import io.micrometer.core.instrument.Meter;

/**
 * ID生成器，根据Snowflake算法
 * @author lwyang
 */
public class IdUtil {

    private static Snowflake snowflake = new Snowflake(0,0);

    private IdUtil(){}

    /**
     * 生成Id的工具方法
     * @return Long类型的ID
     */
    public static Long nextId(){
        return snowflake.nextId();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(IdUtil.nextId());
        }
    }
}
