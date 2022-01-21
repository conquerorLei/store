package com.lxl.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LiXianLei
 * @time 2022/01/21 23:31
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${web.upload-path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + uploadPath);
    }
}
