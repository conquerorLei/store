package com.lxl.store.config;

import com.lxl.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.LinkedList;
import java.util.List;

/**
 * 完成拦截器的注册
 * @author LiXianLei
 * @time 2022/01/13 20:17
 */
@Configuration // 加载当前的拦截器进行注册
public class LoginInterceptorConfig implements WebMvcConfigurer {
    /**
     * @author LiXianLei
     * @describtion 配置拦截器
     * @return
     * @param registry
     * @time 2022/1/13 20:20
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new LoginInterceptor();
        // 配置白名单
        List<String> patterns = new LinkedList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/index.html");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/product.html");
        patterns.add("/users/register");
        patterns.add("/users/login");
        patterns.add("/districts/**");

        // 注册拦截器
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);

    }
}
