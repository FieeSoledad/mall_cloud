package com.example.cart.service;

import com.example.cart.domain.Cart;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/
public interface CartService {
    List<Cart> getCartsByUserid(int userid);

    boolean insertCart(int userId,int itemid,int amount);

    boolean deleteCart(int userId,int itemid);

    boolean updateAmount(int userId,int itemid,int amount);

    Cart getCartsByUserIdAndItemId(int userId, int itemid);
}
