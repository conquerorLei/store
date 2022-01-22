package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:58
 */
@Component(value = "FileTypeException")
public class FileTypeStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 6002;
    }
}
