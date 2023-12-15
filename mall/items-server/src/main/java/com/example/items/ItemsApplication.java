package com.example.items;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title: ItemsApplication.java
 * @Author: HSL
 * @Date: 2023/12/13 15:40
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.example.items.dao")
public class ItemsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemsApplication.class,args);
    }
}
