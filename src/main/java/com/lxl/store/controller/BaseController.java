package com.lxl.store.controller;

import com.lxl.store.exception.*;
import com.lxl.store.strategy.ExceptionSettleStrategy;
import com.lxl.store.strategy.ExceptionSettleStrategyFactory;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @author LiXianLei
 * @time 2022/01/12 21:47
 */
public class BaseController {
    // 操作成功的状态码
    public static final int OK = 200;

    @Autowired
    private final ExceptionSettleStrategyFactory strategyFactory;

    @Autowired
    public BaseController(){
        this.strategyFactory = new ExceptionSettleStrategyFactory();
    }

    /**
     * @author LiXianLei
     * @describtion 当前项目中产生了异常，被统一拦截到此方法中，这个方法此时就充当的是请求处理方法，方法的返回值直接传给前端
     * 请求处理的方法，这个方法的返回值就是需要传递到前端的数据
     * 自动将异常对象传递给此方法的参数列表上
     * @return {@link null}
     * @time 2022/1/12 22:17
     **/
    @ExceptionHandler({ServiceException.class, FileUploadException.class}) // 用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        ExceptionSettleStrategy settlementInstance = strategyFactory.getSettlementInstance(e.getClass().getSimpleName());
        result.setState(settlementInstance.getResult());
        result.setMessage(e.getMessage());
        return result;
    }

    /**
     * 只允许本包使用，不允许继承修改
     * @author LiXianLei
     * @describtion 获取session对象中的uid
     * @return {@link Integer}
     * @param session
     * @time 2022/1/13 19:31
     **/
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * @author LiXianLei
     * @describtion 获取当前登录用户的username
     * @return {@link String}
     * @param session
     * @time 2022/1/13 19:35
     **/
    protected final String getUsernameFromSession(HttpSession session){
        return String.valueOf(session.getAttribute("username"));
    }

}
