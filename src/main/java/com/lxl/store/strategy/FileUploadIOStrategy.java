package com.lxl.store.strategy;

import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:59
 */
@Component(value = "FileUploadIOException")
public class FileUploadIOStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 6003;
    }
}
