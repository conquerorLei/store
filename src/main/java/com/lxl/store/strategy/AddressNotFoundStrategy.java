package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @since 2022/06/04 00:35
 */
@Component(value = "AddressNotFoundException")
public class AddressNotFoundStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 4004;
    }
}
