package com.example.carts;

import com.example.carts.config.DefaultFeignConfig;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: CartsApplication.java
 * @Author: HSL
 * @Date: 2023/12/13 15:38
 * @Description:
 */
@EnableFeignClients(basePackages = "com.example.api.client",defaultConfiguration = DefaultFeignConfig.class)   //这个注解的必要是什么？
@SpringBootApplication
@MapperScan("com.example.carts.dao")
public class CartsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartsApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
