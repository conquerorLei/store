package com.lxl.store.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LiXianLei
 * @time 2022/01/23 00:04
 */
@Service
public class ExceptionSettleStrategyFactory {

    @Autowired
    private final Map<String, ExceptionSettleStrategy> map = new ConcurrentHashMap<>();

    public ExceptionSettleStrategy getSettlementInstance(String name){
        ExceptionSettleStrategy ess = map.get(name);
        if(ess == null){
            throw new RuntimeException("未定义异常");
        }
        return ess;
    }
}
