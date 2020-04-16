package com.soft1851.springboot.jwt.config;

import com.soft1851.springboot.jwt.intercept.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/15
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private JwtInterceptor jwtInterceptor;
    /**
     * 添加拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("12");
        //拦截路径可自行配置多个 可用 ，分隔开
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/static/**");
    }


}


