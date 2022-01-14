package com.lxl.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 * @author LiXianLei
 * @time 2022/01/13 19:56
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * @author LiXianLei
     * @describtion 检测全局session对象中是否有uid数据，如果有则放行，如果没有重定向到登录页面
     * @return {@link boolean} 为true表示放行，为false表示拦截
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器(url + controller:映射)
     * @time 2022/1/13 20:03
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("uid");
        if(obj == null){
            // 说明用户没有登录
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }
}
