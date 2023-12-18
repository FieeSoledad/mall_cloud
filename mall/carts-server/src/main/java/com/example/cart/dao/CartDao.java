package com.example.cart.dao;

import com.example.cart.domain.Cart;
import org.apache.ibatis.annotations.Param;
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

    int insertCart(@Param("userId") int userId,@Param("itemid") int itemid,@Param("amount") int amount);

    int deleteCart(@Param("userId") int userId,@Param("itemid") int itemid);

    int updateAmount(@Param("userId") int userId,@Param("itemid") int itemid,@Param("amount") int amount);

    Cart getCartsByUserIdAndItemId(@Param("userId") int userId,@Param("itemid") int itemid);

}
