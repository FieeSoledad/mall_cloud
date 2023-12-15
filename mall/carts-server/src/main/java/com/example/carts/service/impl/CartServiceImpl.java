package com.example.carts.service.impl;

import com.example.carts.dao.CartDao;
import com.example.carts.domain.Cart;
import com.example.carts.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: CartServiceImpl.java
 * @Author: HSL
 * @Date: 2023/12/14 14:40
 * @Description:
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired(required=true)
    private CartDao cartDao;

    @Override
    public List<Cart> getCartsByUserid(int userid) {
        return cartDao.getCartsByUserId(userid);
    }
}
