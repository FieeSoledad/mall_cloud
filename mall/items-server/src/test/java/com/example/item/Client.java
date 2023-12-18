package com.example.item;

import com.example.item.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Title: Client.java
 * @Author: HSL
 * @Date: 2023/12/16 14:58
 * @Description:
 */
@SpringBootTest
public class Client {

    @Autowired
    private ItemService itemService;

//    @Test
    public void searchItemByType()
    {
        System.out.println(itemService.searchItemByType("电子"));
    }

//    @Test
    public void searchItemByPrice()
    {
        System.out.println(itemService.searchItemByPrice(100,400));
    }

    @Test
    public void insertItem()
    {
        System.out.println(itemService.insertItem("篮球",280,50,"运动和户外用品"));
    }
}
