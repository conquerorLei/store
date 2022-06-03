package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @since 2022/06/04 00:46
 */
@Component(value = "DeleteException")
public class DeleteStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 5004;
    }
}
