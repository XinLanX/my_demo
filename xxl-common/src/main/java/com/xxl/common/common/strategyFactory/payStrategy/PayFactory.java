package com.xxl.common.common.strategyFactory.payStrategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class PayFactory {

    @Autowired
    Map<String , PayStrategy> map = new ConcurrentHashMap<>();

    public PayStrategy getStrategy(String componentName){
        PayStrategy  strategy = map.get(componentName);
        if (strategy == null){
            log.error("没有获取工厂类 componentName={}",  componentName);
        }
        return strategy;
    }
}
