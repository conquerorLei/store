package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @since 2022/06/05 00:59
 */
@Component("ProductNotFoundException")
public class ProductNotFoundStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 4005;
    }
}
