package com.example.items.service.Impl;

import com.example.items.dao.ItemDao;
import com.example.items.domain.Item;
import com.example.items.service.ItemService;
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
}
