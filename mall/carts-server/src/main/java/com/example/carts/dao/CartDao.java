package com.example.carts.dao;

import com.example.carts.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/
@Repository
public interface CartDao {
    List<Cart> getCartsByUserId(int userid);
}
