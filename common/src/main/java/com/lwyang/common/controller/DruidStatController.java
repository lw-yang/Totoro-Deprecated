package com.lwyang.common.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用来监控Druid连接池各项数据
 * @author lwyang
 */
@RestController
@RequestMapping("druid/")
public class DruidStatController {

    @GetMapping("stat")
    public Object druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

    @GetMapping("activeConn")
    public List<List<String>> getActiveConnStackTraceList(){
        return DruidStatManagerFacade.getInstance().getActiveConnStackTraceList();
    }

    @GetMapping("basic")
    public Map<String, Object> returnJSONBasicStat(){
        return DruidStatManagerFacade.getInstance().returnJSONBasicStat();
    }
}
