package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/24 17:44
 */
@Component(value = "AddressCountLimitException")
public class AddressCountLimitStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 4003;
    }
}
