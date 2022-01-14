package com.lxl.store.util;

import lombok.Data;

/**
 * Json格式的数据进行相应响应
 * @author LiXianLei
 * @time 2022/01/12 21:20
 */
@Data
public class JsonResult<E> {
    // 状态码
    private Integer state;
    // 状态信息
    private String message;
    // 数据
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state){
        this.state = state;
    }

    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
    public JsonResult(Integer state, E data){
        this.state = state;
        this.data = data;
    }
}
