package com.example.item.dao;

import com.example.item.domain.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/
@Repository
public interface ItemDao {
    Item selectItemById(int itemid);

    List<Item> getAllItems();

    List<Item> searchItemByType(String type);

    List<Item> searchItemByPrice(@Param("bottom")int bottom,@Param("top") int top);

    int insertItem(@Param("itemname") String itemname,@Param("price") int price,@Param("stock") int stock,@Param("type") String type);
}
