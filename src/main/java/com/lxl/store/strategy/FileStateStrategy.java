package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/23 00:00
 */
@Component("FileStateException")
public class FileStateStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 6004;
    }
}
