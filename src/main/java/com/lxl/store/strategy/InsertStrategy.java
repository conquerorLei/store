package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:53
 */
@Component(value = "InsertException")
public class InsertStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 5000;
    }
}
