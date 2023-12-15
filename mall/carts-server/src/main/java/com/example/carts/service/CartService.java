package com.example.carts.service;

import com.example.carts.domain.Cart;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/
public interface CartService {
    List<Cart> getCartsByUserid(int userid);
}
