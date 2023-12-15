package com.example.items.service;

import com.example.items.domain.Item;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/
public interface ItemService {
    Item selectItemById(int itemid);

    List<Item> getAllItems();
}
