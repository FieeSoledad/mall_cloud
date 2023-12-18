package com.example.cart.service.impl;

import com.example.cart.dao.CartDao;
import com.example.cart.domain.Cart;
import com.example.cart.service.CartService;
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

    @Override
    public boolean insertCart(int userId, int itemid, int amount) {
        return cartDao.insertCart(userId,itemid,amount)==1;
    }

    @Override
    public boolean deleteCart(int userId, int itemid) {
        return cartDao.deleteCart(userId,itemid)==1;
    }

    @Override
    public boolean updateAmount(int userId, int itemid, int amount) {
        return cartDao.updateAmount(userId,itemid,amount)==1;
    }

    @Override
    public Cart getCartsByUserIdAndItemId(int userId, int itemid) {
        return cartDao.getCartsByUserIdAndItemId(userId,itemid);
    }
}
