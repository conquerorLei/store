package com.lxl.store.strategy;

import com.lxl.store.exception.FileOverSizedException;
import org.springframework.stereotype.Component;

/**
 * @author LiXianLei
 * @time 2022/01/22 23:58
 */
@Component(value = "FileOverSizedException")
public class FileOverSizedStrategy implements ExceptionSettleStrategy{
    @Override
    public Integer getResult() {
        return 6001;
    }
}
