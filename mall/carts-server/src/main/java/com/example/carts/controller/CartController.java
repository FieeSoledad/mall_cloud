package com.example.carts.controller;

import com.example.api.client.UserClient;
import com.example.api.entity.Result;
import com.example.carts.domain.Cart;
import com.example.carts.service.CartService;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Title: CartController.java
 * @Author: HSL
 * @Date: 2023/12/14 14:39
 * @Description:
 */

@RestController
@RequestMapping("/cart")
@CrossOrigin
@RequiredArgsConstructor //必备参数的构造函数
public class CartController {
    @Autowired
    private CartService cartService;

//    private final RestTemplate restTemplate;//构造注入

//      private final DiscoveryClient discoveryClient;  //服务发现

    private final UserClient userClient;


    @GetMapping("/all")
    public Result getCartsByUserid(@RequestParam(name="userid",defaultValue = "") int userid)
    {
//        ResponseEntity<Result> response = restTemplate.exchange(
//                "http://localhost:8080/user?userid={userid}",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<Result>(){},
//                userid//为什么不能用urlVariables?
//        );
//
//        Result ans = response.getBody();
//        System.out.println(response.getStatusCode());
//
//        System.out.println(ans.data);
//====
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
//
//        //TODO 检查是否拉取到 使用什么CollUtil工具包
//
//        //TODO 手写负载均衡 random
//        ServiceInstance serviceInstance = instances.get(0); //Alt+enter自动补全返回值
//
//                ResponseEntity<Result> response = restTemplate.exchange(
//                serviceInstance.getUri()+"/user?userid={userid}",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<Result>(){},
//                userid//为什么不能用urlVariables?
//        );
//
//        Result ans = response.getBody();
//        System.out.println(response.getStatusCode());
//
//        System.out.println(ans.data);

        Result user = userClient.selectUserById(userid);

        System.out.println(user.data);

        List<Cart> cartList = cartService.getCartsByUserid(userid);

        return cartList!=null ? new Result(cartList,Code.SELECT_OK,""):new Result(null,Code.SELECT_ERR,"查询失败");
    }
}
