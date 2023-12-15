package com.example.api.client;


import com.example.api.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/

@FeignClient("user-server")
public interface UserClient {
    @GetMapping("/user")
    Result selectUserById(@RequestParam("userid") int userid);
}
