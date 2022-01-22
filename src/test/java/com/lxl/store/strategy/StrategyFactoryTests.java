package com.lxl.store.strategy;

import com.lxl.store.exception.UsernameDuplicatedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiXianLei
 * @time 2022/01/23 00:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyFactoryTests {
    @Autowired
    private ExceptionSettleStrategyFactory strategyFactory;

    @Test
    public void getSettlementInstance(){
        String exception = UsernameDuplicatedException.class.getSimpleName();
        ExceptionSettleStrategy ess = strategyFactory.getSettlementInstance(exception);
        System.out.println(ess.getResult());
    }
}
