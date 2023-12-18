package com.example.cart.controller;

import com.example.api.client.UserClient;
import com.example.api.entity.Result;
import com.example.cart.domain.Cart;
import com.example.cart.service.CartService;
import com.sun.org.apache.regexp.internal.RE;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Title: CartController.java
 * @Author: HSL
 * @Date: 2023/12/14 14:39
 * @Description:
 */

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor //必备参数的构造函数
public class CartController {
    @Autowired
    private CartService cartService;

//    private final RestTemplate restTemplate;//构造注入

//      private final DiscoveryClient discoveryClient;  //服务发现

    private final UserClient userClient; //注入OpenFeign的Client代理

    @GetMapping("/all")
    public Result getCartsByUserid(@RequestParam(name="userId",defaultValue = "") int userId)
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
//
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

        Result user = userClient.selectUserById(userId);

        System.out.println(user.data);

        List<Cart> cartList = cartService.getCartsByUserid(userId);

        return cartList!=null ? new Result(cartList,Code.SELECT_OK,""):new Result(null,Code.SELECT_ERR,"查询失败");
    }

    @PostMapping("/insert")
    public com.example.cart.controller.Result insertCart(@RequestBody Map<String,String> requestBody)
    {
        int userId = Integer.parseInt(requestBody.get("userId"));
        int itemid = Integer.parseInt(requestBody.get("itemid"));
        int amount = Integer.parseInt(requestBody.get("amount"));

        Cart cart = cartService.getCartsByUserIdAndItemId(userId,itemid);

        if(cart==null)
        {
            boolean flag = cartService.insertCart(userId,itemid,amount);
            return flag ? new com.example.cart.controller.Result(null,Code.UPDATE_OK,"添加购物车成功"):
                    new com.example.cart.controller.Result(null,Code.UPDATE_ERR,"修改购物车失败");
        }else
        {
            return new com.example.cart.controller.Result(null,Code.INSERT_ERR,"商品已在购物车");
        }
    }

    @PutMapping("/updateamount")
    public com.example.cart.controller.Result updateAmount(@RequestParam(name="userId") int userId,
                                                           @RequestParam(name="itemid") int itemid,
                                                           @RequestParam(name="amount") int amount)
    {
        boolean flag = cartService.updateAmount(userId,itemid,amount);
        return flag ? new com.example.cart.controller.Result(null,Code.UPDATE_OK,"修改成功"):
                new com.example.cart.controller.Result(null,Code.UPDATE_ERR,"修改失败");

    }

    @DeleteMapping
    public com.example.cart.controller.Result deleteCart(@RequestParam(name="userId") int userId, @RequestParam(name="itemid") int itemid)
    {
        boolean flag = cartService.deleteCart(userId,itemid);

        return flag? new com.example.cart.controller.Result(null,Code.DELETE_OK,"删除成功"):
                new com.example.cart.controller.Result(null,Code.DELETE_ERR,"删除失败");
    }

}
