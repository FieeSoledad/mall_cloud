package com.example.cart;

import com.example.cart.dao.CartDao;
import com.example.cart.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Title: Client.java
 * @Author: HSL
 * @Date: 2023/12/16 16:04
 * @Description:
 */

@SpringBootTest
public class Client {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartDao cartDao;

//    @Test
    public void insertCart()
    {
        System.out.println(cartService.insertCart(1,1,100));
    }

//    @Test
    public void deleteCart()
    {
        System.out.println(cartService.deleteCart(1,1));
    }

//    @Test
    public void updateAmount()
    {
        System.out.println(cartService.updateAmount(1,3,10));
    }

//    @Test
    public void selectCartByUserIdAndItemId()
    {
        System.out.println(cartService.getCartsByUserIdAndItemId(2,8));
    }

    @Test
    public void getCartUAIDao()
    {
        System.out.println(cartDao.getCartsByUserIdAndItemId(2,8)==null);
    }
}
