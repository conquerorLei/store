package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:36
 */
@Component(value = "UsernameDuplicatedException")
public class UsernameDuplicatedStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 4000;
    }
}
