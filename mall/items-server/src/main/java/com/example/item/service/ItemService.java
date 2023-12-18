package com.example.item.service;

import com.example.item.domain.Item;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/
public interface ItemService {
    Item selectItemById(int itemid);

    List<Item> getAllItems();

    List<Item> searchItemByType(String type);

    List<Item> searchItemByPrice(int bottom,int top);

    boolean insertItem(String itemname,int price,int stock,String type);
}
