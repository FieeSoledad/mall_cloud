package com.example.user;

import com.example.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Title: Test.java
 * @Author: HSL
 * @Date: 2023/12/13 15:34
 * @Description:
 */
@SpringBootTest
public class Client {

    @Autowired
    private UserService userService;

//    @Test
    public void insertTest()
    {
        System.out.println(userService.insertUser(4,"hushilin"));
    }

    @Test
    public void updateLocation()
    {
        System.out.println(userService.updateLocation(1,"九嶷山"));
    }
}
