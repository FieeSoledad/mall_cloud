package com.example.user;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title: UserApplication.java
 * @Author: HSL
 * @Date: 2023/12/13 15:17
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.example.user.dao")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
