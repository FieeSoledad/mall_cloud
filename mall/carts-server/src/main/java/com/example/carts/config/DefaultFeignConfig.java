package com.example.carts.config;

import com.example.carts.interceptor.UserContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

/**
 * @Title: DefaultFeignConfig.java
 * @Author: HSL
 * @Date: 2023/12/14 23:10
 * @Description:
 */

public class DefaultFeignConfig {
    //设置openfeign日志级别
    
    @Bean
    public RequestInterceptor userInfoRequestInterceptor()
    {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Long userId = UserContext.getUser();
                requestTemplate.header("user-info", userId.toString());
            }
        };
    }

}
