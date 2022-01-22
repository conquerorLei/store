package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:54
 */
@Component(value = "UsernameNotFoundException")
public class UsernameNotFoundStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 5001;
    }
}
