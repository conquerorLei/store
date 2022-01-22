package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:55
 */
@Component(value = "PasswordNotMatchException")
public class PasswordNotMatchStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 5002;
    }
}
