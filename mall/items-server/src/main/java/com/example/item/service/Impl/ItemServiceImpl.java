package com.example.item.service.Impl;

import com.example.item.dao.ItemDao;
import com.example.item.domain.Item;
import com.example.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: ItemServiceImpl.java
 * @Author: HSL
 * @Date: 2023/12/13 15:43
 * @Description:
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public Item selectItemById(int itemid) {
        return itemDao.selectItemById(itemid);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public List<Item> searchItemByType(String type) {
        return itemDao.searchItemByType(type);
    }

    @Override
    public List<Item> searchItemByPrice(int bottom, int top) {
        return itemDao.searchItemByPrice(bottom,top);
    }

    @Override
    public boolean insertItem(String itemname, int price, int stock, String type) {
        return itemDao.insertItem(itemname,price,stock,type)==1;
    }
}
