package com.example.items.dao;

import com.example.items.domain.Item;
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
}
