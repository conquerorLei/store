package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:57
 */
@Component(value = "FileEmptyException")
public class FileEmptyStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 6000;
    }
}
